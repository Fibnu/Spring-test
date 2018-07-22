package com.spring.propertyedit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
*
* @ClassName: PrepareBeanFactoryTest 
* @author Liqn
* @date 2018年7月22日 下午5:07:46 
* @Description: TODO 
*	ApplicationContext 功能扩展——>属性编辑
 */
public class PrepareBeanFactoryTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/spring/applicationContext.xml");
		System.out.println(context.getBean("userManager"));
	}
}
