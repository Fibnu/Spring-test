package com.dc.userdefined.springAop.proxy;

public class GlobalUserDefaultAdvisorAdapterRegistry {

	private static UserDefinedAdvisorAdapterRegistry instance = new DefaultUserDefinedAdvisorAdapterRegistry();

	public static UserDefinedAdvisorAdapterRegistry getInstance() {
		return instance;
	}
}
