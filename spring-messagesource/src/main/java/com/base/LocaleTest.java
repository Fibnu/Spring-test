package com.base;

import java.util.Locale;

/**
 * 
*
* @ClassName: LocaleTest 
* @author Liqn
* @date 2018年7月17日 下午9:39:03 
* @Description: TODO 
*
*确定一个特定类型的本地化信息，它们分别是“语言类型”和“国家/地区的类型”
*	JDK的java.util包中提供了几个支持本地化的格式化操作工具类：NumberFormat、DateFormat、MessageFormat
*
 */
public class LocaleTest {
	public static void main(String[] args) {
		//①带有语言和国家/地区信息的本地化对象    
		Locale locale1 = new Locale("zh","CN");     
		    
		//②只有语言信息的本地化对象    
		Locale locale2 = new Locale("zh");     
		    
		//③等同于Locale("zh","CN")    
		Locale locale3 = Locale.CHINA;     
		    
		//④等同于Locale("zh")    
		Locale locale4 = Locale.CHINESE;     
		    
		//⑤获取本地系统默认的本地化对象    
		Locale locale5= Locale.getDefault();  
	}
}
