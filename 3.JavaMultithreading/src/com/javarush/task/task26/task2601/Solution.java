package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        int median;
        Arrays.sort(array);
        if(array.length%2==0)
            median = (array[array.length/2]+array[array.length/2-1])/2;
        else
            median = array[array.length/2];
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return Math.abs(median-integer) - Math.abs(median-t1);
            }
        });//implement logic here
        return array;
    }
}
