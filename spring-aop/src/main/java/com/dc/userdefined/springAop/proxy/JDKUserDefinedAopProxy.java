package com.dc.userdefined.springAop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.aopalliance.intercept.MethodInvocation;

public class JDKUserDefinedAopProxy implements UserDefinedAopProxy,InvocationHandler {

	private UserDefinedProxyFactory config;
	
	public JDKUserDefinedAopProxy(UserDefinedProxyFactory config)  {
		this.config = config;
	}
	
	@Override
	public Object getProxy() {
		return Proxy.newProxyInstance(this.config.getTarget().getClass().getClassLoader(), this.config.getInterfaces(), this);
	}

	@Override
	public Object getProxy(ClassLoader classLoader) {
		return Proxy.newProxyInstance(classLoader, this.config.getInterfaces(), this);
	}

	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		
		// Get the interception chain for this method.
		List<Object> chain = this.config.getInterceptorsAndDynamicInterceptionAdvice(method, this.config.getTarget().getClass());
		
		MethodInvocation invocation = new UserdefinedReflectiveMethodInvocation(proxy, config.getTarget(), method, args, config.getTarget().getClass(), chain);
		// Proceed to the joinpoint through the interceptor chain.
		Object retVal = invocation.proceed();
		
		return retVal;
	}

}
