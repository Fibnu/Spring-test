package com.dc.base.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("unchecked")
public class JdkDynamicProxy implements InvocationHandler {
	
	private Object targetObject;
	

	public JdkDynamicProxy(Object targetObject) {
		super();
		this.targetObject = targetObject;
	}

	public  <T> T  getProxy(){
		return  (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObject.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		before();
		Object result = method.invoke(targetObject, args);
		return result;
	}
	
    private void before() {
        System.out.println("Before");
    }

	
	

}
