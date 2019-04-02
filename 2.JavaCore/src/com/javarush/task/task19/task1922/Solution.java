package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        FileReader in1 = new FileReader(file);
        BufferedReader in = new BufferedReader(in1);

        while (in.ready()){
            String line = in.readLine();
            int c = 0;
            String [] result = line.split(" ");
            for (int i=0; i < result.length; i++){
                for (int a = 0; a < words.size(); a++){
                    if (result[i].equals(words.get(a))){
                        c++;
                        break;
                    }

                }
            }
            if (c!=2) continue;
            System.out.println(line);
        }
        reader.close();
        in1.close();
        in.close();
    }
}
