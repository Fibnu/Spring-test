package com.spring.propertyedit;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
*
* @ClassName: DatePropertyEdit 
* @author Liqn
* @date 2018年7月22日 下午5:10:24 
* @Description: TODO 
*	自定义属性编辑器
 */
public class DatePropertyEdit extends PropertyEditorSupport{

	private String format="yyyy-MM-dd";

	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(text);
			this.setValue(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
