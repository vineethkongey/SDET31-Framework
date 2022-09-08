package com.practiceMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AthleteMedalList {
	
	@Test
	public void olympicMedal() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://olympics.com/en/athletes");
		
		
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		
		driver.findElement(By.xpath("//h1[@class='article--title']/span[text()='Ailing Eileen']")).click();
		String goldMedalNo = null;
		String silverMedalNo = null ;
		String bronzeMedalNo = null;
		
		List<WebElement> medalList= driver.findElements(By.xpath("//h1[text()='GU Ailing Eileen']/ancestor::div[@class='b2p-grid__inner athlete-wrap -no-gap']/descendant::span[contains(@class,'medal')]"));
		
		for(WebElement wb: medalList)
		{
			System.out.print(wb.getText() + " ");
		}
		
//		try
//		{
//		 goldMedalNo = driver.findElement(By.xpath("//span[@class='medal-count -gold']")).getText();
//		}
//		catch(Exception e)
//		{
//		System.out.println("Gold Medal No = " + goldMedalNo);
//		}
//		finally
//		{
//			System.out.println("Gold Medal No = " + goldMedalNo);	
//		}
//		
//		try
//		{
//		silverMedalNo = driver.findElement(By.xpath("//span[@class='medal-count -silver']")).getText();
//		}
//		catch(Exception e)
//		{
//		System.out.println("Silver medal No = " + silverMedalNo);
//		}
//		finally
//		{
//			System.out.println("Silver Medal No = " + silverMedalNo);	
//		}
//		
//		try
//		{
//		bronzeMedalNo = driver.findElement(By.xpath("//span[@class='medal-count -bronze']")).getText();
//		}
//		catch(Exception e)
//		{
//		    System.out.println("Bronze Medal No = " + bronzeMedalNo);
//		}
//		finally
//		{
//			System.out.println("Bronze Medal No = " + bronzeMedalNo);	
//		}
	}

}
