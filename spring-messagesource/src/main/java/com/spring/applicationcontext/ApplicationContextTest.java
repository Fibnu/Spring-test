package com.spring.applicationcontext;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 容器级的国际化信息资源
*
* @ClassName: ApplicationContextTest 
* @author Liqn
* @date 2018年7月17日 下午11:02:16 
* @Description: TODO 
*		ApplicationContext实现了MessageSource的接口.
*	国际化信息一般在系统输出信息时使用，如Spring MVC的页面标签，控制器Controller等，
*不同的模块都可能通过这些组件访问国际化信息，因此Spring就将国际化消息作为容器的公共基础设施对所有组件开放。
*
*④处的initMessageSource()方法所执行的工作就是初始化容器中的国际化信息资源：它根据反射机制从BeanDefinitionRegistry中找出名称为“messageSource”且类型为org.springframework.context.MessageSource的Bean，将这个Bean定义的信息资源加载为容器级的国际化信息资源。
 */
public class ApplicationContextTest {
	public static void main(String[] args) {

		String[] configsString = new String[]{"com/spring/applicationcontext/applicationContext.xml"};
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(configsString);
		
		MessageSource messageSource = (MessageSource) appContext.getBean("messageSource");
		
		Object[] params = {"john",new GregorianCalendar().getTime()};
		
		String str1 = messageSource.getMessage("greeting.common",params,Locale.US);        
		System.out.println(str1);    
		
	}
}
