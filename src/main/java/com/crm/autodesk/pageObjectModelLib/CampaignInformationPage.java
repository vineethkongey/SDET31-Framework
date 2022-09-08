package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains the WebElements of 
 * @author manda
 *
 */
public class CampaignInformationPage {
	
	/*Declaration of WebElement*/
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement campaignNameValidation;

	/*getters method for accessing the private WebElements*/
	public WebElement getCampaignNameValidation() {
		return campaignNameValidation;
	}
		
		/*Initialization of WebElement*/
		public CampaignInformationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		/*Business Logic*/
		public String getCampaignName()
		{
			return campaignNameValidation.getText();
		}
	
	
	

}
