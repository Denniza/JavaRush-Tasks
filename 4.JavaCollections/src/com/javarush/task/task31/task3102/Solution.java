package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayDeque<File> que = new ArrayDeque<>();
        ArrayList<String> files = new ArrayList<>();

        File file = new File(root);
        que.add(file);
        while (!que.isEmpty()){
            File directory = new File(que.getLast().getAbsolutePath());
            que.removeLast();
            for(File name:directory.listFiles()){
                if(name.isDirectory()) que.addFirst(name);
                else files.add(name.getAbsolutePath());
            }
        }

        return files;

    }

    public static void main(String[] args) {
        
    }
}
