package com.dc.userdefined.springAop.crosscuttingconcern;

public class LogAfterAdvice implements AfterAdvice{

	@Override
	public void after() {
		System.out.println("后增强.....");
	}
	
}
