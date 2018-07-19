package com.base;

import java.util.Observable;
import java.util.Observer;

public class ObserverTest1 implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ObservableTest){
			System.out.println((String)arg+" --> ObserverTest1");
		}
			
	}

}
