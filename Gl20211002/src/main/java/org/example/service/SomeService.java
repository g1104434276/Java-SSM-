package org.example.service;

public interface SomeService {
    void doSome(String name,Integer age);//前置通知
    String doOther(String name , Integer age);//后置通知
    String doFirst(String name );//环绕通知
    void doSecond ();
    void Third ();
}
