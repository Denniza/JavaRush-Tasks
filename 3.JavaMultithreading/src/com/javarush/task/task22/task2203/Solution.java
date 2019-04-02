package com.javarush.task.task22.task2203;

import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null||(string.indexOf("\t") == string.lastIndexOf("\t"))){
            throw new TooShortStringException();
        }
        int firstTab, secondTab;

        firstTab = string.indexOf("\t");
        secondTab = string.indexOf("\t",firstTab+1);



        return string.substring(firstTab+1,secondTab);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString(null));
    }
}
