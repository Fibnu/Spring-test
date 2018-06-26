package com.dc.userdefined.springAop.proxy;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;

import com.dc.userdefined.springAop.crosscuttingconcern.UserDefinedAdvice;

public class DefaultUserDefinedAdvisorAdapterRegistry implements UserDefinedAdvisorAdapterRegistry{

	private final List<UserDefinedAdvisorAdapter> adapters = new ArrayList<UserDefinedAdvisorAdapter>(3);


	/**
	 * Create a new DefaultAdvisorAdapterRegistry, registering well-known adapters.
	 */
	public DefaultUserDefinedAdvisorAdapterRegistry() {
		registerAdvisorAdapter(new UserDefinedMethodBeforeAdviceAdapter());
//		registerAdvisorAdapter(new AfterReturningAdviceAdapter());
//		registerAdvisorAdapter(new ThrowsAdviceAdapter());
	}
	
	public void registerAdvisorAdapter(UserDefinedAdvisorAdapter adapter) {
		this.adapters.add(adapter);
	}
	
	public MethodInterceptor[] getInterceptors(UserDefinedAdvise advisor)  {
		List<MethodInterceptor> interceptors = new ArrayList<MethodInterceptor>(3);
		UserDefinedAdvice advice = advisor.getUserDefinedAdvice();
		if (advice instanceof MethodInterceptor) {
			interceptors.add((MethodInterceptor) advice);
		}
		return interceptors.toArray(new MethodInterceptor[interceptors.size()]);
	}
	
}
