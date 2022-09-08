package com.practiceMaven;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTest {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://makemysushi.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		List<String> activeLinks = new ArrayList<String>();
		
		for (int i = 0; i < links.size(); i++) {
			
			if (links.get(i).getAttribute("href")!= null) {
				
				activeLinks.add(links.get(i).getAttribute("href"));
				
				
			}
			
		
		}
		System.out.println(activeLinks.size());
		for (int j = 0; j < activeLinks.size(); j++) {
			
			System.out.println(activeLinks.get(j));
			verifyLinks(activeLinks.get(j));
			
		}
		
		driver.quit();
		
	
	}
	
	public static void verifyLinks(String linkurl) throws Throwable
	{
		int code=0;
		try
		{
		URL url = new URL(linkurl);
		HttpURLConnection httpConnect = (HttpURLConnection)url.openConnection();
		
		httpConnect.connect();
		
		code = httpConnect.getResponseCode();
		if (code>=200 && code<300) {
			System.out.println( linkurl + "--->"+ "is ok");
		}
		
		}
		catch (Exception e) {
			System.out.println(linkurl + "---->" + "is broken");
		}
		
	}

}
