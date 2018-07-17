package com.spring.hierarchicalmessageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
*
* @ClassName: ResourceBundleMessageSourceTest 
* @author Liqn
* @date 2018年7月17日 下午10:39:53 
* @Description: TODO 
*
*	该实现类允许用户通过beanName指定一个资源名（包括类路径的全限定资源名），或通过beanNames指定一组资源名.
*
*	最主要的区别在于我们无须再分别加载不同语言、不同国家/地区的本地化资源文件，
*仅仅通过资源名就可以加载整套的国际化资源文件。此外，我们无须显式使用MessageFormat操作国际化信息，
*仅通过MessageSource# getMessage()方法就可以完成操作了
*
 */
public class ResourceBundleMessageSourceTest {
	public static void main(String[] args) {
		String[] configsString = new String[]{"com/spring/hierarchicalmessageSource/ResourceBundleMessageSource.xml"};
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(configsString);
		
		MessageSource messageSource = (MessageSource) appContext.getBean("myResource");
		
		Object[] params = {"john",new GregorianCalendar().getTime()};
		
		String str1 = messageSource.getMessage("greeting.common", params, Locale.US);
		String str2 = messageSource.getMessage("greeting.common", params, Locale.CHINA);
		String str3 = messageSource.getMessage("greeting.common", params, Locale.CANADA);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		
	}
}
