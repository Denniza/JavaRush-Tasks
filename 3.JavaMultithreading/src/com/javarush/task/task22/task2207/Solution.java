package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));

        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (reader1.ready()){
            builder.append(reader1.readLine()+ " ");
        }
        list.addAll(Arrays.asList(builder.toString().replace("\uFEFF", "").split(" ")));
        for (int i=0; i < list.size();i++) {
            String f = new StringBuilder(list.get(i)).reverse().toString();
            for (int j = i + 1; j < list.size(); j++) {
                if (f.equals(list.get(j))) {
                    Pair p1 = new Pair(list.get(i), list.get(j));
                    Pair p2 = new Pair(list.get(j), list.get(i));
                    if (!result.contains(p1) && !result.contains(p2)) {
                        result.add(p1);
                    }
                }
            }
        }


        for (Pair s: result){
            System.out.println(s.first+ " " + s.second);
        }
        reader.close();
        reader1.close();
    }

    public static class Pair {
        String first;
        String second;

        public Pair(){
        }

        public Pair(String a, String b){
            this.first=a;
            this.second = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
