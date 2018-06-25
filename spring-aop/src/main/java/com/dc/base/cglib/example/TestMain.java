package com.dc.base.cglib.example;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.LazyLoader;
import org.springframework.cglib.proxy.NoOp;

public class TestMain {

	public static void main(String[] args) {
		
		onlyNoArgsCallBackInvoke(); // 单回调
		
		System.out.println("==============================");
		
		multCallBackInvoke(); // 多回调
		
		System.out.println("==============================");

		noDeal(); // 不处理？ 这个有点问题，原方法都没有处理？
		
		System.out.println("==============================");
		
		fixValue(); // 返回固定值
		
		System.out.println("==============================");
		
		lazyLoad();// 懒加载
		
	}
	
	/**
	 * 
	* @param 
	* @return void
	* @throws 
	* @author Liqn
	* @date 2018年6月25日 下午2:25:11 
	* @Description: TODO 
	*   单回调 目标类无参构造 
	*
	 */
	public static void onlyNoArgsCallBackInvoke(){
//		TestClass testClass = (TestClass)Enhancer.create(TestClass.class, new TestClassProxy());
//		testClass.sayHello();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestClass.class);
		enhancer.setCallback(new TestClassProxy());
		TestClass testClass =(TestClass) enhancer.create();
		testClass.sayHello();
		
		
	}
	
	/**
	 * 
	* @param 
	* @return void
	* @throws 
	* @author Liqn
	* @date 2018年6月25日 下午2:26:57 
	* @Description: TODO 
	*  多回调 在前面的基础上，加个切入类，并通过CallbackFilter来决定是使用哪个切入类,
	*
	 */
	public static void multCallBackInvoke(){
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestClass.class);
		
		TestClassProxy callback1 = new TestClassProxy();
		TestClassProxy2 callback2 = new TestClassProxy2();
		enhancer.setCallbacks(new Callback[]{callback1,callback2});

		
		enhancer.setCallbackFilter(new CallbackFilter() {
			/**
			 * 设置哪个方法用哪个拦截类
			 * return值指的是CallBack[]数组的下标
			 */
			@Override
			public int accept(Method method) {
				if(method.getName().equals("sayHello")){
					return 1;
				}
				return 0;
			}
		});
		
		TestClass testClass = (TestClass)enhancer.create();
		
		testClass.sayHello();
		testClass.queryObject();
	}
	
	/**
	 * 
	* @param 
	* @return void
	* @throws 
	* @author Liqn
	* @date 2018年6月25日 下午2:43:32 
	* @Description: TODO 
	*    执行某些方法时不处理
	*
	 */
	public static void noDeal(){
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestClass.class);
		
		TestClassProxy callback1 = new TestClassProxy();
		TestClassProxy2 callback2 = new TestClassProxy2();
		Callback noopCb = NoOp.INSTANCE;  
		enhancer.setCallbacks(new Callback[]{callback1,callback2,noopCb});
		
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if(method.getName().equals("queryObject")){
					return 0;
				}else if(method.getName().equals("sayHello")){
					return 1;
				}
				return 2;
			}
		});
		TestClass testClass = (TestClass)enhancer.create();
		testClass.sayHello();
		testClass.queryObject();
		testClass.methodForNoop();
		
	}
	/**
	 * 
	 * @param 
	 * @return void
	 * @throws 
	 * @author Liqn
	 * @date 2018年6月25日 下午2:43:32 
	 * @Description: TODO 
	 *    执行某些方法时不处理
	 *
	 */
	public static void fixValue(){
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestClass.class);
		
		TestClassProxy callback1 = new TestClassProxy();
		TestClassProxy2 callback2 = new TestClassProxy2();
		Callback noopCb = NoOp.INSTANCE;  
		Callback fixedValue = new DBQueryProxyFixedValue();  
		enhancer.setCallbacks(new Callback[]{callback1,callback2,noopCb,fixedValue});
		
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if(method.getName().equals("queryObject")){
					return 0;
				}else if(method.getName().equals("sayHello")){
					return 1;
				}else if(method.getName().equals("methodForFixedValue")){
					return 3;
				}
				return 2;
			}
		});
		TestClass testClass = (TestClass)enhancer.create();
		testClass.sayHello();
		testClass.queryObject();
		testClass.methodForNoop();
		testClass.methodForFixedValue("one");
	}
	
	/**
	 * 
	* @param 
	* @return void
	* @throws 
	* @author Liqn
	* @date 2018年6月25日 下午2:55:52 
	* @Description: TODO 
	*  懒加载  
	*		需要了解2个接口，LazyLoader和Dispatcher。它们都继承了Callback接口，区别 LazyLoader的loadObject方法仅执行一次， Dispatcher每次都执行
	 */
	public static void lazyLoad(){
        Student student = new Student(666, "XiaoMing");  
        System.out.println("id=" + student);  
        System.out.println("name=" + student.getName());  
        // LazyLoader 只有第一次，Dispatcher是每次都会进loadObject的方法  
        System.out.println("========First Get  EnglishSchedule ========");  
        System.out.println(student.getEnglishSchedule());  
        System.out.println();  
        System.out.println("========First Get  MathSchedule ========");  
        System.out.println(student.getMathSchedule());  
        System.out.println();  
        System.out.println("========Second Get  EnglishSchedule ========");  
        System.out.println(student.getEnglishSchedule());  
        System.out.println();  
        System.out.println("========Second Get  MathSchedule ========");  
        System.out.println(student.getMathSchedule());  
		
		
	}
	
}
class Schedule {  
	  
    private String courseName;  
  
    private Date courseTime;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(Date courseTime) {
		this.courseTime = courseTime;
	}  
    
    
}  

class ScheduleLazyLoader implements LazyLoader {  
	  
    public Object loadObject() throws Exception {  
        System.out.println("before LazyLoader init...you can query from db...");  
        Schedule schedule = new Schedule();  
        schedule.setCourseName("English");  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(2017,3,28);  
        schedule.setCourseTime(calendar.getTime());  
        System.out.println("after LazyLoader init...");  
        return schedule;  
    }  
}  


class ScheduleDispatcher implements Dispatcher {  
	  
    public Object loadObject() throws Exception {  
        System.out.println("before Dispatcher init...you can query from db...");  
        Schedule schedule = new Schedule();  
        schedule.setCourseName("Math");  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(2017,4,1);  
        schedule.setCourseTime(calendar.getTime());  
        System.out.println("after Dispatcher init...");  
        return schedule;  
    }  
}  

/**
 * 
*
* @ClassName: Student 
* @author Liqn
* @date 2018年6月25日 下午2:58:51 
* @Description: TODO 
*	定义时，需要对EnglishSchedule和MathSchedule先初始为动态代理的对象
 */
class Student {  
	  
    private int id;  
  
    private String name;  
  
    /** 
     * 英语课时间表 
     */  
    private Schedule EnglishSchedule;  
  
    /** 
     * 数学课时间表 
     */  
    private Schedule MathSchedule;  
  
    public Student(int id, String name) {  
        this.id = id;  
        this.name = name;  
        this.EnglishSchedule = createEnglishSchedule();  
        this.MathSchedule = createMathSchedule();  
    }  
  
    private Schedule createEnglishSchedule() {  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(Schedule.class);  
        enhancer.setCallback(new ScheduleLazyLoader());  
        return (Schedule) enhancer.create();  
    }  
  
    private Schedule createMathSchedule() {  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(Schedule.class);  
        enhancer.setCallback(new ScheduleDispatcher());  
        return (Schedule) enhancer.create();  
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Schedule getEnglishSchedule() {
		return EnglishSchedule;
	}

	public void setEnglishSchedule(Schedule englishSchedule) {
		EnglishSchedule = englishSchedule;
	}

	public Schedule getMathSchedule() {
		return MathSchedule;
	}

	public void setMathSchedule(Schedule mathSchedule) {
		MathSchedule = mathSchedule;
	}  
    
    
}  

class DBQueryProxyFixedValue implements FixedValue {  
	  
    public Object loadObject() throws Exception {  
        System.out.println("Here in DBQueryProxyFixedValue ! ");  
        return "Fixed Value";  
    }  
}  
