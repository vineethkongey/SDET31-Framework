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
import com.crm.autodesk.pageObjectModelLib.CreateOrganizationspage;
import com.crm.autodesk.pageObjectModelLib.CreatingNewContactPage;
import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;
import com.crm.autodesk.pageObjectModelLib.OrganizationInformationPage;
import com.crm.autodesk.pageObjectModelLib.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Test Script will create a new contact with all the mandatory fields and
 * choose any organization from the Organization field.
 * 
 * @author Soumyajit
 *
 */
@Listeners(com.crm.autodesk.commonutility.ListenerImplementationClass.class)
public class CreateContactWithOrganization extends BaseClass {
	
	@Test(groups="endToEndTest")
	public void createContactWithOrganization() throws Throwable {
		/*
		 * WebDriver driver = null;
		 * 
		 * object creation for utility classes ExcelDataUtility eLib = new
		 * ExcelDataUtility(); PropertiesFileUtility pLib = new PropertiesFileUtility();
		 * WebDriverUtility wLib = new WebDriverUtility(); JavaUtility jLib = new
		 * JavaUtility();
		 * 
		 * // Properties file data fetching String browser =
		 * pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "browser");
		 * String url = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "url");
		 * String username = pLib .getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "username");
		 * String password = pLib .getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "password");
		 * 
		 * Launching the browser if (browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.chromedriver().setup(); driver = new FirefoxDriver(); } else
		 * if (browser.equalsIgnoreCase("edge")) {
		 * WebDriverManager.chromedriver().setup(); driver = new EdgeDriver();
		 * 
		 * }
		 * 
		 * wLib.implicitWait(driver, 10); driver.manage().window().maximize();
		 * driver.get(url);
		 * 
		 *  Login to the application LoginPage
		 * loginPage = new LoginPage(driver); loginPage.login(username, password);
		 */
		
		int randomNum = jLib.getRandomNum();
		 

		/* click on the Organization Link */
		HomePage homepage = new HomePage(driver);
		homepage.clickOnOrganizations();

		/* Click on create organization */
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.clickOnCreateOrgIcon();

		/* Fill the mandatory fields with industry type as HealthCare */
		CreateOrganizationspage createOrgPage = new CreateOrganizationspage(driver);
		createOrgPage.enterOrgName(IPathConstants.TESTDATA_EXCELFILE_PATH, "Organisation", 1, 0, randomNum);

		/* Save the new Organization */
		createOrgPage.clickOnSave();

		/* Validating the organization created successfully or not */
		String orgName = eLib.getExcelData(IPathConstants.TESTDATA_EXCELFILE_PATH, "Organisation", 1, 0) + randomNum;
		// System.out.println(orgName);

		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		
		Assert.assertEquals(orgName, orgInfo.fetchOrgName());

		/*
		 * if (orgInfo.fetchOrgName().equals(orgName)) {
		 * System.out.println("Organization created Successfully"); } else {
		 * System.out.println("Failed to create Organization"); }
		 */

		/* Click on Contact Link */
		
		homepage.clickOnContacts();

		/* Clicking creating new contact icon */
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.clickOnCreateContact();

		/* fill the mandatory filed */
		String lastName = eLib.getExcelData(IPathConstants.CONTACT_EXCELFILE_PATH, "Contacts", 2, 1);
		CreatingNewContactPage creatingNewContPage = new CreatingNewContactPage(driver);
		creatingNewContPage.enterLastName(IPathConstants.CONTACT_EXCELFILE_PATH, "Contacts", 2, 1);

		/* Choose the desired the organization */
		creatingNewContPage.chooseOrg(driver, orgName);

		/* Click on Save Button */
		creatingNewContPage.clickOnSave();

		/* Validating the Contact Name and Organization Name */

		ContactsInformationPage conInfo = new ContactsInformationPage(driver);
		
		Assert.assertEquals(lastName,conInfo.getLastName());

		/*
		 * if (lastName.equals(conInfo.getLastName())) {
		 * System.out.println(conInfo.getOrgName());
		 * System.out.println("Conatact created Successfully"); } else {
		 * System.out.println(conInfo.getOrgName());
		 * System.out.println("Failed to create contact"); }
		 */

		/*
		 * Click on Sign Out Link homepage.signOut(driver);
		 */

	}

}
