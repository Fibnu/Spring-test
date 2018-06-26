package com.dc.userdefined.springAop.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class UserDefinedMethodBeforeAdviceInterceptor implements
		MethodInterceptor {

	private UserDefinedMethodBeforeAdvice  userDefinedMethodBeforeAdvice;
	public UserDefinedMethodBeforeAdviceInterceptor(UserDefinedMethodBeforeAdvice  userDefinedMethodBeforeAdvice){
		this.userDefinedMethodBeforeAdvice = userDefinedMethodBeforeAdvice;
	}
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		return null;
	}

}
