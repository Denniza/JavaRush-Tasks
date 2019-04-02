package com.javarush.task.task25.task2504;

/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {

        for(Thread a: threads){
            switch (a.getState()) {
                case NEW:
                    a.start();
                    break;
                case WAITING:
                    a.interrupt();
                    break;
                case RUNNABLE:
                    a.isInterrupted();
                    break;
                case BLOCKED:
                    a.interrupt();
                    break;
                case TIMED_WAITING:
                    a.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(a.getPriority());
                    break;

            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
