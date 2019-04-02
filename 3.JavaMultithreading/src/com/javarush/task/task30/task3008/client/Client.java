package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;
    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник " + userName + " присоеденился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник " + userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{

            while(true){
                Message message = connection.receive();
                if(message.getType()==MessageType.NAME_REQUEST){
                    String name =  getUserName();
                    connection.send(new Message(MessageType.USER_NAME,name));
                } else if(message.getType()==MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                } else throw new IOException("Unexpected MessageType");

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if(message.getType()==MessageType.TEXT) processIncomingMessage(message.getData());
                else if(message.getType()==MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                else if(message.getType()==MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                else throw new IOException("Unexpected MessageType");
                
            }
        }

        public void run(){
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }

        }

    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                wait();
                if(clientConnected){
                   ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                } else System.out.println("Произошла ошибка во время работы клиента.");
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Ошибка");
            }
            while (clientConnected){
                String text = ConsoleHelper.readString();
                if(text.equals("exit")) break;
                else if(shouldSendTextFromConsole()) sendTextMessage(text);
            }
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        System.out.println("Введите адрес сервера:");
            String address = ConsoleHelper.readString();
        return address;
    }

    protected int getServerPort(){
        System.out.println("Введите порт");
        int port = 0;
            port = ConsoleHelper.readInt();

        return port;
    }

    protected String getUserName(){
        System.out.println("Введите имя пользователя");
        String userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }

    protected void sendTextMessage(String text){
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            clientConnected = false;
            System.out.println("Ошибка отправки сообщения");
        }
    }
}
