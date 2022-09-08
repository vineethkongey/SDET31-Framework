package com.practiceMaven;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.autodesk.commonutility.BaseClass;

public class ExtentReportPractice extends BaseClass {
	
	@Test
	public void testSuccess()
	{
		System.out.println("Method passed");
	}
	
	@Test
	public void testFailure()
	{
		Assert.fail();
	}
	
	@Test
	public void testSkipped()
	{
		throw new SkipException("skipping this execution");
	}

}
