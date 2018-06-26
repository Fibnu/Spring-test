package com.dc.userdefined.springAop.proxy;

public interface UserDefinedAopProxy {
	
	Object getProxy();

	Object getProxy(ClassLoader classLoader);
}
