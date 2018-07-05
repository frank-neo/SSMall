package com.ssm.lishaoxiong.aop;

import org.aspectj.lang.ProceedingJoinPoint;
/*
*定义的aop的切面类
*定义各种通知方法
*/
public class AspectDemo {
    public AspectDemo() {
    }

    public void begin(){
        System.out.println("开始事务/异常");
    }

    public void after(){
        System.out.println("提交事务/关闭");
    }

    public void afterReturning() {
        System.out.println("afterReturning()");
    }

    public void afterThrowing(){
        System.out.println("afterThrowing()");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前....");
        pjp.proceed();  // 执行目标方法
        System.out.println("环绕后....");
    }

}
