package com.itheima.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
    @Pointcut("execution(* com.itheima.service.*Service.*(..))")
    public void pt(){}

    @Around("pt()")
    public Object speedTest(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            Object res = pjp.proceed();
        }
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        long end = System.currentTimeMillis();
        System.out.println("time: " + className + "." + methodName + (end - start) + "ms");
        return null;
    }
}
