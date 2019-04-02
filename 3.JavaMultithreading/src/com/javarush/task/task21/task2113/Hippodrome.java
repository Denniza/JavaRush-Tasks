package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List a){
        horses = a;
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        for(Horse s:horses){
            if (s.getDistance()>winner.getDistance()){
                winner = s;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){

        for (int i=1; i <=100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for(Horse s:horses){
            s.move();
        }
    }

    public void print(){
        for(Horse s:horses){
            s.print();
        }
        for (int i=0; i< 10;i++){
        System.out.println("");}
    }

    public static void main(String[] args) {

        Horse horse = new Horse("Molnia",3,0);
        Horse horse1 = new Horse("Bombina",3,0);
        Horse horse2 = new Horse("Klyacha", 3,0);
        Hippodrome.game = new Hippodrome((Arrays.asList(horse,horse1,horse2)));
        game.run();
        game.printWinner();

    }
}
