package com.dc.base.cglib;

import com.dc.Greeting;
import com.dc.GreetingImpl;

public class CglibDynamicProxyMain {

	public static void main(String[] args) {
		Greeting greeting = CglibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello();
	}
}
