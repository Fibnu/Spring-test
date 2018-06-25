package com.dc.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: GreetingafterAdvice 
* @author Liqn
* @date 2018年6月25日 下午3:15:23 
* @Description: TODO 
*	这个后置增强,方法出错，就不输出了
 */
@Component
public class GreetingafterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After hello");
	}

}
