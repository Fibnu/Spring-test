package com.dc.userdefined.springAop.proxy;

import com.dc.userdefined.springAop.crosscuttingconcern.UserDefinedAdvice;

public class UserDefinedAdvise {

	private UserDefinedAdvice userDefinedAdvice;
	public UserDefinedAdvise(UserDefinedAdvice userDefinedAdvice){
		setUserDefinedAdvice(userDefinedAdvice);
	}
	public UserDefinedAdvice getUserDefinedAdvice() {
		return userDefinedAdvice;
	}
	public void setUserDefinedAdvice(UserDefinedAdvice userDefinedAdvice) {
		this.userDefinedAdvice = userDefinedAdvice;
	}
	
	
	
}
