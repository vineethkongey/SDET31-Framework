package com.practiceMaven;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterviewTest {
	
	
	public static void main(String[] args) {
		//i/p: 22:C 55:B 33:A 77:D
		
		String s[] = {"22:C","33:A","44:D","66:E"};
		
		TreeMap<Character,String> tr = new TreeMap<Character,String>();
		
		for (int i = 0; i < s.length; i++) {
			
			tr.put(s[i].charAt(s[i].length()-1), s[i].substring(0,s[i].length()-1));
			
		}
		
		for (Map.Entry<Character, String> e: tr.entrySet()) {
			
			System.out.print(e.getValue()+"" + e.getKey() + " ");
			
		}
		
		
		
	}

}
