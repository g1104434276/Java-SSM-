package com.example.gl20210926test;

import com.example.gl20210926test.domain.SysUser;
import com.example.gl20210926test.service.UserService;
import com.example.gl20210926test.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserService service = (UserServiceImpl) ctx.getBean("service");
        SysUser sysuser = (SysUser) ctx.getBean("sysuser");

        service.addUser(sysuser);
    }
}
