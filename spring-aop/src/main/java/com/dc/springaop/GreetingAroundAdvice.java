package com.dc.springaop;

import org.aopalliance.intercept.MethodInterceptor; 
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 
*
* @ClassName: GreetingAroundAdvice 
* @author Liqn
* @date 2018年6月25日 下午3:22:50 
* @Description: TODO 
*   环绕增强类需要实现 org.aopalliance.intercept.MethodInterceptor 接口。注意，这个接口不是 Spring 提供的，它是 AOP 联盟（一个很牛逼的联盟）写的，Spring 只是借用了它。
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {

	/**
	 * MethodInvocation这个在源码中实现类是 ReflectiveMethodInvocation,这个类就是将目标类，代理类，实现接口，增强等
	 * 参数合并到一起，然后调用proceed()方法，执行增强链
	 * 
	 * 
	 * 
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		before();
		Object reuslt = invocation.proceed();
		after();  
		return reuslt;
	}

	private void after() {
		System.out.println("around after");
	}

	private void before() {
		System.out.println("around before");
		
	}

}
