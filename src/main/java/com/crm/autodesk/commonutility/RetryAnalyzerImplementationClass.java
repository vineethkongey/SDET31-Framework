package com.crm.autodesk.commonutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer{
	
	int count = 0;
	int retryCount=7;
	public boolean retry(ITestResult result) {
		
		if(count<retryCount)
		{
			count++;
			System.out.println("retrying");
			return true;
		}
		
		return false;
	}

}
