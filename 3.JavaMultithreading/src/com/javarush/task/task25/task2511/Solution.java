package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println(throwable.getMessage().replaceAll(thread.getName(),thread.getName().replaceAll(".","*")));
            }
        }//init handler he
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new MyUncaughtExceptionHandler();

        //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Thread(new Solution(new TimerTask() {
            @Override
            public void run() {
                throw  new Error();
            }
        })).start();
    }
}