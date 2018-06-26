package com.dc.userdefined.springAop.proxy;

import org.aopalliance.intercept.MethodInterceptor;


public class UserDefinedMethodBeforeAdviceAdapter implements UserDefinedAdvisorAdapter{


	public MethodInterceptor getInterceptor(UserDefinedAdvise advise) {
		UserDefinedMethodBeforeAdvice advice = (UserDefinedMethodBeforeAdvice) advise.getUserDefinedAdvice();
		return new UserDefinedMethodBeforeAdviceInterceptor(advice);
	}
	
}
