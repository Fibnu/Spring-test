package com.dc.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class CustomTagNamespaceHandlerSupport  extends NamespaceHandlerSupport {

	@Override
	public void init() {
		 //注册用于解析<custom:customtag>的解析器
        registerBeanDefinitionParser("customtag", new BusinessCustomTagDefinitionParser());
		
	}

}
