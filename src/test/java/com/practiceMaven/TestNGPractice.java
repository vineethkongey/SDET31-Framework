package com.practiceMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGPractice {
	
	@Test(invocationCount=2,threadPoolSize=3)
	public void m1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://Flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("m1 running");
	}
	
	/*
	 * @Test public void m2() { WebDriverManager.chromedriver().setup(); WebDriver
	 * driver = new ChromeDriver(); driver.get("https://Flipkart.com/");
	 * driver.manage().window().maximize(); System.out.println("m2 running"); }
	 * 
	 * @Test public void m3() { WebDriverManager.chromedriver().setup(); WebDriver
	 * driver = new ChromeDriver(); driver.get("https://Flipkart.com/");
	 * driver.manage().window().maximize(); System.out.println("m3 running"); }
	 */

}
