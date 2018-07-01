package com.dc.tag.bean.attribute.autowire;

public class AutowireHello {
	private AutowireSayHello autowireSayHello;
	
	public void say(){
		this.autowireSayHello.sayHello();
	}

	public AutowireSayHello getAutowireSayHello() {
		return autowireSayHello;
	}

	public void setAutowireSayHello(AutowireSayHello autowireSayHello) {
		this.autowireSayHello = autowireSayHello;
	}

	
	
}
