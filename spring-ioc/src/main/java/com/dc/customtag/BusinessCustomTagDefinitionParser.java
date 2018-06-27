package com.dc.customtag;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class BusinessCustomTagDefinitionParser  extends AbstractSingleBeanDefinitionParser  {

    @Override    
    protected Class<?> getBeanClass(Element element) {    
        return CustomTagBean.class;    
    }    
    @Override    
    protected void doParse(Element element, BeanDefinitionBuilder builder) {    
        String code=element.getAttribute("code");    
        if(StringUtils.hasText(code)){    
            builder.addPropertyValue("code", code);    
        }    
    }    

}
