package com.dc.springaop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

import com.dc.Apology;

/**
 * 
*
* @ClassName: GreetingIntroAdvice 
* @author Liqn
* @date 2018年6月25日 下午4:00:14 
* @Description: TODO 
*	引入增强必须集成DelegatingIntroductionInterceptor拦截器
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology{

	  @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }
	
	@Override
	public void saySorry(String name) {
		System.out.println("Sorry! " + name);
	}

}
