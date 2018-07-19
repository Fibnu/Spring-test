package com.spring;

import org.springframework.context.ApplicationListener;

public class UserRigestListener implements ApplicationListener<UserRigest>{

	@Override
	public void onApplicationEvent(UserRigest event) {
		System.out.println("邮件服务接到通知，给 " + event.getSource() + " 发送邮件...");
	}

}
