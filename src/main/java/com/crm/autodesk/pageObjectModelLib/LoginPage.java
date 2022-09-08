package com.crm.autodesk.pageObjectModelLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the WebElement of Login page and also perform the login action. 
 * @author Soumyajit
 *
 */
public class LoginPage {
	
	//Declaration of web element
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	
	/*getters method to access in other classes*/
	public WebElement getUsernameTextField()
	{
		return usernameTextField;
	}
	
	public WebElement getPasswordTextField()
	{
		return passwordTextField;
	}
	
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	
	/*Initialization of WebElents*/
	  public LoginPage(WebDriver driver) { 
		  PageFactory.initElements(driver, this);
	  }
	 
	
	/*Business Logic*/
	
	  /**
	   * This method will perform the login to the application.
	   * @param username
	   * @param password
	   */
	public void login(String username,String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
		
	}
	

}
