package com.example.gl20210926;

import com.example.gl20210926.ba01.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student01");
        System.out.println("Student = "+student);

        Date date = (Date) ctx.getBean("mydate");
        System.out.println("date==" + date);
    }

    @Test
    public void test02(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        com.example.gl20210926.ba02.Student student02 = (com.example.gl20210926.ba02.Student) ctx.getBean("student02");
        student02.toString();
    }
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        com.example.gl20210926.ba03.Student student03 = (com.example.gl20210926.ba03.Student) ctx.getBean("student03");
        System.out.println(student03.toString());
        com.example.gl20210926.ba03.Student student031 = (com.example.gl20210926.ba03.Student) ctx.getBean("student03.1");
        System.out.println(student031.toString());
        com.example.gl20210926.ba03.Student student032 = (com.example.gl20210926.ba03.Student) ctx.getBean("student03.2");
        System.out.println(student032.toString());
    }
}
