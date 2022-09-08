package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class can handle all the actions related to Organizations Page.
 * @author Soumyajit
 *
 */
public class OrganizationsPage {
	
	/* Declaration of WebElement */
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgIcon;
	
	/* getters method to fetch private members*/
	public WebElement getCreateOrgIcon()
	{
		return createOrgIcon;
	}
	
	/* Initialization of WebElement */
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This method will click on create organization.
	 */
	public void clickOnCreateOrgIcon()
	{
		createOrgIcon.click();
	}
	
	

}
