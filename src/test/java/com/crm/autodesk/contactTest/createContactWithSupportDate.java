package com.crm.autodesk.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createContactWithSupportDate {
public static void main(String[] args) throws Throwable {
	WebDriver driver = null;
	
	/* object creation for utility classes*/
	ExcelDataUtility eLib = new ExcelDataUtility();
	PropertiesFileUtility pLib = new PropertiesFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	
	//Properties file
	String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
	String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
	String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
	String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");
	
	//Read from excel data for contact
	
			String lastName = eLib.getExcelData("./src/test/resources/ContactDetails.xlsx", "Contacts", 1, 1);
			lastName = lastName + jLib.getRandomNum();
			//launch browser
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			wLib.implicitWait(driver,10);
			driver.get(url);
			driver.manage().window().maximize();
			
			//login to application
			
			driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB, password, Keys.ENTER );
			
			//click on contact
			
			driver.findElement(By.linkText("Contacts")).click();
			
			//click on create contact
			
			driver.findElement(By.xpath("//img[@title = 'Create Contact...']")).click();
			
			
			//fill mandatory fields
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			//choose support date
			driver.findElement(By.cssSelector("input[name='support_start_date']")).clear();
			
			driver.findElement(By.cssSelector("input[name='support_start_date']")).sendKeys(jLib.getSystemDate());
			
            driver.findElement(By.cssSelector("input[name='support_end_date']")).clear();
			
			driver.findElement(By.cssSelector("input[name='support_end_date']")).sendKeys(jLib.getSystemDate());
			
			//click on save
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//validation
			String inf = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		   
		    
		    if(inf.equals(lastName))
		    {
		    	System.out.println(lastName + " contact created successfully");
		    }
		    else
		    {
		    	System.out.println("Failed to create contact");
		    }
			
			//logout from application
			
			WebElement wb = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td/img"));
			wLib.mouseOverToElement(driver,wb);
			
			/*
			 * Actions act = new Actions(driver); act.moveToElement(wb).perform();
			 */
			
			driver.findElement(By.linkText("Sign Out")).click();
}
}
