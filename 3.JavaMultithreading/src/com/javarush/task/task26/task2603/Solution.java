package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            comparators= vararg;
        }


        @Override
        public int compare(Object o, Object t1) {
            int result=0;
            for(Comparator<T> a:comparators){
                result = a.compare((T)o, (T)t1);
                if(result!=0) break;
            }
            return result;
        }

    }


    public static void main(String[] args) {

    }
}
