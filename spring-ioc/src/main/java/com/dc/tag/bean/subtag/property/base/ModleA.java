package com.dc.tag.bean.subtag.property.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ModleA {
	private ModleB modleB;
	private ModleC modleC;
	private ModleD modleD;
	private String name;
	private List<String> listStr ;
	private Set<String> setStr ;
	private Map<String,Integer> mapStr ;
	
	private Properties propStr;
	
	private String brand;
	
	public void sayHello(){
		System.out.println("brand: "+brand);
		this.modleB.sayHello(name);
		for(String s:listStr){
			System.out.println("listStr 元素"+s);
			
		}
		for(String s:setStr){
			System.out.println("setStr 元素"+s);
		}
		
		for(Map.Entry<String, Integer> entry : mapStr.entrySet() ){
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
		}
		for(Map.Entry entry : this.propStr.entrySet() ){
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
		}
		
		
	}

	public ModleB getModleB() {
		return modleB;
	}

	public void setModleB(ModleB modleB) {
		this.modleB = modleB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModleC getModleC() {
		return modleC;
	}

	public void setModleC(ModleC modleC) {
		this.modleC = modleC;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ModleD getModleD() {
		return modleD;
	}

	public void setModleD(ModleD modleD) {
		this.modleD = modleD;
	}

	public List<String> getListStr() {
		return listStr;
	}

	public void setListStr(List<String> listStr) {
		this.listStr = listStr;
	}

	public Set<String> getSetStr() {
		return setStr;
	}

	public void setSetStr(Set<String> setStr) {
		this.setStr = setStr;
	}

	public Map<String, Integer> getMapStr() {
		return mapStr;
	}

	public void setMapStr(Map<String, Integer> mapStr) {
		this.mapStr = mapStr;
	}

	public Properties getPropStr() {
		return propStr;
	}

	public void setPropStr(Properties propStr) {
		this.propStr = propStr;
	}

	
	
}
