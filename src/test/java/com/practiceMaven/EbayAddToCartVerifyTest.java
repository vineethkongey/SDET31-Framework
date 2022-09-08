package com.practiceMaven;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayAddToCartVerifyTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ebay.com");
		
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("shoes",Keys.ENTER);
		
		List<WebElement> prod = driver.findElements(By.xpath("//li[contains(@class,'s-item s-item__pl-on-bottom')]"));
		
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(2000);
		
		prod.get(prod.size()-1).click();
		
		 Set<String>  allIds=driver.getWindowHandles();
		 
		 String windowID=driver.getWindowHandle();
		 
		 for (String st : allIds) {
			 if(!st.equals(windowID))
			 {
				 driver.switchTo().window(st);
			 }
			
		}
		 
	
		 
	
		 
		 driver.findElement(By.xpath("//a[contains(text(),\"Add to cart\")]")).click();
	
		
		
		
		
	}
	

}
