package com.spring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	private Set<String> obscenitySet;
	
	public ObscenityRemovingBeanFactoryPostProcessor(){
		this.obscenitySet = new HashSet<String>();
	}
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
	
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		
		for(String beanName:beanDefinitionNames){
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
			StringValueResolver valueResolver = new StringValueResolver() {
				@Override
				public String resolveStringValue(String strVal) {
					if(isObscenity(strVal)){
						return "*********";
					}
					return strVal;
				}
				
			};
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(beanDefinition);
		}
		
		
	}
	
	
	public boolean isObscenity(Object value) {
		String potentialObscenity = value.toString().toUpperCase();
		return this.obscenitySet.contains(potentialObscenity);
	}
	

	public Set<String> getObscenitySet() {
		return obscenitySet;
	}

	public void setObscenitySet(Set<String> obscenitySet) {
		this.obscenitySet.clear();
		for(String obscenity:obscenitySet){
			this.obscenitySet.add(obscenity.toUpperCase());
		}
	}
	
}
