package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File myFile = null;
            myFile = File.createTempFile("text.tmp", null);

            ObjectOutputStream out = null;

            out = new ObjectOutputStream(new FileOutputStream(myFile));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(myFile));
            Solution savedObject = new Solution(4);
            out.writeObject(savedObject);
            Solution loadedObject = (Solution) in.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
            System.out.println(loadedObject.toString());
            System.out.println(new Solution(4));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(){

    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

}
