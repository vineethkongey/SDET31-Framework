package com.practiceMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationAndDelete {
	public static void main(String[] args) throws Throwable {
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
			
			driver.findElement(By.linkText("Organizations")).click();
			
			 //List<WebElement> orgList = driver.findElements(By.xpath("//a[@title='Organizations']"));
			
			for(;;)
			{
				List<WebElement> orgList = driver.findElements(By.xpath("//a[@title='Organizations']"));
				try
				{
				
				for(WebElement wb:orgList)
				{
					if(wb.getText().equals(orgName))
					{
						System.out.println("Organization created successfully");
						break;
					}
				}
				
				
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='pagenum']/following-sibling::a/img[@src ='themes/images/next.gif']")));
			//driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='pagenum']/following-sibling::a/img[@src ='themes/images/next.gif']")).click();
			Thread.sleep(2000);
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//a[@title='Organizations']"))));
//			
			
			
//			  FluentWait wait = new FluentWait(driver);
//			  wait.pollingEvery(Duration.ofSeconds(5));
//			  wait.withTimeout(Duration.ofSeconds(30));
//			  wait.ignoring(StaleElementReferenceException.class);
//			  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='pagenum']/following-sibling::a/img[@src ='themes/images/next.gif']"))));
				}
				catch(Exception e)
				{
					for(WebElement wb:orgList)
					{
						if(wb.getText().equals(orgName))
						{
							
							wb.click();
							driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
							Alert alt = driver.switchTo().alert();
							alt.accept();
							System.out.println("Organization deleted successfully");
							break;
						}
					}
					break;
				}
				
	        }
			
			WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			  Actions act = new Actions(driver); 
			  act.moveToElement(wb).perform();
			 
			driver.findElement(By.linkText("Sign Out")).click();
			//driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
			
	}}


