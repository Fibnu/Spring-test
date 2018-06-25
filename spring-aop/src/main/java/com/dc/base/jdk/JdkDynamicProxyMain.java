package com.dc.base.jdk;

import com.dc.Greeting;
import com.dc.GreetingImpl;


public class JdkDynamicProxyMain {

	public static void main(String[] args) {
		JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(new GreetingImpl());
		Greeting greeting = (Greeting)jdkDynamicProxy.getProxy();
		greeting.sayHello();
	}
}
