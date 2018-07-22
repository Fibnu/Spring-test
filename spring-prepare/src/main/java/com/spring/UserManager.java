package com.spring;

import java.util.Date;

public class UserManager {
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserManager [date=" + date + "]";
	}
	
	
	
}
