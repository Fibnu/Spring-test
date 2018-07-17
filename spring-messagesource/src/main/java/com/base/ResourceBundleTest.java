package com.base;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
*
* @ClassName: ResourceBundleTest 
* @author Liqn
* @date 2018年7月17日 下午9:56:40 
* @Description: TODO 
*		国际化资源文件的命名规范规定资源名称采用以下的方式进行命名：
*　				　<资源名>_<语言代码>_<国家/地区代码>.properties
*		地区：http://www.iso.ch/iso/en/prods-services/iso3166ma/02iso-3166-code-lists/list-en1.html。
*	            语言：http://www.loc.gov/standards/iso639-2/php/English_list.php。
*
 */
public class ResourceBundleTest {
	public static void main(String[] args) {
		/**
		 * ResourceBundle在加载资源时，如果指定的本地化资源文件不存在，它按以下顺序尝试加载其他的资源：本地系统默认本地化对象对应的资源→默认的资源。
		 */
		ResourceBundle rb1 = ResourceBundle.getBundle("com/base/resource", Locale.US);  
		ResourceBundle rb2 = ResourceBundle.getBundle("com/base/resource", Locale.CHINA);  
		ResourceBundle rb3 = ResourceBundle.getBundle("com/base/resource", Locale.CANADA);  
		System.out.println("us:"+rb1.getString("greeting.common"));  
		System.out.println("cn:"+rb2.getString("greeting.common"));  
		System.out.println("canada:"+rb3.getString("greeting.common"));  
	}
	
}
