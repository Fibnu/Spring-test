package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
*
* @ClassName: Test 
* @author Liqn
* @date 2018年7月22日 下午3:22:50 
* @Description: TODO 
*
*	BeanFactoryPostProcessor，可以对Bean的定义进行处理，可以修改Bean的数据，但如果要改变Bean的实例，最好使用BeanPostProccessor(如代理)
*			可以实现Ordered接口，顺序执行。
*	在spring载入所有Bean的配置后执行.
*
*	以下例子是过滤值：将不好的次过滤掉
*
*	
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/spring/applicationContext.xml");
		System.out.println(context.getBean("simpleTest1"));
	
	}

}
