package com.crm.autodesk.organisationTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;
import com.practiceMaven.ExcelData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganisation {
public static void main(String[] args) throws Throwable{
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
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String validation = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(validation.contains(orgName))
		{
			System.out.println(orgName + " is created successfully");
		}
		 else
		{
			System.out.println(orgName + "is not created successfully");
		}
		
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wLib.mouseOverToElement(driver, wb);
		
		/*
		 * Actions act = new Actions(driver); act.moveToElement(wb).perform();
		 */
		
		driver.findElement(By.linkText("Sign Out")).click();
		
	
	}
}
