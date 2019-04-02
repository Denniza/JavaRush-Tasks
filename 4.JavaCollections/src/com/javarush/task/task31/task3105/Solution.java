package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(args[1]);
        ZipInputStream zipIn = new ZipInputStream(in);
        Map<String, ByteArrayOutputStream> list = new HashMap<>();
        ZipEntry entry;
        while ((entry = zipIn.getNextEntry())!= null){
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte [] data = new byte[1024];
            int count=0;
            while ((count = zipIn.read(data))!=-1)
                outputStream.write(data,0,count);
            list.put(entry.getName(), outputStream);
            zipIn.closeEntry();
        }
        zipIn.close();

        FileOutputStream zipFile = new FileOutputStream(args[1]);
        ZipOutputStream zip = new ZipOutputStream(zipFile);
        for(Map.Entry s:list.entrySet()){
            if(!s.getKey().toString().equals(args[0])) {
                ZipEntry zipData = new ZipEntry(s.getKey().toString());
                zip.putNextEntry(zipData);
                zip.write(s.getValue().toString().getBytes());
                zip.closeEntry();
            }
        }
        zip.putNextEntry(new ZipEntry("new/" + args[0]));
        Files.copy(Paths.get(args[0]),zip);
        zip.close();
        zip.close();
    }
}
