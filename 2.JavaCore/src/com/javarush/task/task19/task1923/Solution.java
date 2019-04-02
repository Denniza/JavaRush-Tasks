package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader in = new BufferedReader(reader);
        FileWriter writer = new FileWriter(args[1]);
        Pattern p = Pattern.compile("\\b[\\S]*[\\d]+[\\S]*\\b");
        while (in.ready()) {
            String line = in.readLine();
            String[] result = line.split(" ");
            for (int i = 0; i < result.length; i++) {

                Matcher m = p.matcher(result[i]);
                if (m.matches()) {
                    writer.write(result[i] + " ");
                }
            }
        }
        reader.close();
        in.close();
        writer.close();

    }
}
