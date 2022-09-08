package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the WebElements of Product Information page and also the business logics. 
 * @author Soumyajit
 *
 */
public class ProductInfoPage {
	
	/*Declaration of WebElement*/
	
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
	private WebElement infoProductName;

	
	
	/*getters method to access the WebElements*/
	public WebElement getInfoProductName() {
		return infoProductName;
	}
	
	/*Initialization of WebElements*/
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Business Logic*/
	
	
	/**
	 * This method will fetch the product name from the product information page.
	 * @return
	 */
	public String getProductName()
	{
		return infoProductName.getText();
	}
	

}
