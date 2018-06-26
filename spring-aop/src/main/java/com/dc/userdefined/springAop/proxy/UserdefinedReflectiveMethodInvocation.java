package com.dc.userdefined.springAop.proxy;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;

public class UserdefinedReflectiveMethodInvocation implements MethodInvocation{

	protected final Object proxy;

	protected final Object target;

	protected final Method method;

	protected Object[] arguments;

	private final Class<?> targetClass;

	protected final List<?> interceptorsAndDynamicMethodMatchers; 
	
	protected UserdefinedReflectiveMethodInvocation(
			Object proxy, Object target, Method method, Object[] arguments,
			Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {

		this.proxy = proxy;
		this.target = target;
		this.targetClass = targetClass;
		this.method = method;
		this.arguments = arguments;
		this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
	}
	
	
	private int currentInterceptorIndex = -1;
	@Override
	public Object proceed() throws Throwable {
		if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
			return invokeJoinpoint();
		}
		
		Object interceptorOrInterceptionAdvice =
				this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
		MethodInterceptor dm = (MethodInterceptor)interceptorOrInterceptionAdvice;
		return dm.invoke(this);
		
	}
	private Object invokeJoinpoint() throws Throwable {
		// TODO Auto-generated method stub
		return AopUtils.invokeJoinpointUsingReflection(this.target, this.method, this.arguments);
	}
	@Override
	public Object[] getArguments() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getThis() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AccessibleObject getStaticPart() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Method getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
