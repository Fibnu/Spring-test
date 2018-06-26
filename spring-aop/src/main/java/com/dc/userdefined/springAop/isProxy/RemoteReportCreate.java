package com.dc.userdefined.springAop.isProxy;

import com.dc.userdefined.springAop.isProxyInterface.ReportCreate;

/**
 * 目标类
 */
public class RemoteReportCreate implements ReportCreate{

	@Override
	public void getHTMLReport() {
		// TODO Auto-generated method stub
		System.out.println(RemoteReportCreate.class.getName()+"����HTML����");
		
	}

	@Override
	public void getPDFReport() {
		// TODO Auto-generated method stub
		System.out.println(RemoteReportCreate.class.getName()+"����PDF����");
		
	}

}
