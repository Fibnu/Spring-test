package com.dc.userdefined.springAop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.aop.framework.ProxyFactory;

import com.dc.userdefined.springAop.crosscuttingconcern.UserDefinedAdvice;



/**
 */
public class UserDefinedProxyFactory{
	// 目标对象
	private Object target;
	private UserDefinedAdvise[] adviseArray = new UserDefinedAdvise[0];
	
	private List<UserDefinedAdvise> advises = new LinkedList<UserDefinedAdvise>();
	
	private Class[] interfaces;
	
	private UserDefinedAopProxyFactory userDefinedAopProxyFactory;
	public UserDefinedProxyFactory(){
		userDefinedAopProxyFactory = new DafaultUserDefinedAopProxyFactory();
	}
	
	public void setInterfaces(Class interfaces) {
		this.interfaces[this.interfaces.length] = interfaces;
	}

	public void setTarget(Object target){
		this.target = target;
	}
	
	public void addAdvice(UserDefinedAdvice advice){
		this.advises.add(this.advises.size(), new UserDefinedAdvise(advice));
		updateAdvisorArray();
		adviceChanged();
	}
	
	private void updateAdvisorArray() {
		this.adviseArray = this.advises.toArray(new UserDefinedAdvise[this.advises.size()]);
	}

	protected void adviceChanged() {
		this.methodCache.clear();
	}
	
	public UserDefinedAdvise[]  getAdvise(){
		return this.adviseArray ;
	}
	
	 public Class[] getInterfaces() {
		return interfaces;
	}

	public Object getTarget() {
		return target;
	}

	/** 
	  * spring 中这一步需要判断是用jdk代理，还是要用cglib代理
	  * 	这里仅用jdk做代理了
     */ 
    public Object getProxy() { 
    	return userDefinedAopProxyFactory.createAopProxy(this);
    }
    
    /**
     *  获取增强的拦截链
    * @param @param method
    * @param @param targetClass
    * @param @return
    * @return List<Object>
    * @throws 
    * @author Liqn
    * @date 2018年6月26日 下午10:21:11 
    * @Description: TODO 
    *    
    *
     */
    
    private transient Map<UserDifinedMethodCacheKey, List<Object>> methodCache  = new ConcurrentHashMap<UserDifinedMethodCacheKey, List<Object>>(32); ;
    AdviceChainFactory advisorChainFactory = new DefaultAdviceChainFactory();
	public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class<?> targetClass) {
		UserDifinedMethodCacheKey cacheKey = new UserDifinedMethodCacheKey(method);
		List<Object> cached = this.methodCache.get(cacheKey);
		if (cached == null) {
			cached = this.advisorChainFactory.getInterceptorsAndDynamicInterceptionAdvice(this, method, targetClass);
			this.methodCache.put(cacheKey, cached);
		}
		return cached;
	}
	
	private static final class UserDifinedMethodCacheKey implements Comparable<UserDifinedMethodCacheKey> {

		private final Method method;

		private final int hashCode;

		public UserDifinedMethodCacheKey(Method method) {
			this.method = method;
			this.hashCode = method.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (this == other || (other instanceof UserDifinedMethodCacheKey &&
					this.method == ((UserDifinedMethodCacheKey) other).method));
		}

		@Override
		public int hashCode() {
			return this.hashCode;
		}

		@Override
		public String toString() {
			return this.method.toString();
		}

		@Override
		public int compareTo(UserDifinedMethodCacheKey other) {
			int result = this.method.getName().compareTo(other.method.getName());
			if (result == 0) {
				result = this.method.toString().compareTo(other.method.toString());
			}
			return result;
		}
	}

	
	
	
}
