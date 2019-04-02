package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }
    public static void serializeStaticState(ObjectOutputStream os) throws IOException{
        os.writeObject(ClassWithStatic.staticString);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException, ClassNotFoundException {
        ClassWithStatic.staticString = (String) os.readObject();
    }

    public static void main(String[] args) {

    }
}
