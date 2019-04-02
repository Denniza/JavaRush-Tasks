package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader in1 = new FileReader(file1);
        BufferedReader in3 = new BufferedReader(in1);
        FileReader in2 = new FileReader(file2);
        BufferedReader in4 = new BufferedReader(in2);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String s1 = null;
        String s2 = null;
        while (in3.ready()) {
            s1 = in3.readLine();
            list1.add(s1);
        }
        while (in4.ready()) {
            s2 = in4.readLine();
            list2.add(s2);
        }
        System.out.println(list1.size());
        String s2next = null;
        int a = list1.size() > list2.size()? 0:1;
        for (int i = 1,j = 1;; ) {
            LineItem item = null;
            try { s1 = list1.get(i-1);
                s2 = list2.get(j-1);
            }
            catch (Exception e) {
                if (list1.size() == list2.size()){
                    break;}
                    else if (a==0){
                item = new LineItem(Type.ADDED, list2.get(j-1));
                lines.add(item);
                break;}
                else {
                item = new LineItem(Type.REMOVED, s1);
                lines.add(item);
                break;
                }
            }
            if (s1.equals(s2)) {
                item = new LineItem(Type.SAME, s1);
                lines.add(item);
                i++;
                j++;
            } else {
                String s1next =null;
                try{
                s1next = list1.get(i);
                s2next = list2.get(j);}
                catch (Exception e){
                    s1next = null;
                    s2next = null;
                }
                if (s1.equals(s2next)) {
                    item = new LineItem(Type.ADDED, list2.get(j-1));
                    lines.add(item);
                    j++;
                } else {
                    item = new LineItem(Type.REMOVED, s1);
                    lines.add(item);
                    i++;
                }
            }
        }
            reader.close();
            in1.close();
            in2.close();
            in3.close();
            in4.close();
            for (LineItem s : lines) {
                System.out.println(s.type.toString() + " " + s.line);
            }
        }


        public static enum Type {
            ADDED,        //добавлена новая строка
            REMOVED,      //удалена строка
            SAME          //без изменений
        }

        public static class LineItem {
            public Type type;
            public String line;

            public LineItem(Type type, String line) {
                this.type = type;
                this.line = line;
            }
        }
    }

