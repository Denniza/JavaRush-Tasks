package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        String text = "";
        while (reader.ready()){
            text +=(char) reader.read();
        }

        String [] elements = text.split("\\s");

        HashMap<String , Double> map = new HashMap<>();

       for (int i = 0; i < elements.length; i = i+2){
            if(map.containsKey(elements[i])){
                map.replace(elements[i],map.get(elements[i]),map.get(elements[i]) + Double.parseDouble(elements[i+1]));
            } else map.put(elements[i],Double.parseDouble(elements[i+1]));
        }

        reader.close();

        Set <String> set = map.keySet();
        String [] keys = set.toArray(new String[0]);
        Arrays.sort(keys);
        for (int i =0 ; i < keys.length; i++) {
            System.out.println(keys[i] + " " + map.get(keys[i]));
        }

    }
}
