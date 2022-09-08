package com.crm.autodesk.organisationTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;
import com.practiceMaven.ExcelData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrgWithHealthcare {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		
		/* object creation for utility classes*/
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		//Properties file data fetching
		String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "browser");
		String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "url");
		String username = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
		String password = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");

		/*
		 * FileInputStream fis = new FileInputStream(
		 * "./src/main/resources/commonData/commonCredentials.properties"); Properties
		 * pobj = new Properties(); pobj.load(fis);
		 * 
		 * String browser = pobj.getProperty("browser"); String url =
		 * pobj.getProperty("url"); String username = pobj.getProperty("username");
		 * String password = pobj.getProperty("password");
		 */

		
		/* Random number generation*/
		int randomNum = jLib.getRandomNum();
		//get data from excel sheet

		String orgName = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Organisation", 1, 0);
		orgName = orgName + randomNum;
		
		/*
		 * FileInputStream fil = new
		 * FileInputStream("./src/test/resources/Test Data.xlsx"); Workbook book =
		 * WorkbookFactory.create(fil); Sheet sh = book.getSheet("Organisation"); String
		 * orgName = sh.getRow(1).getCell(0).getStringCellValue();
		 * System.out.println(orgName);
		 * 
		 * Random r = new Random(); int random = r.nextInt();
		 */
		
		String industry = eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Industry", 17, 0);
		
		/*
		 * Sheet sh1 = book.getSheet("Industry"); String s3 = book.getSheetName(1);
		 * System.out.println(s3); String industry =
		 * sh1.getRow(17).getCell(0).getStringCellValue(); System.out.println(industry);
		 */

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();

		}
		
		wLib.implicitWait(driver,10);
		
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 */		
		driver.get(url);
		driver.manage().window().maximize();

		//login
		driver.findElement(By.name("user_name")).sendKeys(username, Keys.TAB, password, Keys.ENTER);

		//click on organization
		driver.findElement(By.linkText("Organizations")).click();

		//click on create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//enter the org name
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);

		//select HealthCare sector from industry type


		//		WebElement wb = driver.findElement(By.xpath("//select[@name='industry']"));
		//		Select s = new Select(wb);
		//		s.selectByValue(industry);

		//Thread.sleep(10);
		 //List <WebElement> industryDropDown = driver.findElements(By.xpath("//select[@name='industry']/option"));
		 
		WebElement element =  driver.findElement(By.xpath("//select[@name='industry']"));
		 
//		  Select s = new Select(industryDropDown);
//		  List<WebElement> industries = s.getOptions();
//		 
//		
//		for (WebElement element : industries) {
//			if (element.getText().equals("Healthcare")) {
//				element.click();
//				break;
//			}
//		}
		 
		 wLib.selectFromDropDown(element, industry);

			/*
			 * for(WebElement ele: industryDropDown) { if(ele.getText().equals(industry)) {
			 * ele.click(); break; } }
			 */
		 
		 

		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verification process
		String org =driver.findElement(By.xpath("//span[@id = 'dtlview_Organization Name']")).getText();
		if(orgName.equals(org))
		{
			System.out.println(orgName + " is created successfully");
		}
		else
		{
			System.out.println("failed to create organization");
		}

		//logout
		WebElement element1 = driver.findElement(By.xpath("//td[text()='Organization Information']"));
		wLib.explicitWait(driver, element1,10);
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//td[text()='Organization Information']")));
		 */
		
		/* move over action*/
		WebElement wb1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseOverToElement(driver, wb1);
		

		/*
		 * Actions act = new Actions(driver); act.moveToElement(wb1).perform();
		 */
		
		driver.findElement(By.linkText("Sign Out")).click();

		//close the application
		//driver.close();




	}


}
