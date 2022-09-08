package com.practiceMaven;

import org.testng.annotations.Test;

public class DependsOnPracticeTest {
	
	@Test
	public void freateOrganization() throws Throwable
	{
		System.out.println("Login");
		System.out.println("create Organization");
		System.out.println("Logout");
		System.out.println("======================");
		
		//throw new Exception();
	}
	
	@Test(dependsOnMethods="freateOrganization")
	public void editOrganization()
	{
		System.out.println("Login");
		System.out.println("Edit Organization");
		System.out.println("LogOut");
		System.out.println("======================");
	}
	
	@Test
	public void deleteOrganization()
	{
		System.out.println("Login");
		System.out.println("Delete Organization");
		System.out.println("LogOut");
		System.out.println("======================");
	}
	

}
