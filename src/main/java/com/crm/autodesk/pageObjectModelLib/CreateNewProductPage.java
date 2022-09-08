package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the WebElements of create new product page and also the related business logics.
 * @author Soumyajit
 *
 */
public class CreateNewProductPage {
	
	/*Declaration of WebElement*/
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	/*getters method for accessing the private WebElements*/
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*Initialization of WebElements*/
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Business Logic*/
	
	/**
	 * This method will enter the product name in the product name text field.
	 * @param productName
	 */
	public void enterProductName(String productName)
	{
		productNameTextField.sendKeys(productName);
	}
	
	/**
	 * This method will click on save button.
	 */
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	

}
