package com.spring.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDate implements Converter<String, Date>{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Date convert(String arg0) {
		try {
			return sdf.parse(arg0);
		} catch (ParseException e) {
			return null;	
		}
	}

}
