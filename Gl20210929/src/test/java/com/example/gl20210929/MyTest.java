package com.example.gl20210929;

import com.example.gl20210929.proxy.ServiceProxy;
import com.example.gl20210929.service.SomeService;
import com.example.gl20210929.service.impl.SomeServiceImpl;
import org.junit.Test;

public class MyTest {
    @Test
    public void test01(){
        SomeService service = new SomeServiceImpl();

        service.doSome();

        service.doOther();

    }

    @Test
    public void test02(){
        SomeService service = new ServiceProxy();

        service.doSome();

        service.doOther();

    }
}
