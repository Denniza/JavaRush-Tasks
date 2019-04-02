package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream stream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ourstream = new PrintStream(outputStream);
        System.setOut(ourstream);
        testString.printSomething();

        String result = outputStream.toString().replaceAll("te", "??");

        System.setOut(stream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
