package com.practiceMaven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider="provideDataToMethod")
	public void getMultipleData(String name,String emailID,String empID)
	{
	System.out.println("Name is: " + name);
	System.out.println("Email ID is: " + emailID);
	System.out.println("EMP ID is: " + empID);
	
	System.out.println("========================");
	}
	
	@DataProvider
	public Object[][] provideDataToMethod()
	{
		Object[][] objArray = new Object[2][3];
		
		objArray[0][0] ="Soumyajit";
		objArray[0][1] = "soumya@gmail.com";
		objArray[0][2] = "Emp01";
		
		objArray[1][0] = "Saumyashree";
		objArray[1][1] = "saumya@gmail.com";
		objArray[1][2] = "Emp02";
		
		return objArray;
		
 		
	}

}
