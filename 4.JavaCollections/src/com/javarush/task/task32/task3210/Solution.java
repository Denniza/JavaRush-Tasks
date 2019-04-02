package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile file = new RandomAccessFile(args[0],"rw");
        String text = new String(args[2].getBytes());
        int number = Integer.parseInt(args[1]);
        byte [] buffer = new byte[text.length()];
        file.seek(number);
        file.read(buffer,0,text.length());
        String result = new String(buffer);
        System.out.println(result);
        if(text.equals(result)){
            file.seek(file.length());
            file.write("true".getBytes());
            file.close();
        } else{
            file.seek(file.length());
            file.write("false".getBytes());
            file.close();
        }
    }
}
