package com.dc.userdefined.springAop.isProxy;

import com.dc.userdefined.springAop.isProxyInterface.ReportCreate;

/**
 * 
* @ClassName: LocalReportCreate 
* @author Liqn
* @date 2018年6月26日 下午9:15:17 
* @Description: TODO 
*	目标类
 */
public class LocalReportCreate implements ReportCreate{

	@Override
	public void getHTMLReport() {
		System.out.println(LocalReportCreate.class.getName()+"����HTML����");
	}

	@Override
	public void getPDFReport() {
		System.out.println(LocalReportCreate.class.getName()+"����PDF����");
	}

}
