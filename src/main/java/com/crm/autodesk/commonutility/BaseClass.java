package com.crm.autodesk.commonutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class can perform launching, closing the browser and also login,logout from the application.
 * @author Soumyajit
 *
 */
public class BaseClass {
	/*Object creation of common utility*/
	public WebDriver driver =  null;
	public ExcelDataUtility eLib = new ExcelDataUtility();
	public PropertiesFileUtility pLib = new PropertiesFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public static WebDriver stDriver;
	
	
	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite()
	{
	 System.out.println("This is used to connect to the database");
	}
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest()
	{
		System.out.println("This is used to do parallel execution");
	}
	
	/**
	 * This method will launch the browser.
	 * @throws Throwable
	 */
	//@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void beforeClass() throws Throwable
	{
		String browser = pLib.getValuesForPropertiesFile(IPathConstants.PROPERTYFILE_PATH, "browser");
		String url = pLib.getValuesForPropertiesFile(IPathConstants.PROPERTYFILE_PATH, "url");	
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		
		wLib.implicitWait(driver,10);
		driver.manage().window().maximize();
		driver.get(url);
		stDriver = driver;
	}
	
	/**
	 * This method will login to the application.
	 * @throws Throwable
	 */
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Throwable
	{
		String username = pLib.getValuesForPropertiesFile(IPathConstants.PROPERTYFILE_PATH, "username");
		String password = pLib.getValuesForPropertiesFile(IPathConstants.PROPERTYFILE_PATH, "password");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
	}
	
	/**
	 * This method will logout from the application. 
	 */
	@AfterMethod(alwaysRun=true)
	public void afterMethod()
	{
		 HomePage homepage =new HomePage(driver); 
		  homepage.signOut(driver);
	}
	
	
	/**
	 * This method will close the browser.
	 */
	@AfterClass(alwaysRun=true)
	public void afterClass()
	{
		 driver.quit();
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest()
	{
		System.out.println("This is used to close the  parallel Execution");
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite()
	{
		System.out.println("This is used to close the connection to database");
	}
	
	
	

}
