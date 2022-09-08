package com.crm.autodesk.productTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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

public class createProductWithMandatory {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		
		/* object creation for utility classes*/
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		
		//Fetch common data from properties file
		String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
		String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
		String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
		String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");

		/* Random number generation */
		int randomNum = jLib.getRandomNum();
		
		/*
		 * FileInputStream fis = new FileInputStream(
		 * "./src/main/resources/commonData/commonCredentials.properties"); Properties
		 * pobj = new Properties(); pobj.load(fis);
		 * 
		 * String browser = pobj.getProperty("browser"); String url =
		 * pobj.getProperty("url"); String username = pobj.getProperty("username");
		 * String password = pobj.getProperty("password");
		 */
		
		//excel data fetching
		String productName = eLib.getExcelData("./src/test/resources/ProductNames.xlsx", "Products", 1, 0);
		productName = productName + randomNum;
		
		
		/*
		 * FileInputStream f = new
		 * FileInputStream("./src/test/resources/ProductNames.xlsx"); Workbook book =
		 * WorkbookFactory.create(f); String productname =
		 * book.getSheet("Products").getRow(1).getCell(0).getStringCellValue();
		 */
		
		
		
		//Launching the browser
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		wLib.implicitWait(driver,10);
		driver.manage().window().maximize();
		
		//login to the application
		
		driver.findElement(By.name("user_name")).sendKeys(username, Keys.TAB , password , Keys.ENTER );
		
		//Click on Products
		
		driver.findElement(By.linkText("Products")).click();
		
		//click on create product
		driver.findElement(By.xpath("//img[@title = 'Create Product...']")).click();
		
		//Enter ProductName
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		//click on Save
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		
		//validation
		String product = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		if(product.equals(productName))
		{
			System.out.println( productName + " product created successfully");
		}
		else
		{
			System.out.println("Failed to create Product");
		}
		
		//click on sign out
		WebElement ele = driver.findElement(By.xpath("//span[text() = ' Administrator']/../following-sibling::td/img"));
		
		wLib.mouseOverToElement(driver,ele);
		
		/*
		 * Actions act = new Actions(driver); act.moveToElement(ele).perform();
		 * driver.findElement(By.linkText("Sign Out")).click();
		 */
		
		//close the application
		driver.close();
		
		
		
		
	}

}
