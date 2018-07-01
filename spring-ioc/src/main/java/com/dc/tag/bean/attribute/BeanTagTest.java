package com.dc.tag.bean.attribute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dc.tag.bean.attribute.abstractparent.Child;
import com.dc.tag.bean.attribute.autowire.AutowireHello;
import com.dc.tag.bean.attribute.dependon.DependOnHello2;

/**
 * 
*
* @ClassName: BeanTagTest 
* @author Liqn
* @date 2018年7月1日 下午3:57:04 
* @Description: TODO 
*	测试spring自带标签 bean的属性等功能的测试
 */
public class BeanTagTest {
	public static void main(String[] args) {
		//  attribute 测试
		System.out.println("===============attribute属性=================");
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:tag/applicationContext.xml");
		Child child = (Child)context.getBean("attributeBean");
		System.out.println(child.getSex());
//		System.out.println("Parent Object: "+context.getBean("attributeparentBean"));
		
		System.out.println("===============autowire属性=================");
		// 自动依赖注入，一个接口只能有一个实现类
		//如果一个接口有多个实现类，可以采用设置autowire-candidate属来解决，表示该类不参与自动注入
		AutowireHello autowireHello = (AutowireHello)context.getBean("autowireHello");
		autowireHello.say();
		System.out.println("===============depend-on属性=================");
		//A实例化需要先实例化B且不需要B实例，这时只能通过depend-on依赖，如果需要B实例，则使用A的构造方法依赖注入
		DependOnHello2 hello2 = (DependOnHello2)context.getBean("dependOnHello2");
		hello2.say();
//		((FileSystemXmlApplicationContext)context).registerShutdownHook();// 调用销毁的方法
		
		
		
		
	}
}
