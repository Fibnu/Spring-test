package com.spring.hierarchicalmessageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReloadableResourceBundleMessageSourceTest {
	
	public static void main(String[] args) throws InterruptedException {
		String[] configsString = new String[]{"com/spring/hierarchicalmessageSource/ResourceBundleMessageSource.xml"};
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(configsString);
		
		MessageSource messageSource = (MessageSource) appContext.getBean("myRelaodResource");
		
		Object[] params = {"john",new GregorianCalendar().getTime()};
		
		for (int i = 0; i < 2; i++) {    
		    String str1 = messageSource.getMessage("greeting.common",params,Locale.US);        
		    System.out.println(str1);    
		    Thread.currentThread().sleep(30000); //①模拟程序应用，在此期间，我们更改资源文件     
		}   
		
	}
}
