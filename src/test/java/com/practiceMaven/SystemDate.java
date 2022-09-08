package com.practiceMaven;

import java.util.Date;

public class SystemDate {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		//String d = d.toString();
		int date = d.getDate();
		System.out.println(date);
		int month = d.getMonth();
		System.out.println(month);
		int year = d.getYear();
		year = year+1900;
		System.out.println(year);
		
	
		String yyyymmdd = year + "-" + month + "-" + date;
		System.out.println(yyyymmdd);
		
		
	}

}
