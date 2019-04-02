package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        String letter = "abcdefghijklmnopqrstuvxwyz";
        String UpperLetter = letter.toUpperCase();
        String number = "0123456789";
        String allLetters = letter + UpperLetter + number;
        char [] password = new char[8];
        password[0] = letter.charAt((int) (Math.random()*letter.length()));
        password[1] = UpperLetter.charAt((int) (Math.random()*UpperLetter.length()));
        password[2] = number.charAt((int) (Math.random()*number.length()));
        for(int i=3; i<password.length;i++){
            password[i] = allLetters.charAt((int) (Math.random()*allLetters.length()));
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Collections.shuffle(Arrays.asList(password));
        String result = new String(password);
        out.write(result.getBytes());
        return out;
    }
}