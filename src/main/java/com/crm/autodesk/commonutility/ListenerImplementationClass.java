


package com.crm.autodesk.commonutility;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class contains the implementation of all the methods of of ITestListener interface. 
 * @author Soumyajit
 *
 */
public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports exReport;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		/* Step:3 Create a test method during the test execution start*/
     	test=exReport.createTest(result.getMethod().getMethodName());
	    
	
	}

	public void onTestSuccess(ITestResult result) {
		/*Step:4 Log the pass method*/
		
		test.log(Status.PASS,result.getMethod().getMethodName());	
		
	}

	public void onTestFailure( ITestResult result) {
		
		/*Log fail method, take screenshot, attach screenshot to extent report, add exception log*/
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String filePath = null;
		
		try {
			 filePath = new WebDriverUtility().takeScreenshotOfPage(BaseClass.stDriver, result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath);
		
	}

	public void onTestSkipped(ITestResult result) {
		
		/*step:6 Log the skip method()*/
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	
	}


	public void onStart(ITestContext context) {
		
		System.out.println("Execution of Test Script started");
		
		/*Step:1 Extent report configuration*/
		
		Date d = new Date();
		String date = d.toString().replace(" ", "-").replace(":", "-");
		ExtentSparkReporter report = new ExtentSparkReporter("./Extent Report/ExtentReport" +" "+ date + ".html");
		report.config().setReportName("Smoke Test Report");
		report.config().setDocumentTitle("Autodesk Framework Report");
		report.config().setTheme(Theme.DARK);
		
		/*Step:2 Attach the physical report and do the system configuration*/
		
		exReport = new ExtentReports();
		exReport.attachReporter(report);
		exReport.setSystemInfo("OS", "Windows 11");
		exReport.setSystemInfo("Environment", "Testing Environment");
		exReport.setSystemInfo("URL", "http://localhost:8888");
		exReport.setSystemInfo("Reporter Name", "Soumyajit");
		
		
		
	
	}

	public void onFinish(ITestContext context) {
		exReport.flush();

		
 
	}
	
	

}
