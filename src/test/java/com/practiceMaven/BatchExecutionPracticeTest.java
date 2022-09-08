package com.practiceMaven;

import org.testng.annotations.Test;

public class BatchExecutionPracticeTest {
	
	@Test(groups="smokeTest")
	public void createContact()
	{
		System.out.println("Contact created successfully");
	}
	
	@Test(groups="regressionTest")
	public void createOrganization()
	{
		System.out.println("organization created successfully");
	}
	
	@Test(groups="smokeTest")
	public void createProduct()
	{
		System.out.println("product created successfully");
	}
	
	@Test(groups="regressionTest")
	public void createCampaign()
	{
		System.out.println("Campaign created successfully");
	}

}
