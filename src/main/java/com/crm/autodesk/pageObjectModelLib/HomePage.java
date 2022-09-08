package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.commonutility.WebDriverUtility;

/**
 * This class contain all the necessary WebElement of HomePage.
 * @author Soumyajit
 *
 */

public class HomePage extends WebDriverUtility {
	
	/*Object Creation of WebDriver Utility classes*/
	WebDriverUtility wLib = new WebDriverUtility();
	
	/* WebElement declaration */
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutLinkIcon;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignLink;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	

	
	/* getters for accessing WebElements */
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProducts() {
		return productsLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}
	
	
	public WebElement getSignOutLinkIcon()
	{
		return signOutLinkIcon;
	}
	
	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	
	
	
	/*initialization of WebElement Object */
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Business Logic */
	
	/**
	 * This method will perform click action on Organizations Link.
	 */
	public void clickOnOrganizations()
	{
		organizationLink.click();
	}
	
	
	/**
	 * This method will click on Contacts Link.
	 */
	public void clickOnContacts()
	{
		contactLink.click();
	}
	
	/**
	 * This method will perform click action on Products Link. 
	 */
	public void clickOnProducts()
	{
		productsLink.click();
	}
	
	
	/**
	 * This method will perform the Log Out operation from the application.
	 * @param driver
	 */
	public void signOut(WebDriver driver)
	{
		
		mouseOverToElement(driver,signOutLinkIcon);
		signOutLink.click();
		
	}
	
	/**
	 * This method will perform the mouse over action on More Link.
	 * @param driver
	 */
	public void mouseOverOnMoreLink(WebDriver driver)
	{
		wLib.mouseOverToElement(driver, moreLink);
	}
	
	/**
	 * This method will click on Campaign link.
	 */
	public void clickOnCampaign()
	{
		campaignLink.click();
	}

}
