package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));
        String text = "";
        while (in.ready()){
            text += (char) in.read();
        }
        String result = text.toString().replaceAll("[\\W&&[^\\s]]","");
        out.write(result);

        out.close();
        in.close();
        reader.close();
    }
}
