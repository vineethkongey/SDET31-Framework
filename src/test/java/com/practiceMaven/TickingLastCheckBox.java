package com.practiceMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TickingLastCheckBox {
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
	
	/*clicking the last check box*/
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[1]")).click();
	//driver.findElement(By.xpath("//input[@type='checkbox' and @id='34']")).click();
	
	//WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	}

}
