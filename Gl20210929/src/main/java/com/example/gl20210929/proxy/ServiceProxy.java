package com.example.gl20210929.proxy;

import com.example.gl20210929.service.SomeService;
import com.example.gl20210929.service.impl.SomeServiceImpl;

import java.util.Date;

public class ServiceProxy implements SomeService {
    @Override
    public void doSome() {
        SomeService sc = new SomeServiceImpl();
        System.out.println("执行日志方法");
        System.out.println("日志功能:方法的执行时间" + new Date());
        sc.doSome();
        System.out.println("事务功能,提交事务");
    }

    @Override
    public void doOther() {
        SomeService sc = new SomeServiceImpl();
        System.out.println("执行日志方法");
        System.out.println("日志功能:方法的执行时间" + new Date());
        sc.doOther();
        System.out.println("事务功能,提交事务");
    }
}
