package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));
        Pattern p = Pattern.compile("^\\d+$");
        String text = "";
        while (in.ready()) {
            int b = in.read();
            char c = (char) b;
            text += c;
        }
        String[] text2 = text.split(" ");

        for (int i = 0; i < text2.length; i++) {
            Matcher m = p.matcher(text2[i]);
            if (m.find()) {
                out.write(text2[i]);
                out.write(" ");
            }
        }
            in.close();
            out.close();

    }
}
