package com.practiceMaven;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {
	
	@Test
	public void softAssertPractice()
	{
		SoftAssert s = new SoftAssert();
		
		String act = "Soumyajit";
		String exp = "Soumyaji";
		
		s.assertEquals(exp, act);
		
		
		
		int x=5;
		int y=10;
		s.assertEquals(x, y);
		s.assertAll("failed");
		
	}

}
