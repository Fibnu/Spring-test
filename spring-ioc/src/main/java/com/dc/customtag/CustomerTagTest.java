package com.dc.customtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerTagTest {
    public static void main(String[] args) {    
        ApplicationContext beans=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");    
        CustomTagBean customTagBean=(CustomTagBean)beans.getBean("testBean");    
        System.out.println("code:"+customTagBean.getCode());    
    }    
}
