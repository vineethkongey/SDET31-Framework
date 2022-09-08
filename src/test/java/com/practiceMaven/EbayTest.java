package com.practiceMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayTest {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ebay.com/");
		
//		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("shoes",Keys.ENTER);
//		
//		List<WebElement> shoes =driver.findElements(By.xpath("//li[contains(@class,'s-item s-item__pl-on-bottom')]"));
//		
//		shoes.get(2).click();

		Thread.sleep(2000);
		
//		Actions act  = new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']/child::a[text()='Electronics']"))).perform();
	List<WebElement> more =	driver.findElements(By.xpath("//a[text()='Electronics']/parent::li[@class='hl-cat-nav__js-tab']/descendant::nav[@aria-label='More categories']/descendant::a[@class='hl-cat-nav__js-link']"));
		
	for (WebElement wb : more) {
		
		//System.out.println(wb.getAttribute("href"));
		//System.out.println(wb.getAttribute("textContent"));
		System.out.println(wb.getAttribute("innerText"));
		
		//System.out.println(wb.getText());
		
	}
	
		
		
		//driver.quit();

		
		
	}

}
