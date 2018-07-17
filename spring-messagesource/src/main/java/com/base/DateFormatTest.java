package com.base;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
	public static void main(String[] args) {
		Locale locale = new Locale("en","US");
		DateFormat dFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
		System.out.println(dFormat.format(new Date()));
	}
}
