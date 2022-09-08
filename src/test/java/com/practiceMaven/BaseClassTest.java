package com.practiceMaven;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	
	@BeforeSuite
	public void beforeSuit()
	{
		
		System.out.println("bs is running");
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("bfc is running");
		
	}
	
	@AfterClass
	
	public void afterClass()
	{
		System.out.println("afc is running");
	}
	
	@AfterSuite
	
	public void afterSuit()
	{
		System.out.println("as is running");
	}

}
