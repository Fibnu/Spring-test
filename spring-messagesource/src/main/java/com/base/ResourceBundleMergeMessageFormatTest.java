package com.base;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleMergeMessageFormatTest {
	public static void main(String[] args) {
		ResourceBundle resourceBundle1 = ResourceBundle.getBundle("com/base/fmt_ resource_en_US", Locale.US);
		ResourceBundle resourceBundle2 = ResourceBundle.getBundle("com/base/fmt_ resource_zh_CN", Locale.CHINA);
		
		Object[] parmsObjects = {"John",new GregorianCalendar().getTime()};
		
		String str1 = new MessageFormat(resourceBundle1.getString("greeting.common"),Locale.US).format(parmsObjects);
		String str2 = new MessageFormat(resourceBundle2.getString("greeting.common"), Locale.CHINA).format(parmsObjects);
		
		System.out.println(str1);
		System.out.println(str2);
		
	}
}
