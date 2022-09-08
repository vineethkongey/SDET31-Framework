package com.practiceMaven;

import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

public class XmlDataDrivenTesting {
	
	@Test
	public void fetchDataFromXml(XmlTest x)
	{
	
		System.out.println(x.getParameter("browser"));
		System.out.println(x.getParameter("url"));
		System.out.println(x.getParameter("username"));
		System.out.println(x.getParameter("password"));
		
	}

}
