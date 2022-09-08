package com.crm.autodesk.commonutility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all the methods for handling java utility
 * @author Soumyajit
 *
 */
public class JavaUtility {
/**
 * This method will generate random numbers.
 * @return randomNum
 */
	public int getRandomNum()
	{
		Random randomRef = new Random();
		int randomNum = randomRef.nextInt();
		return randomNum;
	}
	
	/**
	 * This method will return the system date in the format of YYYY-MM-DD.
	 * @return yyyy_mm_dd
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		int date = d.getDate();
		int month = d.getMonth();
		int year = d.getYear();
		year = year+1900;
		
		String yyyy_mm_dd = year + "-" + month + "-" + date;
		return yyyy_mm_dd;
		
	}
}
