package com.dc.base.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor{

    private static CglibDynamicProxy instance = new CglibDynamicProxy();

    private CglibDynamicProxy() {
    }

    public static CglibDynamicProxy getInstance() {
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T)Enhancer.create(cls, this);
	}


	/**
	 * 
	 * intercept方式的4个参数分别对应
	 * 增强对象、调用方法、方法参数以及调用父类方法的代理。
	 * 使用MethodProxy速度会更快，所以后面将用.
	 * 
	 */
	@Override
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		before();
		return methodProxy.invokeSuper(target, args);
	}
	 
	private void before() {
	        System.out.println("Before");
	}
	
	
}
