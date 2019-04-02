package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string==null) throw  new TooShortStringException();
        int space = string.indexOf(" ");
        String result = string.substring(space + 1);
        Pattern p = Pattern.compile("\\S* \\S* \\S* \\S*");
        Matcher m = p.matcher(result);
        if (m.find()) {
            return m.group();
        } else {
            throw new TooShortStringException();
        }
    }
    public static class TooShortStringException extends RuntimeException {
    }
}
