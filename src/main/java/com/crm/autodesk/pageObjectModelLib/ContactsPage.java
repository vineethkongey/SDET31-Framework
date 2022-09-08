package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will perform all the operations related to contacts page.
 * @author Soumyajit
 *
 */
public class ContactsPage {
	/* Declaration of WebElement */
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;

	
	
	/* getters method for private WebElement */
	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}
	
	/* Initialization of WebElement */
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/* Business Logic */
	
	/**
	 * This method will click on Create Contact Icon. 
	 */
	public void clickOnCreateContact()
	{
		createContactIcon.click();
	}
	
}
