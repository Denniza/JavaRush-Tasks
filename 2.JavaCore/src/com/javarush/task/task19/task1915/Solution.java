package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consolestream = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream mystream = new PrintStream(output);

        System.setOut(mystream);

        testString.printSomething();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        reader.close();
        FileOutputStream fileOutput = new FileOutputStream(file);

        String resiult = output.toString();
        fileOutput.write(resiult.getBytes());

        fileOutput.close();

        System.setOut(consolestream);

        System.out.println(resiult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

