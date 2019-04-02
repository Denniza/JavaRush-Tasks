package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer tokinazer = new StringTokenizer(query,delimiter);
        ArrayList<String> result = new ArrayList<>();

        while(tokinazer.hasMoreTokens()){
            result.add(tokinazer.nextToken());
        }
        String [] a =result.toArray(new String[result.size()]);
        return a;
    }
}
