package com.base;
/**
 * 
*
* @ClassName: Test 
* @author Liqn
* @date 2018年7月19日 下午10:59:49 
* @Description: TODO 
*1，Observable是一个类，而不是一个接口，导致Observable类的扩展性不高，不如自己实现的观察者模式灵活

2，Observable将某些方法保护了起来(setChanged()和clearChanged()为protected)，这意味着除非继承自Observable，否则将有关键的方法不能调用。导致无法通过组合的方式使其它类获得Observable类的功能
 */
public class Test {
	public static void main(String[] args) {
		ObservableTest test = new ObservableTest();
		test.addObserver(new ObserverTest1());
		test.addObserver(new ObserverTest2());
		test.say();
	}
}	
