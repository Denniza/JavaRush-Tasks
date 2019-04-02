package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            char [] array = line.toCharArray();

            for (int i = array.length-1; i>=0; i--){
                System.out.print(array[i]);
            }
            System.out.println("");
        }

        reader.close();
        fileReader.close();
        bufferedReader.close();
    }
}
