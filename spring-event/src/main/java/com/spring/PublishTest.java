package com.spring;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class PublishTest implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher applicationEventPublisher;

	public void publish(){
		applicationEventPublisher.publishEvent(new UserRigest("tomcat"));
	}
	
	public ApplicationEventPublisher getApplicationEventPublisher() {
		return applicationEventPublisher;
	}

	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	


}
