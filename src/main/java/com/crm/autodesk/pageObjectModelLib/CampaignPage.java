package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the WebElements of campaign page and business logic related to campaign page.  
 * @author Soumyajit
 *
 */
public class CampaignPage {
	
	/*Declaration of WebElement*/
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement ceateCampaignIcon;
	
	/*getters method for accessing the private WebElement*/
	public WebElement getCeateCampaignIcon() {
		return ceateCampaignIcon;
	}
	
	/*Initialization of WebElement*/
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Business Logic*/
	
	/**
	 * This method will click on create campaign icon.
	 */
	public void clickOnCreateCampaignIcon()
	{
		ceateCampaignIcon.click();
	}

}
