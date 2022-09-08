package com.practiceMaven;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;
import com.crm.autodesk.pageObjectModelLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPagePOMTest {
	public static void main(String[] args) throws Throwable {
		
		  WebDriver driver = null;
			
			/* Object creation of utility classes */
			
			PropertiesFileUtility pLib = new PropertiesFileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			
			
			String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
			String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");
			String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
			
			/*Properties file data fetching */
			
			String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
			
	        /* Launching  Browser*/
			
			if(browser.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browser.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			wLib.implicitWait(driver,10);
			driver.manage().window().maximize();
			driver.get(url);
		
	
		
		
		
		LoginPage loginpage  = new LoginPage(driver);
		loginpage.login(username, password);
	}

}
