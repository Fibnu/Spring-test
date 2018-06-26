package com.dc.userdefined.springAop.proxy;

public class DafaultUserDefinedAopProxyFactory implements UserDefinedAopProxyFactory {

	@Override
	public UserDefinedAopProxy createAopProxy(UserDefinedProxyFactory config) {
		return new JDKUserDefinedAopProxy(config);
	}

}
