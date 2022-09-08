package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;

/**
 * This class will handle all the operation related to the custom filter page.
 * @author Soumyajit
 *
 */
public class CustomFilterPage {
	
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	/*Declaration of WebElement*/
	@FindBy(xpath="//input[@class='detailedViewTextBox']")
	private WebElement viewNameTextField;
	
	@FindBy(xpath="//input[@name='setDefault']")
	private WebElement setAsDefaultChkBox;
	
	@FindBy(xpath="//input[@name='setMetrics']")
	private WebElement listInMetricsChkBox;
	
	@FindBy(xpath="//input[@name='setStatus']")
	private WebElement setAsPublicChkbox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//select[@name='stdDateFilterField']")
	private WebElement selectColumn;
	
	@FindBy(xpath="//select[@name='stdDateFilter']")
	private WebElement selectDurationDropDown;
	
	@FindBy(xpath="//input[@id='jscal_field_date_start']")
	private WebElement startDateTextField;
	
	@FindBy(xpath="//input[@id='jscal_field_date_end']")
	private WebElement endDateTextField;

	
	
	

	/*getters method to access the private web elements*/
	public WebElement getViewNameTextField() {
		return viewNameTextField;
	}

	public WebElement getSetAsDefaultChkBox() {
		return setAsDefaultChkBox;
	}

	public WebElement getListInMetricsChkBox() {
		return listInMetricsChkBox;
	}

	public WebElement getSetAsPublicChkbox() {
		return setAsPublicChkbox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getSelectColumn() {
		return selectColumn;
	}

	public WebElement getSelectDurationDropDown() {
		return selectDurationDropDown;
	}

	public WebElement getStartDateTextField() {
		return startDateTextField;
	}

	public WebElement getEndDateTextField() {
		return endDateTextField;
	}
	
	/*Initialization of WebElement*/
	public CustomFilterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will enter viewName in view name text field.
	 * @param viewName
	 */
	public void enterViewName(String viewName)
	{
		viewNameTextField.sendKeys(viewName);
		
	}
	
	/**
	 * This method will select the Set As Default check box.
	 */
	public void selectSetAsDefault()
	{
		setAsDefaultChkBox.click();
	}
	
	/**
	 * This method will select the List In Matrix check box.
	 */
	public void SelectListInMactrix()
	{
		listInMetricsChkBox.click();
	}
	
	/**
	 * This method will select Set As Default check box.
	 */
	public void selectSetAsPublic()
	{
		setAsPublicChkbox.click();
	}
	
	/**
	 * This method will click on save button.
	 */
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	/**
	 * This method will select the desire column from Simple Time Filter.
	 * @param visibleText
	 */
	public void selectColoumn(String visibleText)
	{
		wLib.selectFromDropDown(selectColumn,visibleText);
	}
	
	/**
	 * This method will select duration from select duration drop down menu.
	 * @param visibleText
	 */
	public void selectDuration(String visibleText)
	{
		wLib.selectFromDropDown(selectDurationDropDown, visibleText);
	}
	
	/**
	 * This method will return the system date.
	 * @return
	 */
	public void enterStartDate()
	{
		startDateTextField.sendKeys(jLib.getSystemDate());
	}
	
	/**
	 * This method will return the end date.
	 * @param endDate
	 * @return
	 */
	public void enterEndDate(String endDate)
	{
		endDateTextField.sendKeys(endDate);; 
	}
	
	
	

}
