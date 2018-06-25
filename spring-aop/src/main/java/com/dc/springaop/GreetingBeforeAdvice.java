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
*
*   前置增强应该是个钩子方法，调用的应该是
*   	
*   public void **（MethodInvocation invocation）{
*   	before();
*   	invocation.proceed（）;
*   }
*   
*   完成增强链
*
 */
@Component
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)throws Throwable {
		System.out.println("Before");
	}

	
	
}
