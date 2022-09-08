package com.crm.autodesk.commonutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class can handle all WebDriver Utilities
 * 
 * @author Soumyajit
 *
 */
public class WebDriverUtility {
     
	/**
	 * This method is used to provide wait until WebElement is loaded.
	 * @param driver
	 * @param time
	 */
	public void implicitWait(WebDriver driver,int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * This method is used to put wait until a particular condition is satisfied.
	 * @param driver
	 * @param webElement
	 * @param time
	 */
	public void explicitWait(WebDriver driver, WebElement webElement,int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	/**
	 * This method is used to provide customized polling time.
	 * @param driver
	 * @param webElement
	 * @param pollTime
	 * @param waitTime
	 */
	  public void customPollingTime(WebDriver driver,WebElement webElement,int pollTime,int waitTime)
	  {
		  FluentWait wait = new FluentWait(driver);
		  wait.pollingEvery(Duration.ofSeconds(pollTime));
		  wait.withTimeout(Duration.ofSeconds(waitTime));
		  wait.until(ExpectedConditions.visibilityOf(webElement));
	  }
	

	/**
	 * This method will put wait for all the AJAX elements.
	 * @param driver
	 * @param time
	 */
	public void scriptWaitForJSE(WebDriver driver,int time) {
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(time));
	}

	/**
	 * This method will put wait for each WebElement.
	 * @param driver
	 * @param time
	 */
	public void pageLoadTimeOut(WebDriver driver,int time) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	}

	/**
	 * This method is used to switch from one window to another
	 * 
	 * @param driver
	 * @param title
	 */
	public void switchToWindow(WebDriver driver, String title) {
		Set<String> allWindowId = driver.getWindowHandles();
		Iterator<String> itr = allWindowId.iterator();

		while (itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	/**
	 * This method is used to perform mouse over action to any WebElement.
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void mouseOverToElement(WebDriver driver, WebElement webElement) {
		Actions act = new Actions(driver);
		act.moveToElement(webElement).perform();
		
	}

	/**
	 * This method is used to perform right click action on any WebElement.
	 * 
	 * @param driver
	 * @param webElement
	 */

	public void performRightClickOnElement(WebDriver driver, WebElement webElement) {
		Actions act = new Actions(driver);
		act.contextClick(webElement).perform();
		
	}

	/**
	 * This method is used select from Drop-Down by using index number.
	 * 
	 * @param webElement
	 * @param index
	 */
	public void selectFromDropDown(WebElement webElement, int index) {
		Select s = new Select(webElement);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to select any value from Drop-Down by using VisibleText.
	 * 
	 * @param webElement
	 * @param visibleText
	 */

	public void selectFromDropDown(WebElement webElement, String visibleText) {
		Select s = new Select(webElement);
		s.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to perform scroll down action in any window.
	 * 
	 * @param driver
	 */
	public void scrollDownWindow(WebDriver driver,int x_cordinate,int y_cordinate) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(x_cordinate,y_cordinate);");
	}

	/**
	 * This method is used to accept any alert Pop-Up.
	 * 
	 * @param driver
	 */
	public void alertPopUpAccept(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
	}

	/**
	 * This method is used to dismiss or cancel any Alert Pop-Up.
	 * 
	 * @param driver
	 */
	public void alertPopUpDismiss(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	/**
	 * This method will take the screenshot of a particular page.
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public String takeScreenshotOfPage(WebDriver driver, String screenshotName) throws IOException {
		Date d = new Date();
		String date = d.toString().replace(" ", "-").replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		screenshotName = screenshotName + date;
		File destination = new File("./Screenshots/" + screenshotName + " " + ".png");
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot Taken Successfully");
		return destination.getAbsolutePath();
	}

	/**
	 * This method is used to switch to a particular frame based on index of frames.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * This method is used to switch to a particular frame by passing the WebElement
	 * of that frame.
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void switchToFrame(WebDriver driver, WebElement webElement) {
		driver.switchTo().frame(webElement);
	}

	/**
	 * This method is used to switch to a particular frame by passing either ID or
	 * Name or Value of particular frame.
	 * 
	 * @param driver
	 * @param id_Name_Value
	 */

	public void switchToFrame(WebDriver driver, String id_Name_Value) {
		driver.switchTo().frame(id_Name_Value);
	}
	
	
	/**
	 * This method will put a wait based on a logic and is different from Implicit wait,Esxplicit wait or Fluent wait.
	 * @param element
	 * @throws InterruptedException
	 */
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }


}
