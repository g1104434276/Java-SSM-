package org.example;

import org.example.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String config = "application.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        System.out.println("service==" + service.getClass().getName());

        service.doSome("GaoLi",20);

        String ret = service.doOther("Gaoli",20);
        System.out.println("out的值为: " + ret);

        String res = service.doFirst("Gaoli");
        System.out.println(res);

        service.doSecond();

        service.Third();

    }

}
