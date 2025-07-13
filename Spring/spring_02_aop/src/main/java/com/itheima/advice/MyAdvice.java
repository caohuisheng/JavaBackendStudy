package com.itheima.advice;

/**
 * 增强类
 */
public class MyAdvice {
    public void beforeAdvice(){
        System.out.println("beforeAdvice...");
    }

    public void afterAdvice(){
        System.out.println("afterAdvice...");
    }
}
