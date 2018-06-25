package com.dc.base.cglib.example;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class TestClassProxy2 implements MethodInterceptor{

	@Override
	public Object intercept(Object targetObject, Method method, Object[] args,MethodProxy methodProxy) throws Throwable {
		System.out.println("invoke intercept.......2");
		return methodProxy.invokeSuper(targetObject, args);
	}


	
}
