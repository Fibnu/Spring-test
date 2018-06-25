	package com.dc;

import org.springframework.stereotype.Component;

/**
 * 
*
* @ClassName: Apology 
* @author Liqn
* @date 2018年6月25日 下午3:55:17 
* @Description: TODO 
*		引入增强，对类的增强叫引入，对方法的增强叫织入
*
*不想在代码中让 GreetingImpl直接去实现这个接口，而是在程序运行的时候动态地实现它
*
 */
public interface Apology {
	void saySorry(String name);
}
