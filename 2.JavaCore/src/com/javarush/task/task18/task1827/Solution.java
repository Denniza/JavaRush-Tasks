package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0|| !args[0].equals("-c")) {
            System.out.println("Введите корректные значения");
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            ArrayList<Integer> ides = new ArrayList<>();
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader reader1 = new BufferedReader(new FileReader(file));
            while(reader1.ready()){
                String line = reader1.readLine();
                lines.add(line);
            }
                if (lines.size() != 0) {
                    for (String s : lines) {
                        ides.add(Integer.parseInt(s.substring(0, 8).trim()));
                    }
                    ides.sort(null);
                    int MaxId = ides.get(ides.size() - 1);
                    PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
                    out.write(String.format("%n%.8s%.30s%.8s%.4s%n", Integer.toString(MaxId + 1) + "        ", args[1] + "                              ",
                            args[2] + "        ", args[3] + "     "));
                    out.close();
                } else {
                    PrintWriter out = new PrintWriter(new FileWriter(file));
                    out.write(String.format("%n%.8s%.30s%.8s%.4s", "1        ", args[1] + "                              ",
                            args[2] + "        ", args[3] + "    "));
                    out.close();
                }
                reader.close();
                reader1.close();

        }

    }
}
