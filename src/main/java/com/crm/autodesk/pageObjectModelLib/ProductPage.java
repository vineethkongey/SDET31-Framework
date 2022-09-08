package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will handle all the operations related to products page.
 * @author Soumyajit
 *
 */
public class ProductPage {
	/*Declaration of WebElement*/
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createNewproductIcon;
	
	
	@FindBy(xpath="//a[text()='Create Filter']")
	private WebElement createFilterLink;
	
	@FindBy(xpath="//select[@name='viewname']")
	private WebElement filterDropDown;
	
	
	/*getters method for accessing WebElement*/
	
	public WebElement getCreateFilterLink() {
		return createFilterLink;
	}
	
	public WebElement getFilterDropDown() {
		return filterDropDown;
	}
	
	public WebElement getCreateNewproductIcon() {
		return createNewproductIcon;
	}

	/*Initialization of WebElement*/
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * This method will perform click action on Products link.
	 */
	public void clickOnCreateFilter()
	{
		createFilterLink.click();
	}   
	
	/**
	 * This method will click on create new product icon.
	 */
	public void clickOnCreateproductIcon()
	{
		createNewproductIcon.click();
	}
	
	
}
