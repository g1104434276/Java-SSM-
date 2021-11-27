package com.example.gl20210926.ba03;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student() {

    }

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
        System.out.println("Spring的有参构造方法!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
