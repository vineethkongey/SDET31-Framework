package com.practiceMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumHeaderPrint {
	@Test
	public void printHeader()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/");
		
		List<WebElement> headers = driver.findElements(By.xpath("//li[contains(@class,'nav-item')]"));
		for(WebElement wb:headers)
		{
			System.out.println(wb.getText());
		}
	}

}
