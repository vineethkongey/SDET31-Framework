package com.crm.autodesk.organisationPOMTest;

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
import com.crm.autodesk.pageObjectModelLib.CreateOrganizationspage;
import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;
import com.crm.autodesk.pageObjectModelLib.OrganizationInformationPage;
import com.crm.autodesk.pageObjectModelLib.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Test Script will create an Organization with all mandatory fields and
 * select a Industry Type from the drop down menu.
 * 
 * @author Soumyajit
 *
 */
@Listeners(com.crm.autodesk.commonutility.ListenerImplementationClass.class)
public class CreateOrgWithIndustryTest extends BaseClass {
	
	@Test(groups="endToEndTest")
	public void createOrgWithIndustry() throws Throwable {
		/*
		 * WebDriver driver =null;
		 * 
		 * object creation for utility classes ExcelDataUtility eLib = new
		 * ExcelDataUtility(); PropertiesFileUtility pLib = new PropertiesFileUtility();
		 * WebDriverUtility wLib = new WebDriverUtility(); JavaUtility jLib = new
		 * JavaUtility();
		 * 
		 * //Properties file data fetching String browser =
		 * pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "browser");
		 * String url = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "url");
		 * String username = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "username");
		 * String password = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "password");
		 * 
		 * 
		 * Launching the browser if(browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if(browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.chromedriver().setup(); driver = new FirefoxDriver(); } else
		 * if(browser.equalsIgnoreCase("edge")) {
		 * WebDriverManager.chromedriver().setup(); driver = new EdgeDriver();
		 * 
		 * }
		 * 
		 * wLib.implicitWait(driver,10); driver.manage().window().maximize();
		 * driver.get(url);
		 */
		int randomNum = jLib.getRandomNum();
		/*
		 * Login to the application LoginPage loginPage = new LoginPage(driver);
		 * loginPage.login(username, password);
		 */

		/* click on the Organization Link */
		HomePage homepage = new HomePage(driver);
		homepage.clickOnOrganizations();

		/* Click on create organization */
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.clickOnCreateOrgIcon();

		/* Fill the mandatory fields with industry type as HealthCare */
		CreateOrganizationspage createOrgPage = new CreateOrganizationspage(driver);
		createOrgPage.enterOrgName(IPathConstants.TESTDATA_EXCELFILE_PATH, "Organisation", 1, 0, randomNum);
		createOrgPage.selectFromDropDown();
		createOrgPage.clickOnSave();

		/* Validating the organization created successfully or not */
		String orgName = eLib.getExcelData(IPathConstants.TESTDATA_EXCELFILE_PATH, "Organisation", 1, 0) + randomNum;
		System.out.println(orgName);
		String industryType = eLib.getExcelData(IPathConstants.TESTDATA_EXCELFILE_PATH, "Industry", 17, 0);
		System.out.println(industryType);

		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		
		Assert.assertEquals(orgName, orgInfo.fetchOrgName());

		/*
		 * if (orgInfo.fetchOrgName().equals(orgName) &&
		 * orgInfo.fetchIndustryType().equals(industryType)) {
		 * System.out.println("Organization created Successfully"); } else {
		 * System.out.println("Failed to create organization"); }
		 */

		/*
		 * Log Out from the application homepage.signOut(driver); driver.quit();
		 */

	}

}
