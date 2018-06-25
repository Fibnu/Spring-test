package com.dc.springaop.nopointcut.programmatic;

import org.springframework.aop.framework.ProxyFactory;

import com.dc.Apology;
import com.dc.Greeting;
import com.dc.GreetingImpl;
import com.dc.springaop.GreetingAroundAdvice;
import com.dc.springaop.GreetingBeforeAdvice;
import com.dc.springaop.GreetingBeforeAdvice2;
import com.dc.springaop.GreetingIntroAdvice;
import com.dc.springaop.GreetingafterAdvice;

/**
 * 
*
* @ClassName: TestMain 
* @author Liqn
* @date 2018年6月25日 下午3:11:15 
* @Description: TODO 
*    首先测试的是springaop 编程式 ： 在不引入切点的情况下
 */
public class TestMain {

	public static void main(String[] args) {
		// 创建spring代理工厂 ,与ProxyFactoryBean区分，ProxyFactoryBean是配置式用的
		ProxyFactory proxyFactory = new ProxyFactory();
		// 设置目标类
		proxyFactory.setTarget(new GreetingImpl());
		// 设置增强类，可以同时实现前置和后置增强，这样就可以少写一行代码了
		proxyFactory.addAdvice(new GreetingBeforeAdvice());
		proxyFactory.addAdvice(new GreetingBeforeAdvice2());
		proxyFactory.addAdvice(new GreetingafterAdvice());
		proxyFactory.addAdvice(new GreetingAroundAdvice());
		proxyFactory.addAdvice(new GreetingIntroAdvice());
		proxyFactory.setInterfaces(Apology.class);
		proxyFactory.setProxyTargetClass(true);
		// 创建代理类
		Greeting greeting= (Greeting)proxyFactory.getProxy();
		// 执行方法
		greeting.sayHello();
		// 创建代理类
		Apology apology= (Apology)proxyFactory.getProxy();
		// 执行方法
		apology.saySorry("jack ");
	}
	
}
