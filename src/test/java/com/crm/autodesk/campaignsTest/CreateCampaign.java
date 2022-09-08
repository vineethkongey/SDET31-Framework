package com.crm.autodesk.campaignsTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Soumyajit
 *
 */
public class CreateCampaign {
	public static void main(String[] args) throws Throwable {
        WebDriver driver = null;
        
    	/* object creation for utility classes*/
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		//properties file common data
		
		String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
		String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
		String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
		String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");
		
		/*
		 * //properties file common data FileInputStream fis = new FileInputStream(
		 * "./src/main/resources/commonData/commonCredentials.properties"); Properties
		 * pobj = new Properties(); pobj.load(fis);
		 * 
		 * String browser = pobj.getProperty("browser"); String url =
		 * pobj.getProperty("url"); String username = pobj.getProperty("username");
		 * String password = pobj.getProperty("password");
		 */
		
		//generate random number
		int randomNum = jLib.getRandomNum();
		
		
		//fetch data from excel sheet for campaign
		String campaignName = eLib.getExcelData("./src/test/resources/Campaigns.xlsx", "Campaigns", 1, 0);
		campaignName = campaignName + randomNum;
		
		/*
		 * FileInputStream f = new
		 * FileInputStream("./src/test/resources/Campaigns.xlsx"); Workbook b =
		 * WorkbookFactory.create(f); Sheet sh = b.getSheet("Campaigns");
		 * 
		 * Random r = new Random(2000); int random = r.nextInt(); String campaignName =
		 * sh.getRow(1).getCell(0).getStringCellValue();
		 */
		
		
		//fetch data from excel for product
		String productName = eLib.getExcelData("./src/test/resources/Campaigns.xlsx", "Campaigns", 1, 1);
		productName = productName + randomNum;
		
		/* String productName = sh.getRow(1).getCell(1).getStringCellValue(); */
		
		
		//launch the browser
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		wLib.implicitWait(driver,10);
		
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */
		
		driver.manage().window().maximize();
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(username, Keys.TAB, password, Keys.ENTER );
		
		//Click on Products
		
		driver.findElement(By.linkText("Products")).click();
				
		//click on create product
		driver.findElement(By.xpath("//img[@title = 'Create Product...']")).click();
				
		//Enter ProductName
		driver.findElement(By.name("productname")).sendKeys(productName);
				
		//click on Save
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		
		//validation
		String product = driver.findElement(By.xpath("//span[@id = 'dtlview_Product Name']")).getText();
		if(product.equals(productName))
		{
			System.out.println(productName + " is created successfully");
		}
		else
		{
			System.out.println("Failed to create product");
		}
	
		
		//click on campaigns
		WebElement ele = driver.findElement(By.linkText("More"));
		wLib.mouseOverToElement(driver, ele);
		
		/*
		 * Actions act = new Actions(driver); act.moveToElement(ele).perform();
		 */
		
		driver.findElement(By.linkText("Campaigns")).click();
		
		//click on create campaign
		driver.findElement(By.xpath("//img[@title = 'Create Campaign...']")).click();
		
		//Enter the campaign name
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		//choose the product
		driver.findElement(By.xpath("//input[@name='product_name']/following-sibling::img")).click();
		
		/* Switch to product window*/
		wLib.switchToWindow(driver, "Products");
		
		/*
		 * Set<String> allWindow = driver.getWindowHandles(); Iterator<String> itr =
		 * allWindow.iterator();
		 * 
		 * while(itr.hasNext()) { String childID = itr.next();
		 * driver.switchTo().window(childID); if(driver.getTitle().contains("Products"))
		 * { break; } }
		 */
		
		driver.findElement(By.name("search_text")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text() = '"+productName+"']")).click();
		
		
		/* Switch to main window */
		wLib.switchToWindow(driver, "Campaigns");
		
		
		/*
		 * Set<String> allWindow1 = driver.getWindowHandles(); Iterator<String> itr1 =
		 * allWindow1 .iterator();
		 * 
		 * while(itr1.hasNext()) { String parentWindowID = itr1.next();
		 * driver.switchTo().window(parentWindowID);
		 * if(driver.getTitle().contains("Campaigns")) { break; } }
		 */
		
		
		//click on save
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		
		//validation
		String campaign = driver.findElement(By.xpath("//span[@id = 'dtlview_Campaign Name']")).getText();
		 String productInfo = driver.findElement(By.xpath("//span[@id='dtlview_Product']/a")).getText();
		if(campaign.equals(campaignName) && product.equals(productInfo))
		{
			System.out.println(campaignName + " with " + productName + " is created successfully");
		}
		else
		{
			System.out.println("Failed to create product");
		}
	
				
				
		//click on sign out
	    WebElement el = driver.findElement(By.xpath("//span[text() = ' Administrator']/../following-sibling::td/img"));
	    wLib.mouseOverToElement(driver, el);
	    
		/*
		 * Actions a = new Actions(driver); a.moveToElement(el).perform();
		 */
	    
		driver.findElement(By.linkText("Sign Out")).click();
				
		//close the browser
		driver.close();
		
		
	}

}
