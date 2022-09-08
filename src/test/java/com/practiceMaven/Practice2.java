package com.practiceMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {
	
	@Test
	public void practice()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://spicejet.com");
		
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys("Bom");
		
		driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys("goa");
		
		
	}
	
	
}
