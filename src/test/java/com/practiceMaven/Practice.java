package com.practiceMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
public static void main(String[] args) throws SQLException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/");


	JavascriptExecutor jse = (JavascriptExecutor)driver;
	WebElement username = driver.findElement(By.name("user_name"));
	WebElement password = driver.findElement(By.name("user_password"));
	jse.executeScript("arguments[0].value='admin'",username);
	jse.executeScript("arguments[0].value='root'",password);
	
	WebElement button = driver.findElement(By.id("submitButton"));
	
	jse.executeScript("arguments[0].click()",button);
	
	
	
	
//	wb.sendKeys("ipad");
//	wb.submit();
}
}
