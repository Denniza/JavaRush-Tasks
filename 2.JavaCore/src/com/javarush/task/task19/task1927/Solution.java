package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
        PrintStream ourstream = new PrintStream(outputstream);

        System.setOut(ourstream);

        testString.printSomething();

        String text = outputstream.toString();
        String [] result = text.split("\n");

        System.setOut(consoleStream);
        int count = 1;
        for (int i =0; i < result.length; i++){
            System.out.println(result[i]);
            if (count%2==0) System.out.println("JavaRush - курсы Java онлайн");
            count++;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
