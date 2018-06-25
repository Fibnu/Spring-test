package com.dc;

import org.springframework.stereotype.Component;

import com.dc.springaop.pointcut.Tag;

@Component
public class GreetingImpl implements Greeting{ 

	public void sayHello() {
		System.out.println("Hello world!!");
		
//		throw new RuntimeException("11211");
	}
	
	// greeting接口中没有改方法
	@Tag
   public void goodMorning(String name) {
        System.out.println("Good Morning! " + name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night! " + name);
    }

}
