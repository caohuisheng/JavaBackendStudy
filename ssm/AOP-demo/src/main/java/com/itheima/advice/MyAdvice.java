package com.itheima.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //定义切入点
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    public void pt1(){}
    @Pointcut("execution(* com.itheima.dao.BookDao.select())")
    public void pt2(){}
    @Pointcut("execution(String com.itheima.dao.BookDao.findName(int))")
    public void pt3(){}

//    @Before("pt1()")
    public void notification(){
        System.out.println(System.currentTimeMillis());
    }

//    @Around("pt2()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before...");
        Object res = pjp.proceed();
        System.out.println("around after...");
        return res;
    }

    @AfterReturning(value = "pt2()",returning = "ret")
    public void afterReturn(JoinPoint jp,Object ret){
        System.out.println("afterReturn...");
    }


    @Before("pt3()")
    public void before(){
        System.out.println("before...");
    }

    @After("pt3()")
    public void after(){
        System.out.println("after...");
    }

    @AfterReturning(value="pt3()",returning = "ret")
    public Object afterReturning(Object ret){
        System.out.println("afterReturning...");
        return ret;
    }

    @Around("pt3()")
    public Object around1(ProceedingJoinPoint pjp){
        System.out.println("around before...");
        Object ret = null;
        try {
            ret = pjp.proceed();
        } catch (Throwable e) {
            //e.printStackTrace();
        }
        System.out.println("around after...");
        return ret;
    }

    @AfterThrowing(value = "pt3()",throwing = "t")
    public void afterThrowing(Throwable t){
        System.out.println("afterThrowing,msg:"+t.getMessage());
    }

}
