package com.practiceMaven;

import org.testng.annotations.Test;

public class RunTimeParameterFromEclipse {
	
	@Test
	public void getRunTimeData()
	{
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("username"));
		System.out.println(System.getProperty("password"));
	}

}
