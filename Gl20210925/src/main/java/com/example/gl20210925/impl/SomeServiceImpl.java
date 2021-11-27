package com.example.gl20210925.impl;

import com.example.gl20210925.SomeService;

public class SomeServiceImpl implements SomeService {
    private String name;
    private int age;

    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl的无参数构造方法");
    }

    public SomeServiceImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SomeServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void doSome() {
        System.out.println("执行了业务方法doSome()");
    }
}
