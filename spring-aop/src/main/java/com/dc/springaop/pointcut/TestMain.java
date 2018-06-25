package com.dc.springaop.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dc.Greeting;
import com.dc.GreetingImpl;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("pointcut/applicationContext.xml"); // 获取 Spring Context
        Greeting greeting = (Greeting) context.getBean(GreetingImpl.class);  // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greeting.goodMorning("jack"); 
//        Apology apology = (Apology) greeting; // 强制转型为 Apology 接口
//        apology.saySorry("Jack");
	}
}
