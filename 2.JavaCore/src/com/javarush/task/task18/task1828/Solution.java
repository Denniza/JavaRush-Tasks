package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            if (!args[0].equals("-d") && !args[0].equals("-u")) {
                System.out.println("Введите корректные значения");
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String file = reader.readLine();
                ArrayList<String> lines = new ArrayList<>();
                BufferedReader reader1 = new BufferedReader(new FileReader(file));
                if (args[0].equals("-u")) {
                    while (reader1.ready()) {
                        String line = reader1.readLine();
                        if (line.substring(0, 8).trim().equals(args[1])) {
                            line = String.format("%-8s%-30s%-8s%-4s", args[1], args[2],
                                    args[3], args[4]);
                        }
                        lines.add(line);
                    }
                    PrintWriter out = new PrintWriter(new FileOutputStream(file));
                    for (String s : lines) {
                        out.write(s + "\n");
                    }
                    out.close();
                } else {
                    while (reader1.ready()) {
                        String line = reader1.readLine();
                        if (line.substring(0, 8).trim().contains(args[1])) {
                            continue;
                        }
                        lines.add(line);
                    }
                    PrintWriter out = new PrintWriter(new FileOutputStream(file));
                    for (String s : lines) {
                        out.write(s + "\n");

                    }
                    out.close();

                }
                reader.close();
                reader1.close();
            }
        }
    }
}

