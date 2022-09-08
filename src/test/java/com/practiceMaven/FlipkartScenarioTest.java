package com.practiceMaven;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartScenarioTest {
	
	@Test
	public void flipkartLastProSelection() throws Throwable
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		driver.findElement(By.name("q")).sendKeys("gshock", Keys.ENTER);
		
		driver.findElement(By.name("q"));
		List<WebElement> watchList=driver.findElements(By.xpath("//div[@class='_312yBx SFzpgZ']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",watchList.get(watchList.size()-1));
		
		Thread.sleep(3000);
		
		watchList.get(watchList.size()-1).click();
		
		Set<String> allId=driver.getWindowHandles();
		
		String currentWindowId=driver.getWindowHandle();
		String currentTitle=driver.getTitle();
		
		Iterator<String> itr=allId.iterator();
		
		while(itr.hasNext())
		{
			
			driver.switchTo().window(itr.next());
			
			if(!(driver.getTitle().equals(currentTitle)))
			{
				break;
			}
			
		}
		
		String watchPrice=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		
		System.out.println(watchPrice);
		
		
		
//		List<WebElement> prices=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
//		List<WebElement> mobNames=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
//		
//		HashMap<String, Integer> hs= new HashMap<String,Integer>();
//		
//		for (int i=0;i<prices.size();i++) {
//			
//			String s=prices.get(i).getText().substring(1).replace(",", "");
//			int price=Integer.parseInt(s);
//			
//			if(price>50000&&price<80000)
//			{
//				hs.put(mobNames.get(i).getText(), price);
//			}
//			
//		
//			
//		}
//		
//		
//		System.out.println(hs);
		
		//driver.quit();
		
		
		
		
		
	}

}
