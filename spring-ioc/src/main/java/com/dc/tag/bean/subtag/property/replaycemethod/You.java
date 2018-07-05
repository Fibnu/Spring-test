package com.dc.tag.bean.subtag.property.replaycemethod;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class You implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println("objname: "+obj.getClass().getSimpleName());
		return null;
	}

}
