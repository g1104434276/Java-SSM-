package com.example.gl20210925;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Iterator;

public class MyTest {

    @Test
    public void test01 () {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService)ctx.getBean("someService");
        service.doSome();
    }
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //获取容器中定义对象中的数量
        int nums = ctx.getBeanDefinitionCount();
        System.out.println("容器中定义对象中的数量==" + nums);
        //获取容器中定义对象中的名称
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中定义对象的名称==" + name);
        }
    }
//    让spring创建一个非自定义类的对象
//    有class就能让spring创建对象
    @Test
    public void test05(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Date date =(Date) ctx.getBean("mydate");
        System.out.println("Date为" + date);

        OtherService service = (OtherService) ctx.getBean("otherService");
        service.doOther();
    }

}
