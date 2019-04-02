package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {


    public static void main(String[] args) throws IOException {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File result = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, result);
        FileOutputStream out = new FileOutputStream(result,true);
        out.close();
        ArrayList<File> list = new ArrayList<>();
        Solution.fileSearcher(path.getAbsolutePath(),list);

        list.sort(new FileNameComparator());

        for (File s : list) {
            FileInputStream in = new FileInputStream(s);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            String a = "\n";
            out.write(a.getBytes());
            in.close();
        }
        out.close();

    }

    private static void fileSearcher(String path, List list) {
        File file = new File(path);
        if (file.isDirectory()) {
            for(File name:file.listFiles()){
                if(name.isFile()&&name.length()<=50) list.add(name);
                else fileSearcher(name.getAbsolutePath(),list);
            }
        } else {
            if(file.length()<=50) list.add(file);
        }
    }

    public static class FileNameComparator implements Comparator<File>{
        public int compare(File first, File second){
            return first.getName().compareTo(second.getName());
        }
    }
}
