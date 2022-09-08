package com.crm.autodesk.productsPOMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

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
 * This Test Script will create a custom filter all mandatory fields and select the Set As Default,List in Metrics,Set as Public check boxes.
 * @author Soumyajit
 *
 */

public class CreateCustomFilter {
	public static void main(String[] args) throws Throwable {
        WebDriver driver =null;
		
		/* object creation for utility classes*/
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		/*Properties file data fetching*/
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
		
		/*Select the check boxes*/
		customFilPage.selectSetAsDefault();
		customFilPage.SelectListInMactrix();
		customFilPage.selectSetAsPublic();
		
		/*Save the Custom Filter*/
		customFilPage.clickOnSaveButton();
		
		/*Product Page validation*/
		String title= eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Products", 1, 5);
		System.out.println(title);
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle().contains(title ),true);
		
		/*
		 * if(driver.getTitle().contains(title)) {
		 * System.out.println("Product Page is displayed"); } else {
		 * 
		 * System.out.println("Product page is not displayed"); }
		 */
		
		
		
		/*Sign Out*/
		
		  HomePage homepage =new HomePage(driver); 
		  homepage.signOut(driver);
		  
		  /*Close the browser*/
		  driver.quit();
		 
		
	}

}
