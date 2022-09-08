package com.practiceMaven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookTodayFlight {
	public static void main(String[] args) {
		
		/*Launching the browser*/
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.makemytrip.com/");
	    
	    /*Click anywhere in the page*/
	    Actions act = new Actions(driver);
	    act.moveByOffset(10, 10).click().perform();
	    
	    /*Close the pop up*/
	    driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	    
	    /*Click on the  date*/
	    driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
	    
	    /*Getting the local system date*/
//	    LocalDateTime dateAndTime = LocalDateTime.now();
//	    Month month = dateAndTime.getMonth();
//	    int year = dateAndTime.getYear();
//	    String monthName =  month.toString();
//	    monthName =   monthName.substring(0,1) + monthName.substring(1).toLowerCase();
//	   
//	   String monthAndYear = monthName+" "+year;
//	   int day = dateAndTime.getDayOfMonth();
//	   
//	  
//	   driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
		   
		   
		   
	
//	   /*Select from flight*/
//	   driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
//	   
//	   driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
//	   
//	   /*select to flight*/
//	   driver.findElement(By.xpath("//div[@class='fsw_inputBox searchToCity inactiveWidget ']")).click();
//	   driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
//	   
//	   /*clicking the search flight*/
//	   driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
//	   
//	   List<WebElement> flightName = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
//	   
//	   for(WebElement flight :flightName )
//	   {
//		   System.out.println(flight.getText());
//	   }
	    
		//driver.quit();
	
	
	
	}

}
