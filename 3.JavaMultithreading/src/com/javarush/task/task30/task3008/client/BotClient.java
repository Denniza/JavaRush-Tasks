package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {
    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message.contains(": ")&&message!=null){
            String [] text = message.split(":");
            String name= text[0].trim();
            String messageText = text[1].trim();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
            Date date = Calendar.getInstance().getTime();
            if(messageText.equals("дата")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("день")){
                simpleDateFormat.applyPattern("d");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("месяц")){
                simpleDateFormat.applyPattern("MMMM");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("год")){
                simpleDateFormat.applyPattern("YYYY");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("время")){
                simpleDateFormat.applyPattern("H:mm:ss");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("час")){
                simpleDateFormat.applyPattern("H");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("минуты")){
                simpleDateFormat.applyPattern("m");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            } else if(messageText.equals("секунды")){
                simpleDateFormat.applyPattern("s");
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat.format(date)));
            }
            }

        }
    }
}
