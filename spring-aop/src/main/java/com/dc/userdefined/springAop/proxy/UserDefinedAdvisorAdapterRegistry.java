package com.dc.userdefined.springAop.proxy;

import org.aopalliance.intercept.MethodInterceptor;

public interface UserDefinedAdvisorAdapterRegistry {
	MethodInterceptor[] getInterceptors(UserDefinedAdvise advisor);
}
