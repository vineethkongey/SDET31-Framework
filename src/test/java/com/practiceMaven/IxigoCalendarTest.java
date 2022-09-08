package com.practiceMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IxigoCalendarTest {
	public static void main(String[] args) throws Throwable {
		  WebDriver driver = null;
			
			/* Object creation of utility classes */
			ExcelDataUtility eLib = new ExcelDataUtility();
			PropertiesFileUtility pLib = new PropertiesFileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			JavaUtility jLib = new JavaUtility();
			
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
			driver.get("https://www.ixigo.com/flights");
			driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
			
			for(;;)
			{
				try {
					
				
					driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='rd-month']/descendant::div[text()='10']")).click();
			    }
				
				
				catch(Exception e)
				{
					
					driver.findElement(By.xpath("//button[@class='ixi-icon-arrow rd-next']")).click();
				}
			
			}
			
			
			
			
		

}
}
