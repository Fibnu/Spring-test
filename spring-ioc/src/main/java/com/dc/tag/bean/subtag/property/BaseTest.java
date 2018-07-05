package com.dc.tag.bean.subtag.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dc.tag.bean.subtag.property.base.ModleA;
import com.dc.tag.bean.subtag.property.lookmethod.GetBeanTest;
import com.dc.tag.bean.subtag.property.replaycemethod.Who;

public class BaseTest {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:tag/subtag/applicationContext.xml");
		ModleA modleA = (ModleA)context.getBean("modleA");
		modleA.sayHello();
		System.out.println("=============lookmethod=======================");
		GetBeanTest getBeanTest = (GetBeanTest)context.getBean("getBeanTest");
		getBeanTest.sayHello();
		System.out.println("=============replacemethod=======================");
		Who who = (Who)context.getBean("who");
		who.sayHello();
	}
}
