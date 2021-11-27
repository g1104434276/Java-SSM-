package com.example;

import com.example.gl20210925.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        //1.指定spring的配置文件:从类路径(classpath) 之下开始的路径
        String config = "beans.xml";
        //2.创建容器对象    ApplicationContext 表示spring容器对象,通过ctx来获取某个java对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //3.从容器中获取指定名称的对象,使用getBean("id")方法
        SomeService service = (SomeService)ctx.getBean("service");
        //4.调用对象的方法,接口中的方法
        service.doSome();
        System.out.println(service.toString());

    }
}
