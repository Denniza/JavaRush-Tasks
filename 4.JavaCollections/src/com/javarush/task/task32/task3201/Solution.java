package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile file = new RandomAccessFile(args[0],"rw");
        byte [] data = args[2].getBytes();
        int number = Integer.parseInt(args[1]);
        if(file.length()< data.length+number){
            file.seek(file.length());
            file.write(data);
            file.close();
        } else {
            file.seek(number);
            file.write(data);
            file.close();
        }


    }
}
