package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            try {
                List<String> list = Arrays.asList(loadWheelNamesFromDB());
                if(loadWheelNamesFromDB().length>4) throw new Exception();
                Wheel left = Wheel.valueOf(list.get(0));
                Wheel rught = Wheel.valueOf(list.get(1));
                Wheel backLeft = Wheel.valueOf(list.get(2));
                Wheel backRight = Wheel.valueOf(list.get(3));
                wheels = new ArrayList<>();
                wheels.add(left);
                wheels.add(rught);
                wheels.add(backLeft);
                wheels.add(backRight);
            } catch (IllegalArgumentException e) {
                throw  new Exception();
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
