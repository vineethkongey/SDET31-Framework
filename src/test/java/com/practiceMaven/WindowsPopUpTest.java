package com.practiceMaven;

import java.time.Duration;
import java.awt.*;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.input.Input.DispatchKeyEventType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsPopUpTest {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.monsterindia.com/");
		
		driver.findElement(By.xpath("//span[text()='Upload Resume']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='uploadResume pr tc']")).click();
		
		Robot r = new Robot(); 
		
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
		r.keyPress(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_E);
		
		//Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
