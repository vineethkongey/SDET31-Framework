package com.practiceMaven;

import java.time.Duration;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClassPracticeTest {
	
	public static void main(String[] args) throws Exception {
		
	WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.monsterindia.com/");
		
		WebElement wb = driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']"));
		
		String color = wb.getCssValue("color");
		
		
		
		Robot r = new Robot();
		
		r.mouseWheel(1000);
		
		r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);//right click 1 2
		
		r.delay(1000);
		r.mouseMove(100,150);
		
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		
		
		
		
	}

}
