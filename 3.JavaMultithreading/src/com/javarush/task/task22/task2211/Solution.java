package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        InputStream reader = new FileInputStream(args[0]);
        OutputStream out = new FileOutputStream(args[1]);
        byte [] buffer= new byte[1000];
        while (reader.available()>0){
            reader.read(buffer);
            String a = new String(buffer, "Windows-1251");
            buffer = a.getBytes("UTF-8");
            out.write(buffer);
        }
    }
}
