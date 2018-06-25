package com.dc.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
/**
 * 
*
* @ClassName: GreetingBeforeAdvice 
* @author Liqn
* @date 2018年6月25日 下午3:14:23 
* @Description: TODO 
*	这个类实现了 org.springframework.aop.MethodBeforeAdvice 接口，我们将需要增强的代码放入其中。
 */
@Component
public class GreetingBeforeAdvice2 implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)throws Throwable {
		System.out.println("Before2");
	}

	
	
}
