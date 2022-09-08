package com.practiceMaven;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver(option);
	
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	}
}
