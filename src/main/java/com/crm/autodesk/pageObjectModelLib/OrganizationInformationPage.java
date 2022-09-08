package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will used to validate the information in Test Case.
 * @author Soumyajit
 *
 */
public class OrganizationInformationPage {
	
	/* Declaration of WebElement */
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement orgName;
	
	@FindBy(xpath="//span[@id='dtlview_Industry']")
	private WebElement industryType;

	
	/* getters method to access the private members */
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryType() {
		return industryType;
	}
	
	/* Initialization of WebElement */
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This method will return the name of the organization from Organization information page.
	 * @return
	 */
	public String fetchOrgName()
	{
		return orgName.getText();
	}
	
	
	/**
	 * This method will return the type of industry chosen.
	 * @return
	 */
	public String fetchIndustryType()
	{
		return industryType.getText();
	}
	

}
