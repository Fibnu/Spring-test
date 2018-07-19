package com.spring;

import org.springframework.context.ApplicationEvent;

public class UserRigest extends ApplicationEvent{

	public UserRigest(String name) {
		super(name);
	}
	


}
