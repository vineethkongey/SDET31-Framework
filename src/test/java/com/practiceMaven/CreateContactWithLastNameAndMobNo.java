package com.practiceMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithLastNameAndMobNo {
	
	@Test(dataProvider="provideLastNameAndMobNum")
	public void createContact(String lastName,String mobileNum)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobileNum);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement name = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));
		
		if(name.getText().equals(lastName))
		{
			System.out.println("Conact with " + lastName + " created successfully");
		}
		else
		{
			System.out.println("Falied to create Contact");
		}
		
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		  Actions act = new Actions(driver); 
		  act.moveToElement(wb).perform();
		 
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] provideLastNameAndMobNum()
	{
		
		Object objArray[][] = new Object[5][2];
		
		objArray[0][0]="Soumya";
		objArray[0][1]="9348738168";
		
		objArray[1][0]="Soumyajit";
		objArray[1][1]="9438571031";
		
		objArray[2][0]="Soumyashree";
		objArray[2][1]="1234567890";
		
		objArray[3][0]="Swati";
		objArray[3][1]="9237829291";
		
		objArray[4][0]="Suman";
		objArray[4][1]="9438272614";
		
		return objArray;
		
		
	}

}
