package com.dc.springaop.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.dc.Apology;
import com.dc.ApologyImpl;

//@Aspect
@Component
public class GreetingAdvisor {
	
	/**
	    value：目标类

		defaultImpl：引入接口的默认实现类
	 */
	@DeclareParents(value = "com.dc.GreetingImpl", defaultImpl = ApologyImpl.class)
	private Apology apology;

	@Around("execution(* com.dc.GreetingImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
		before();
        Object result = pjp.proceed();
        after();
        return result;
    }
	
	@Around("@annotation(com.dc.springaop.pointcut.Tag)")
	public Object aroundAnnotation(ProceedingJoinPoint pjp) throws Throwable {
		before();
		Object result = pjp.proceed();
		after();
		return result;
	}
	
	
    private void before() {
        System.out.println("Aspect   Before");
    }

    private void after() {
        System.out.println("Aspect   After");
    }
	
}
