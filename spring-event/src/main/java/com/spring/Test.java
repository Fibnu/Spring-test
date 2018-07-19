package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1、解耦
*  2、对同一种事件有多种处理方式
*  3、不干扰主线(main line)
*
* @ClassName: Test 
* @author Liqn
* @date 2018年7月19日 下午11:01:30 
* @Description: TODO 
*
 */
public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserRigest userRigest = new UserRigest("name");
		context.publishEvent(userRigest);
		
		PublishTest publishTest = (PublishTest) context.getBean("publishTest");
		publishTest.publish();
		
		
	}

}
