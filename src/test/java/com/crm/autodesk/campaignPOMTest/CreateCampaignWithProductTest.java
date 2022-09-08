package com.crm.autodesk.campaignPOMTest;

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
import com.crm.autodesk.pageObjectModelLib.CampaignInformationPage;
import com.crm.autodesk.pageObjectModelLib.CampaignPage;
import com.crm.autodesk.pageObjectModelLib.CreateNewCampaignPage;
import com.crm.autodesk.pageObjectModelLib.CreateNewProductPage;
import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;
import com.crm.autodesk.pageObjectModelLib.ProductInfoPage;
import com.crm.autodesk.pageObjectModelLib.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains script which will create a campaign with product name included in the campaign.
 * @author Soumyajit
 *
 */
@Listeners(com.crm.autodesk.commonutility.ListenerImplementationClass.class)
public class CreateCampaignWithProductTest extends BaseClass {
	
	@Test(groups="endToEndTest")
	public void createCampaignWithProduct() throws Throwable {
		/*
		 * WebDriver driver =null;
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
		 * 
		 * Login to the Application LoginPage loginPage = new LoginPage(driver);
		 * loginPage.login(username, password);
		 */

		/* Click on the Product Link */
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProducts();

		/* Click on create New Product Icon */
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnCreateproductIcon();

		/* Enter the mandatory details */
		int randomNum = jLib.getRandomNum();
		CreateNewProductPage createProductPage = new CreateNewProductPage(driver);
		String productName = eLib.getExcelData(IPathConstants.PRODUCT_EXCELFILE_PATH, "Products", 1, 0);
		productName = productName + randomNum;
		createProductPage.enterProductName(productName);

		/* Click on save button */
		createProductPage.clickOnSaveButton();

		/* Validation */
		ProductInfoPage productInfo = new ProductInfoPage(driver);
		
		Assert.assertEquals(productName, productInfo.getProductName());
		
		/*
		 * if (productName.equals(productInfo.getProductName())) {
		 * System.out.println("Product created successfully"); } else {
		 * System.out.println("Failed to create product"); }
		 */

		/* click on the Organization Link */
		HomePage homepage = new HomePage(driver);
		homepage.mouseOverOnMoreLink(driver);

		/* Click on Campaign Link */
		homepage.clickOnCampaign();

		/* Click the create campaign icon */
		CampaignPage campPage = new CampaignPage(driver);
		campPage.clickOnCreateCampaignIcon();

		/* Enter the campaign name */
		String campaignName = eLib.getExcelData(IPathConstants.CAMPAIGN_EXCELFILE_PATH, "Campaigns", 1, 0);
		campaignName = campaignName + randomNum;

		CreateNewCampaignPage createCampaign = new CreateNewCampaignPage(driver);
		createCampaign.enterCampaignName(campaignName);

		/* Choose the product */
		createCampaign.addProduct(driver, productName);

		/* Save the campaign */
		createCampaign.clickOnSave();

		/* Validation of campaign name */
		CampaignInformationPage campaignInfoPage = new CampaignInformationPage(driver);
		
		Assert.fail();
		
		Assert.assertEquals(campaignName, campaignInfoPage.getCampaignName());
		
		/*
		 * if (campaignName.equals(campaignInfoPage.getCampaignName())) {
		 * System.out.println("Campaign created successfully"); } else {
		 * System.out.println("Failed to create campaign"); }
		 */
		/*
		 * Log out from the application homepage.signOut(driver);
		 * 
		 * Close the Browser driver.quit();
		 */
	}

}
