package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String text = outputStream.toString().trim();

        String [] result = text.split(" ");

        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);
        int c = 0;
        switch (result[1]){
            case "+": c = a+b; break;
            case "-": c = a - b; break;
            case "*": c = a*b; break;
        }

        System.setOut(stream);

        System.out.println(String.format("%s %s %s = %s",result[0],result[1],result[2],String.valueOf(c)));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

