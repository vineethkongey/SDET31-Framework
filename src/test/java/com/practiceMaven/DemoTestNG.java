package com.practiceMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTestNG {

	@Test(invocationCount = 1)
	public void createOrganization() throws Throwable
	{
		WebDriver driver = null;
		
		/* object creation for utility classes*/
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		//properties file common data
		
		String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
		String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
		String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
		String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");
		
		
		/* Random number generation*/
		int randomNum = jLib.getRandomNum();
		//get data from excel sheet

		String orgName = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Organisation", 1, 0);
		orgName = orgName + randomNum;
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();

		}
		    wLib.implicitWait(driver,10);
		
		
			driver.get("http://localhost:8888/");
			
			driver.manage().window().maximize();
			
			driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB, password, Keys.ENTER);
			
			driver.findElement(By.linkText("Organizations")).click();
			
			Thread.sleep(2000);
			wLib.scrollDownWindow(driver,0,500);
			
			/*
			 * JavascriptExecutor jse = (JavascriptExecutor)driver;
			 * jse.executeScript("window.scrollBy(0,500);");
			 */
			
			wLib.takeScreenshotOfPage(driver,"homepage");
			//System.out.println("tc passed");
			Reporter.log("tc passed",true);
	}
}
