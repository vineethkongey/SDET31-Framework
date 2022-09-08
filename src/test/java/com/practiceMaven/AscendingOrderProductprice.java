package com.practiceMaven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AscendingOrderProductprice {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("ihphone", Keys.ENTER);
		
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		
		//ArrayList lst = new ArrayList<>();
		 HashSet hst = new HashSet<>();
		for(WebElement price:priceList)
		{
			String phonePrice = price.getText();
			hst.add(phonePrice);
		}
		
		System.out.println(hst);
		 
		 Iterator itr = hst.iterator();
		 ArrayList lst1 = new ArrayList<>();
		// HashSet hst1 = new HashSet<>();
		 while(itr.hasNext())
		 {
			String j =  itr.next().toString().substring(1).replace(",", "");
			// System.out.println(j);
			 int i  = Integer.parseInt(j);
			 //System.out.println(i);
			
			 lst1.add(i);
			 
			 
		 }
		 System.out.println(lst1);
		 
		 Collections.sort(lst1);
		 System.out.println(lst1);
		 
		 Collections.reverse(lst1);
		 System.out.println(lst1);
		 System.out.println(lst1.size());
		 
		  TreeSet trs = new TreeSet<>(lst1);
		  System.out.println(trs);
		  System.out.println(trs.size());
		 
		 
		
	    driver.close();
	   
	
	}

}
