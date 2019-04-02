package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        FileReader fileReader = new FileReader(file);

        StringBuilder result = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Pattern p = Pattern.compile("1?[0-9]");
        while (bufferedReader.ready()){

            String line = bufferedReader.readLine();

            String [] resultstring = line.split(" ");
            for (int i =0; i < resultstring.length; i++){
                Matcher m = p.matcher(resultstring[i]);
                if (m.matches()){
                    int a = Integer.parseInt(resultstring[i]);
                    resultstring[i] = map.get(a);
                }
                result.append(resultstring[i]).append(" ");
            }
            result.append("\n");
        }
        System.out.print(result.toString());
        bufferedReader.close();
        fileReader.close();
        reader.close();
    }
}
