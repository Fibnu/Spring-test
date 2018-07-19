package com.base;

import java.util.Observable;

public class ObservableTest extends Observable{

	public void say(){
		this.setChanged();// 设置变化
		this.notifyObservers("你好，观察者们");
	}
	
}
