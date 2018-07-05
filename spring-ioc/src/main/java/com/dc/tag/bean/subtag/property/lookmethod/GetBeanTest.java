package com.dc.tag.bean.subtag.property.lookmethod;

public abstract class GetBeanTest {
	public  void sayHello() {
		this.getBean().sayHello();
	}
	public abstract Car getBean();
}
