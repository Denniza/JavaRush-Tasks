package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf("?");
        String result = url.substring(index+1);
        String [] parameters = result.split("&");
        Pattern p = Pattern.compile("obj=.*");
        String obj = null;

        for (String s:parameters){
            if (s.contains("=")){
                System.out.print(s.substring(0,s.indexOf("=")) + " ");
                Matcher m = p.matcher(s);
                if (m.matches()){
                    obj = s.substring(s.indexOf("=")+1);
                }

            } else System.out.print(s + " ");

        }
        if (obj!=null) {
            System.out.println("");
                double chislo = 0;
                try{
                    chislo = Double.parseDouble(obj);
                    alert(chislo);
                } catch (Exception e){
                    alert(obj);
                }
            }
        }

        //add your code here

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
