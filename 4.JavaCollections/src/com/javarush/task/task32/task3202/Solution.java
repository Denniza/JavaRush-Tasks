package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if(is==null) return new StringWriter();
        BufferedInputStream input = new BufferedInputStream(is);
        StringWriter result = new StringWriter();
        int c=0;
        while((c= input.read())!=-1){
            result.write(c);
        }
        return result;
    }
}