package com.dc.userdefined.springAop.proxy;

import java.lang.reflect.Method;
import java.util.List;

public interface AdviceChainFactory {

	List<Object> getInterceptorsAndDynamicInterceptionAdvice(
			UserDefinedProxyFactory config,Method method, Class<?> targetClass);
}
