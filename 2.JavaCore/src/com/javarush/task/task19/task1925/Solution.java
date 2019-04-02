package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

                int a = 0;
                while (bufferedReader.ready()){
                    String line = bufferedReader.readLine();
                    String [] result = line.split(" ");

                    for (int i=0; i < result.length; i++){
                        if (result[i].length() > 6){
                            if (a != 0) bufferedWriter.write(",");
                            bufferedWriter.write(result[i]);
                            a = 1;
                        }
                    }
                }
        bufferedReader.close();
                bufferedWriter.close();
                reader.close();
                writer.close();
    }
}
