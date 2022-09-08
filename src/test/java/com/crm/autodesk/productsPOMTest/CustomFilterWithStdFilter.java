package com.crm.autodesk.productsPOMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;
import com.crm.autodesk.pageObjectModelLib.CustomFilterPage;
import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;
import com.crm.autodesk.pageObjectModelLib.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Test Script will create a custom filter and also add a Simple Time Filter from Standard Filter option.
 * @author Soumyajit
 *
 */
public class CustomFilterWithStdFilter {
	public static void main(String[] args) throws Throwable {
WebDriver driver =null;
		
		/* object creation for utility classes*/
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		//Properties file data fetching
		String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
		String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
		String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
		String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");
		
		
		/* Launching the browser */
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
		driver.manage().window().maximize();
		driver.get(url);
		
		/*Login to the Application*/
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		/*Click on the Product Link*/
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProducts();
		
		/*Click on create filter*/
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnCreateFilter();
		
		/*Fill the view Name*/
		String viewName = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Products", 1, 0);
		CustomFilterPage customFilPage = new CustomFilterPage(driver);
		customFilPage.enterViewName(viewName);
		
		/*Select the column*/
		String columnName = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Products", 1, 1);
		customFilPage.selectColoumn(columnName);
		
		/*select the Duration*/
		String duration = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Products", 1, 2);
		customFilPage.selectDuration(duration);
		
		Thread.sleep(2000);
		/*Enter the start Date*/
		customFilPage.enterStartDate();
		
		Thread.sleep(2000);
		/*Enter the end date*/
		String endDate = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Products", 1, 4);
		customFilPage.enterEndDate(endDate);
		
		/*Click on save*/
		customFilPage.clickOnSaveButton();
		
		/*Validation of Product Page*/
		String title= eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Products", 1, 5);
		
		Assert.assertEquals(driver.getTitle().contains(title), true);
		
		/*
		 * if(driver.getTitle().contains(title)) {
		 * System.out.println("Product Page is displayed"); } else {
		 * 
		 * System.out.println("Product page is not displayed"); }
		 */
		
		/*Sign Out from the Application*/
		
		  HomePage homepage =new HomePage(driver); 
		  homepage.signOut(driver);
		  
		  /*Close the browser*/
		  driver.quit();
	}

}
