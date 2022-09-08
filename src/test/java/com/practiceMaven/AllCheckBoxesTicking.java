package com.practiceMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllCheckBoxesTicking {
	public static void main(String[] args) {
		
	
	/*Launch the browser*/
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	/*Login to the app*/
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin", Keys.TAB,"root",Keys.ENTER);
	
	/*Click on Lead Link*/
	driver.findElement(By.linkText("Products")).click();
	
	/*Click on check boxes*/
	List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@name='selected_id']"));
	
	int count = 0;
	for(WebElement chkbx:checkBoxes)
	{
		//chkbx.click();
		count++;
		//int c=count;
		if(count%2==1)
		{
			chkbx.click();
		}
	}

	//driver.quit();
	}
	
	

}
