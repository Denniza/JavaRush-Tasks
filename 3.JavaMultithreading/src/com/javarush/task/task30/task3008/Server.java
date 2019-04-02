package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

//        Метод устанавливает соединение с клиентом и запрашивает его имя и принимает его
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName = null;
            Message request = new Message(MessageType.NAME_REQUEST);
                while (true) {
                    connection.send(request);
                    Message message = connection.receive();
                    userName = message.getData();
                    if (message.getType() == MessageType.USER_NAME&&!userName.isEmpty()
                            &&!connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            return userName;
        }

//        Метод отправляет всем участникам чата информацию о том, что добавился новый пользователь
        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String,Connection> entry:connectionMap.entrySet()){
                if(!entry.getKey().equals(userName)){
                    Message message = new Message(MessageType.USER_ADDED,entry.getKey());
                    connection.send(message);
                }
            }
        }
//        Основная логика сервера, рассылка всем участникам сообщения от пользователя
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = String.format("%s: %s", userName, message.getData());
                    message = new Message(MessageType.TEXT, text);
                    sendBroadcastMessage(message);
                } else {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }

        public void run(){
            ConsoleHelper.writeMessage("Установлено соединение с адресом:" + socket.getRemoteSocketAddress());
            String userName="";
            try(Connection connection=new Connection(socket);) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e ) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными м удаленным сервером");
            } 
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с сервером закрыто");

        }
    }


    public static void sendBroadcastMessage(Message message){
        try{
            for(Map.Entry<String,Connection> element:connectionMap.entrySet()){
                element.getValue().send(message);
            }
        }catch (IOException e){
            System.out.println("Сообщение не отправлено");
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен.");
            while (true){
                Socket connection =  serverSocket.accept();
                Handler handler = new Handler(connection);
                handler.start();
            }
        } catch (IOException e) {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        }


    }
}
