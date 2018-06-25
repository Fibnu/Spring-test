package com.dc.springaop.nopointcut.declarative;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dc.Apology;
import com.dc.Greeting;

/**
 * spring aop  编程式，
*
* @ClassName: TestMain 
* @author Liqn
* @date 2018年6月25日 下午3:32:16 
* @Description: TODO 
*	配置 spring的xml文件，即使用springIoc 来管理bean
 */
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("nopointcut/applicationContext.xml"); // 获取 Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greeting.sayHello();  
        
        Apology apology = (Apology) greeting; // 将目标类强制向上转型为 Apology 接口（这是引入增强给我们带来的特性，也就是“接口动态实现”功能）
        apology.saySorry("Jack");
        
	}
}
