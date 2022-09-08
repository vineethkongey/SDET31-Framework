package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

/**
 * This class contains all the WebElements of create new campaign Page.
 * @author Soumyajit
 *
 */
public class CreateNewCampaignPage {
	
	/*Object creation of Utility class*/
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelDataUtility eLib = new ExcelDataUtility();
	
	/*Declaration of WebElement*/
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	@FindBy(xpath="//input[@name='product_name']/following-sibling::img")
	private WebElement addProductIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	/*getters method for accessing the private WebElement*/
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getAddProductIcon() {
		return addProductIcon;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*Initialization of WebElement*/
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Business logic*/
	
	/**
	 * This Method will enter the campaign name in campaign name text field.
	 * @param campName
	 */
	public void enterCampaignName(String campName)
	{
		campaignName.sendKeys(campName);
	}
	
	/**
	 * This method will choose the product from pop up  window.
	 * @param driver
	 * @param productName
	 */
	public void addProduct(WebDriver driver,String productName)
	{
		addProductIcon.click();
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		wLib.switchToWindow(driver, "Campaigns");
		
	}
	
	/**
	 * This method will click the save button on create campaign page.
	 */
	public void clickOnSave()
	{
		saveButton.click();
	}
	
	

}
