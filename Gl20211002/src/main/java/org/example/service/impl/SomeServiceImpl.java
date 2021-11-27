package org.example.service.impl;

import org.example.service.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("业务方法doSome(),创建商品订单");
        //return "add" ;
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("业务方法doOther(),创建商品订单");
        return "add";
    }

    @Override
    public String doFirst(String name) {
        System.out.println("执行了业务方法doFirst(),创建商品订单");
        
        return null;
    }

    @Override
    public void doSecond() {
        System.out.println(10/0);
    }

    @Override
    public void Third() {
        System.out.println("执行了业务方法Third()");
    }

}
