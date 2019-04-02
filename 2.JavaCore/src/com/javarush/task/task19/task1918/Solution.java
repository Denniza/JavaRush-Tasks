package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileReader fileReader = new FileReader(file);
        BufferedReader in = new BufferedReader(fileReader);
        StringBuilder result = new StringBuilder();
        while (in.ready()){
            result.append(in.readLine());
        }
        String resultString = result.toString().trim();
        Document doc = Jsoup.parse(resultString,"re", Parser.xmlParser());
        Elements element = doc.select(args[0]);
        for (Element elements :element){
            System.out.println(elements);
        }
        in.close();
        fileReader.close();
        reader.close();
    }
}
