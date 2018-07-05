package com.ssm.lishaoxiong.aop;

import com.ssm.lishaoxiong.services.AopTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/*
* 测试一下aop功能是否完善
*/
public class TestAop {
    ApplicationContext applicationContext =
            new FileSystemXmlApplicationContext("classpath:aop.xml");

    // 目标对象有实现接口，spring会自动选择“JDK代理”
    @Test
    public void testApp() {
        AopTest userDao = (AopTest) applicationContext.getBean("aopTestImpl");
        System.out.println(userDao.getClass());//class com.sun.proxy.$Proxy4
        userDao.Tetstsave();
    }

    // 目标对象没有实现接口， spring会用“cglib代理”
    @Test
    public void testCglib() {
        AopTest orderDao = (AopTest) applicationContext.getBean("aopTestImpl");
        System.out.println(orderDao.getClass());
        orderDao.Tetstsave();
    }


}
