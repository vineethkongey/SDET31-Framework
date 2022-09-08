package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

/**
 * This class can handle all the actions related to creating organization page.
 * @author Soumyajit
 *
 */
public class CreateOrganizationspage {
	ExcelDataUtility eLib = new ExcelDataUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	/* Declaration of WebElement */
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameTextField;
	
	@FindBy(name="industry")
	private WebElement industrySelectionDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	/* getters method to access private number */
	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getIndustrySelectionDropDown() {
		return industrySelectionDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/* Initialization of WebElement */
	
	public CreateOrganizationspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/* Business Logic */
	
	/**
	 * This method will enter the organization name in the organization text field.
	 * @throws Throwable
	 */
	public void enterOrgName(String path, String sheetname,int row,int cell,int randomNum) throws Throwable
	{
		String orgName = eLib.getExcelData(path,sheetname,row,cell);
		System.out.println(orgName);
		orgName = orgName+ randomNum;
		orgNameTextField.sendKeys(orgName);
		
	}
	
	
	/**
	 * This method will select the preferred Industry type from the drop-down menu.
	 * @throws Throwable
	 */
	public void selectFromDropDown() throws Throwable
	{
		wLib.selectFromDropDown(industrySelectionDropDown,eLib.getExcelData("./src/test/resources/Test Data.xlsx", "Industry", 17,0));
	}
	
	
	/**
	 * This method will click the save button.
	 */
	public void clickOnSave()
	{
		saveButton.click();
	}
	
	
	

}
