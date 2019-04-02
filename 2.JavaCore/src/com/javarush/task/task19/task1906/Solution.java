package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader reader1 = new FileReader(file1);

        FileWriter writer = new FileWriter(file2);
        int i = 0;
        while (reader1.ready()){
            int data = reader1.read();
            if (i%2>0){
                writer.write(data);
                i++;
            } else i++;
        }
        reader1.close();
        writer.close();
    }
}
