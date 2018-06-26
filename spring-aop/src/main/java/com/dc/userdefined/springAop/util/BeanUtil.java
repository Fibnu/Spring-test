package com.dc.userdefined.springAop.util;

import java.lang.reflect.Method;

public class BeanUtil {

    public static void setProperty(Object bean, String fieldName,Object fieldRef) throws Exception { 
        String className = getClassName(bean); 
        Class beanClass = Class.forName(className); 
        Method[] methods = beanClass.getMethods(); 
 
        String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()); 
        for (Method m : methods) { 
            if (m.getName().equals(setterName)) { 
                m.invoke(bean, fieldRef); 
                System.out.println("�ѵ��� " + m.getName() + "() �� " + className + " ע�� " + getClassName(fieldRef)); 
                return; 
            } 
        } 
        System.out.println(">>类名称: " + className + " 方法名称 ：" + fieldName 
                + " ..."); 
        
    }

	private static String getClassName(Object o) {
		if (o == null) { 
            System.out.println("对象为 null ..."); 
            return null; 
        } 
        String fullName = o.toString(); 
        String className = fullName.substring(0, fullName.indexOf("@")); 
        return className; 
	}
}
