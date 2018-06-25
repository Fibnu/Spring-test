package com.dc.base.cglib.example;
/**
 * 
*
* @ClassName: TestClass 
* @author Liqn
* @date 2018年6月25日 下午2:14:05 
* @Description: TODO 
*	测试类
 */
public class TestClass {

	public TestClass(){
		System.out.println("空构造函数...");
	}
	
	public TestClass(int i){
		System.out.println("有参构造函数....");
	}
	
	public void sayHello(){
		System.out.println("HEllO CGLIB.....");
	}
	
	public void queryObject(){
		
		System.out.println("query object ,,,,,,");
	}
	
    public String methodForFixedValue(String param) {  
        return "Hello_" + param;  
    }  
	
    public String methodForNoop() {  
        return "Hello_Noop";  
    }  
	
}
