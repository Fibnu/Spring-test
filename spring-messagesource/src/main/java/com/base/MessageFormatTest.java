package com.base;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
/**
 * 
*
* @ClassName: MessageFormatTest 
* @author Liqn
* @date 2018年7月17日 下午9:49:00 
* @Description: TODO 
*		pattern1是简单形式的格式化信息串，通过{n}占位符指定动态参数的替换位置索引，{0}表示第一个参数，{1}表示第二个参数.
*		pattern2格式化信息串比较复杂一些，除参数位置索引外，还指定了参数的类型和样式。
*				从pattern2中可以看出格式化信息串的语法是很灵活的，一个参数甚至可以出现在两个地方：
*							如 {1,time,short}表示从第二个入参中获取时间部分的值，显示为短样式时间；
*                           而{1,date,long}表示从第二个入参中获取日期部分的值，显示为长样式时间。
*                           关于MessageFormat更详细的使用方法，请参见JDK的Javadoc。
*
 */
public class MessageFormatTest {
	public static void main(String[] args) {
		//①信息格式化串    
		String pattern1 = "{0}，你好！你于 {1} 在工商银行存入 {2} 元。";  
		String pattern2 = "At {1,time,short} On {1,date,long}，{0} paid {2,number, currency}.";  
		//②用于动态替换占位符的参数    
		Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};  
		//③使用默认本地化对象格式化信息    
		String msg1 = MessageFormat.format(pattern1, params);  
		//④使用指定的本地化对象格式化信息    
		MessageFormat mf = new MessageFormat(pattern2, Locale.US);  
		String msg2 = mf.format(params);  
		System.out.println(msg1);  
		System.out.println(msg2);  
	}
}
