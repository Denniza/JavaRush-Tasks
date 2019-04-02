package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileOutputStream out = new FileOutputStream(args[0]);
        List<String> nameFiles = new ArrayList<>();
        Vector <InputStream> inputList = new Vector<>();
        for (int i = 1; i < args.length; i++) {
            nameFiles.add(args[i]);
        }
        Collections.sort(nameFiles);
        for(String s:nameFiles){
            InputStream in = new FileInputStream(s);
            inputList.add(in);
        }
        ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream((inputList).elements()));
        zipIn.getNextEntry();
        byte [] buffer= new byte[1024];
        int count;
        while((count = zipIn.read(buffer))>0){
            out.write(buffer,0,count);
            out.flush();
        }
        zipIn.closeEntry();
        out.close();
        zipIn.close();
    }
}
