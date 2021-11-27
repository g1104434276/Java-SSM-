package com.example.gl20210929.service.impl;

import com.example.gl20210929.service.SomeService;

import java.util.Date;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("业务方法doSome,计算商品金额.");
    }

    @Override
    public void doOther() {
        System.out.println("业务方法doOther,消减库存");
    }
}
