package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        public Person read() throws ParseException {
            Person person = null;
                while (fileScanner.hasNextLine()){
                String a = fileScanner.nextLine();

                String[] b = a.split(" ");
                String birthday = b[3] +" " + b[4]+ " " + b[5];
                SimpleDateFormat newDate = new SimpleDateFormat("dd MM yyyy");
                Date date = newDate.parse(birthday);
                person = new Person(b[1], b[2],b[0],date);
                break;
            }
            return person;
        }

        public void close(){
            fileScanner.close();
        }


    }
}
