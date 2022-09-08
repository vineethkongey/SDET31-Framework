package com.crm.autodesk.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.Assert;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithMandatoryFields {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;

		/* object creation for utility classes */
		ExcelDataUtility eLib = new ExcelDataUtility();
		PropertiesFileUtility pLib = new PropertiesFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		// Properties file
		String browser = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties",
				"browser");
		String url = pLib.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties",
				"url");
		String username = pLib
				.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "username");
		String password = pLib
				.getValuesForPropertiesFile("./src/main/resources/commonData/commonCredentials.properties", "password");

		/*
		 * FileInputStream fis = new FileInputStream(
		 * "./src/main/resources/commonData/commonCredentials.properties"); Properties
		 * pobj = new Properties(); pobj.load(fis); String browser =
		 * pobj.getProperty("browser"); String url = pobj.getProperty("url"); String
		 * username = pobj.getProperty("username"); String password =
		 * pobj.getProperty("password");
		 */

		// Read from excel data for contact

		String lastName = eLib.getExcelData("./src/test/resources/ContactDetails.xlsx", "Contacts", 1, 1);
		lastName = lastName + jLib.getRandomNum();
		/*
		 * FileInputStream f = new
		 * FileInputStream("./src/test/resources/ContactDetails.xlsx"); Workbook b =
		 * WorkbookFactory.create(f); String s =b.getSheetName(0);
		 * System.out.println(s); Sheet sh = b.getSheet("Contacts"); int r =
		 * sh.getLastRowNum(); System.out.println(r); String lastName =
		 * sh.getRow(1).getCell(1).getStringCellValue();
		 */

		// launch browser

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		wLib.implicitWait(driver,10);
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 */
		driver.get(url);
		driver.manage().window().maximize();

		// login to application

		driver.findElement(By.name("user_name")).sendKeys(username, Keys.TAB, password, Keys.ENTER);

		// click on contact

		driver.findElement(By.linkText("Contacts")).click();

		// click on create contact

		driver.findElement(By.xpath("//img[@title = 'Create Contact...']")).click();

		// fill mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		// click on save

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// validation
		String inf = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();

		if (inf.equals(lastName)) {
			System.out.println(lastName + " contact created successfully");
		} else {
			System.out.println("Failed to create contact");
		}

		// logout from application

		WebElement wb = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td/img"));
		wLib.mouseOverToElement(driver, wb);

		/*
		 * Actions act = new Actions(driver); act.moveToElement(wb).perform();
		 */

		driver.findElement(By.linkText("Sign Out")).click();

	}

}
