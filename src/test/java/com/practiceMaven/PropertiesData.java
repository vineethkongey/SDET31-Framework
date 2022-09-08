package com.practiceMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesData {
public static void main(String[] args) throws Throwable {
	WebDriver driver = null;
	
	//properties file data fetching
	FileInputStream fis = new FileInputStream("./src/main/resources/commonData/commonCredentials.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	
	String browser = pobj.getProperty("browser");
	System.out.println(browser);
	String url = pobj.getProperty("url");
	String username = pobj.getProperty("username");
	String password = pobj.getProperty("password");
	
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver =  new EdgeDriver();
	}
	else
	{
		System.out.println("Specify a valid browser");
	}
	
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
}
}
