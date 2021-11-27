package org.example.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAspect {
    //前置通知
    @Before(value = "execution(public void org.example.service.impl.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(){
        System.out.println("前置通知,切面的功能在目标方法之前先执行" + new Date());

    }
    //后置通知
    @AfterReturning(value = "execution(public String org.example.service.impl.SomeServiceImpl.doOther(String,Integer))",returning = "res")
    public void myAfterReturning(Object res){
        if (res != null){
            System.out.println("Hello AfterReturning");
        }
        System.out.println("执行后置通知,在目标方法执行后,执行的,拿到的结果 res 为" + res);

        if("delete".equals(res)){
            System.out.println("根据返回值的不同做删除功能");
        }else if("add".equals(res)){
            System.out.println("根据返回值的不同做增加功能");
        }
        System.out.println("后置通知成功执行");
    }

    //环绕通知
    @Around(value = "execution(public String org.example.service.impl.SomeServiceImpl.doFirst(String))")
    public Object myAround(ProceedingJoinPoint pjp )throws Throwable {

        Object methodReturn = null;

        System.out.println("执行了环绕通知在目标方法之前,输出日志时间:" + new Date());
        methodReturn = pjp.proceed();

        return "helloAround , 不是目标方法执行的结果";
    }

    //异常通知
    @AfterThrowing(value = "execution(public void org.example.service.impl.SomeServiceImpl.doSecond())",throwing = "ex")
    public void myAfterThrowing (Exception ex){
        System.out.println("异常通知" + ex.getMessage());
    }

    //最终通知
    @After(value = "execution(public void org.example.service.impl.SomeServiceImpl.Third())")
    public void maAfter(){
        System.out.println("最终通知,总是会被执行的");
    }


}
