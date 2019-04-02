package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));
        StringBuilder text = new StringBuilder();
        while (in.ready()){
            text.append(in.readLine());
            if (in.ready())text.append("\n");
        }
        String result = text.toString().replace('.','!');
        out.write(result);

        reader.close();
        in.close();
        out.close();
    }
}
