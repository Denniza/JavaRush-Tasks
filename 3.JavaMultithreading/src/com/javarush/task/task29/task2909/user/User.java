package com.javarush.task.task29.task2909.user;

public class User {
    private String name;
    private String surname;
    private int age;
    private boolean man;
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    private Work work;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public void printInfo(){
        System.out.println(String.format("Имя: %s \nФамилия: %s", name,surname));
    }
    public void printAdditionalInfo() {
        if (age<16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBoss(){
        return work.getBoss();
    }

    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        this.address.setCountry(country);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }
    public String getHouse() {
        return address.getHouse();
    }

    public void setHouse(String house) {
        address.setHouse(house);
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}