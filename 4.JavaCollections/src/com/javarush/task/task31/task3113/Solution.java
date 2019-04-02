package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.SimpleFileVisitor;

/* 
Что внутри папки?
*/
public class Solution {

     public static class SearchFileVisitor extends SimpleFileVisitor<Path>{
         private int  countFiles =0;
         private int countDirectories = -1;
         private long size = 0;

         public int getCountFiles() {
             return countFiles;
         }

         public int getCountDirectories() {
             return countDirectories;
         }

         public long getSize() {
             return size;
         }
         @Override
         public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException{
             if(Files.isRegularFile(file)){
                 countFiles++;
                 size = size + Files.size(file);
             }
             return super.visitFile(file,attrs);
         }

         @Override
         public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
             countDirectories++;
             return super.postVisitDirectory(path, e);
         }
     }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path file = Paths.get(reader.readLine());
        if(!Files.isDirectory(file)) System.out.println(file.toAbsolutePath().toString() + " - не папка");
        else{
            SearchFileVisitor visitor = new SearchFileVisitor();
            Files.walkFileTree(file,visitor);
            System.out.println("Всего папок - " + visitor.getCountDirectories());
            System.out.println("Всего файлов - " + visitor.getCountFiles());
            System.out.println("Общий размер - " + visitor.getSize());
        }

    }
}
