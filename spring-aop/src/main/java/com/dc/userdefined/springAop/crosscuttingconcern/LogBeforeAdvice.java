package com.dc.userdefined.springAop.crosscuttingconcern;

public class LogBeforeAdvice implements BeforeAdvice{

	@Override
	public void before() {
		// TODO Auto-generated method stub
		System.out.println("前置增强.....");
	}

}
