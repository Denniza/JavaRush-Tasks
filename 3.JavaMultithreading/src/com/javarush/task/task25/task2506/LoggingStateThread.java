package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;


    public LoggingStateThread(Thread thread){
        this.thread = thread;
        setDaemon(true);

    }
    public void run(){
        State start = thread.getState();
        System.out.println(start);
        while(true) {
            if (thread.getState() != start) {
                start = thread.getState();
                System.out.println(start);
            }
            if (start == State.TERMINATED) {
                break;
            }
        }
    }
}
