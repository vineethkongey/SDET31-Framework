package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

/**
 * This class will handle all the scenarios related to creating new contact page.
 * @author Soumyajit
 *
 */
public class CreatingNewContactPage {
	
	ExcelDataUtility eLib = new ExcelDataUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	/* Declaration of WebElement */
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement chooseOrgNameIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;


	
	/* getters method for Private WebElement */
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getChooseOrgNameIcon() {
		return chooseOrgNameIcon;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/* initialization of WebElement */
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/* Business logic  */
	
	/**
	 * This method will enter the last name in the mandatory field.
	 * @param path
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @throws Throwable
	 */
	public void enterLastName(String path,String sheetName, int row,int cell) throws Throwable
	{
		String lastName = eLib.getExcelData(path, sheetName, row, cell);
		lastNameTextField.sendKeys(lastName);
	}
	
	/**
	 * This method will switch window from contact to organization pop up.
	 * @param driver
	 * @param orgName
	 */
	public void chooseOrg(WebDriver driver,String orgName)
	{
		chooseOrgNameIcon.click();
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wLib.switchToWindow(driver, "Contacts");
		
	}
	
	/**
	 * This method will perform click on save button action.
	 */
	public void clickOnSave()
	{
		saveButton.click();
	}

}
