package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
        test("A","B");
    }

    public static void test(String... str){
        System.out.println("A");
    }
    public static void test(String a, String b){
        System.out.println("b");
    }
    public static void test(String a, String... str){
        System.out.println("C");
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter result = new StringWriter();
        int c=0;
        if(reader==null) return "";
        while((c = reader.read())!=-1){
            result.append((char) (c + key));
        }

        return result.toString();
    }
}
