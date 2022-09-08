package com.crm.autodesk.contactsPOMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.commonutility.BaseClass;
import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.IPathConstants;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;
import com.crm.autodesk.pageObjectModelLib.ContactsInformationPage;
import com.crm.autodesk.pageObjectModelLib.ContactsPage;
import com.crm.autodesk.pageObjectModelLib.CreatingNewContactPage;
import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Test Script will create a new Contact with all the mandatory fields.
 * 
 * @author Soumyajit
 *
 */
@Listeners(com.crm.autodesk.commonutility.ListenerImplementationClass.class)
public class CreateContactWithMandatoryFieldsTest extends BaseClass {

	
	@Test(groups="functionalTest")
	public void createContactWithMandatoryFields() throws Throwable {
		/*
		 * WebDriver driver = null;
		 * 
		 * object creation for utility classes ExcelDataUtility eLib = new
		 * ExcelDataUtility(); PropertiesFileUtility pLib = new PropertiesFileUtility();
		 * WebDriverUtility wLib = new WebDriverUtility(); JavaUtility jLib = new
		 * JavaUtility();
		 * 
		 * Properties file data fetching String browser =
		 * pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "browser");
		 * String url = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "url");
		 * String username = pLib .getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "username");
		 * String password = pLib .getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "password");
		 * 
		 * launching the browser
		 * 
		 * if (browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else if (browser.equalsIgnoreCase("edge")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); }
		 * 
		 * wLib.implicitWait(driver, 10); driver.get(url);
		 * driver.manage().window().maximize();
		 * 
		 * Login to application LoginPage loginPage = new LoginPage(driver);
		 * loginPage.login(username, password);
		 */

		/* Click on Contact Link */
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContacts();

		/* Clicking creating new contact icon */
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.clickOnCreateContact();

		/* fill the mandatory filed */
		String lastName = eLib.getExcelData(IPathConstants.CONTACT_EXCELFILE_PATH, "Contacts", 2, 1);
		CreatingNewContactPage creatingNewContPage = new CreatingNewContactPage(driver);
		creatingNewContPage.enterLastName("./src/test/resources/ContactDetails.xlsx", "Contacts", 2, 1);

		/* Click on Save */

		creatingNewContPage.clickOnSave();

		/* Validation of Contact */
		ContactsInformationPage infoPage = new ContactsInformationPage(driver);
		
		Assert.assertEquals(lastName, infoPage.getLastName());
		
		/*
		 * if (lastName.equals(infoPage.getLastName())) {
		 * System.out.println("Contact created successfully"); } else {
		 * System.out.println("Failed to create contact"); }
		 */
		/*
		 * Click on Sign Out Link HomePage homepage =new HomePage(driver);
		 * homepage.signOut(driver);
		 * 
		 * Close the browser driver.quit();
		 */

	}

}
