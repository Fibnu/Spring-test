package com.dc.userdefined.springAop.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;

public class DefaultAdviceChainFactory implements AdviceChainFactory{

	@Override
	public List<Object> getInterceptorsAndDynamicInterceptionAdvice(
			UserDefinedProxyFactory config, Method method,
			Class<?> targetClass) {
		
		List<Object> interceptorList = new ArrayList<Object>(config.getAdvise().length);
		Class<?> actualClass = (targetClass != null ? targetClass : method.getDeclaringClass());
		// 通知注册器，，里面有一些  配适器 
		UserDefinedAdvisorAdapterRegistry registry = GlobalUserDefaultAdvisorAdapterRegistry.getInstance();
		
		for (UserDefinedAdvise advisor : config.getAdvise()) {
			MethodInterceptor[] interceptors = registry.getInterceptors(advisor);
			
			for (MethodInterceptor interceptor : interceptors) {
				interceptorList.add(interceptor);
			}
			
		}
		return interceptorList;
	}

}
