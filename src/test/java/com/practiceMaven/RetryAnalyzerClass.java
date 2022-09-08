package com.practiceMaven;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.commonutility.BaseClass;

public class RetryAnalyzerClass {
	
	@Test(retryAnalyzer=com.crm.autodesk.commonutility.RetryAnalyzerImplementationClass.class)
	public void practiceRetryAnalyzer()
	{
		
		String act="Miku";
		String exp = "iku";
		Assert.assertEquals(act, exp);
	}
	
	

}
