package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private  List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double grade) {
        Student student = students.get(0);
        for(Student a: students){
            if(a.getAverageGrade()==grade) student =a;
         }
         return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student maxGrade = students.get(0);
        for(int i=0; i<students.size();i++){
            if(students.get(i).getAverageGrade()>maxGrade.getAverageGrade()) maxGrade = students.get(i);
        }
        return maxGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student minGrade = students.get(0);
        for(int i=0; i<students.size();i++){
            if(students.get(i).getAverageGrade()<minGrade.getAverageGrade()) minGrade = students.get(i);
        }
        return minGrade;//TODO:
    }

    public void expel(Student student){
        students.remove(student);

    }
}