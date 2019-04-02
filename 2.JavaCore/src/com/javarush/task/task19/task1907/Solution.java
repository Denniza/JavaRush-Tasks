package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        reader.close();

        FileReader input = new FileReader(file);
        String text = "";
        while (input.ready()){
            text += (char)input.read();
        }
        String [] words = text.split("\\W");
        Pattern pattern = Pattern.compile("^world$");
        Matcher m = null;
        int count = 0;
        for (int i = 0; i<words.length; i++){
            m = (Matcher) pattern.matcher(words[i]);
            if (m.find()) count++;
        }
        input.close();
        System.out.println(count);

    }
}
