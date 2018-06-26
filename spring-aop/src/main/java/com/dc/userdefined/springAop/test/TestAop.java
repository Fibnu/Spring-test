package com.dc.userdefined.springAop.test;

import com.dc.userdefined.springAop.isProxyInterface.ReportCreate;
import com.dc.userdefined.springAop.proxy.UserDefinedProxyFactory;


public class TestAop {
	 public static void main(String[] args) { 
		 
		   
		 
		    UserDefinedProxyFactory proxyFactory = new UserDefinedProxyFactory(); 
	        ReportCreate reportCreator = (ReportCreate) proxyFactory.getProxy(); 
	        reportCreator.getHTMLReport(); 
	    } 
}
