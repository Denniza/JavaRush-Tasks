package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution sol1 = new Solution();
        sol1.innerClasses = new InnerClass[]{sol1.new InnerClass(), sol1.new InnerClass()};
        Solution sol2 = new Solution();
        sol2.innerClasses = new InnerClass[]{sol2.new InnerClass(), sol2.new InnerClass()};
        Solution [] result = {sol1,sol2};

        return result;
    }

    public static void main(String[] args) {

    }
}
