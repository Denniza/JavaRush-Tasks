package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        int count=0;
        for (Map.Entry s:params.entrySet()){
            if (s.getKey()!=null && s.getValue()!=null){
                if (count!=0) result.append(" and ");
                result.append(s.getKey() + " = " + '\'' + s.getValue() + '\'');
                count++;
            }
        }

        return result.toString();
    }
}
