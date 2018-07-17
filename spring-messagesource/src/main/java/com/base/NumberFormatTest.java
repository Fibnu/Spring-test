package com.base;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * NumberFormat按本地化的方式对货币金额进行格式化操作
*
* @ClassName: NumberFormatTest 
* @author Liqn
* @date 2018年7月17日 下午9:36:33 
* @Description: TODO 
*
 */
public class NumberFormatTest {
	public static void main(String[] args) {
		Locale locale = new Locale("zh","CN");
		NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);    
		double amt = 123456.78;    
		System.out.println(currFmt.format(amt));  
	}
}
