package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the WebElements present in Contact Information Page and the related operations also.
 * @author Soumyajit
 *
 */
public class ContactsInformationPage {
	
	/*Declaration of WebElement*/
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement orgNameField;
	
	
	
	/*getters method to access the private elements*/
	public WebElement getLastNameField()
	{
		return lastNameField;
	}

	/*Initialization of WebElement*/
	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Business Logic*/
	
	/**
	 * This method will fetch the text present in last name section in contact information page.
	 * @return
	 */
	public String getLastName()
	{
		return lastNameField.getText();
	}
	
	/**
	 * This method will return the organization name from the contact information page.
	 * @return
	 */
	public String getOrgName()
	{
		return orgNameField.getText();
	}
}
