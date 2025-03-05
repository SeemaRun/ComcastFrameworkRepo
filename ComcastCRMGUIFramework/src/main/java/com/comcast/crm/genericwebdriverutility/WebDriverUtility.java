package com.comcast.crm.genericwebdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	//method for implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}
	
	//CREATE METHOD FOR ExplicitWait
	public void waitForElementPresent(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//second method for explicit wait
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	//Create method for Switch to window using foreach loop ,childwindow
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String windowID : windowHandles) {
	        driver.switchTo().window(windowID);
	        String actUrl = driver.getCurrentUrl();
	        if (actUrl.contains(partialURL)) {
	            break;
	        }
	    }
	    }
	
	//Returning to the dashboard tab(parent)
	    public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String windowID : windowHandles) {
		        driver.switchTo().window(windowID);
		        String actTitle = driver.getTitle();
		        if (actTitle.contains(partialTitle)) {
		            break;
		        }
		    }
	    }
		    
		    //// Method to switch to a frame using its index
		    public void switchtoFrame(WebDriver driver,int index) {
		    	driver.switchTo().frame(index);
		    }
		 // Method to switch to a frame using its name 
		    public void switchtoFrame(WebDriver driver,String nameID) {
		    	driver.switchTo().frame(nameID);
		    }
		    //// Method to switch to a frame using a WebElement reference
		    public void switchtoFrame(WebDriver driver,WebElement element) {
		    	driver.switchTo().frame(element);
		    }
		  
		    //// Method to switch to an alert and accept it (click "OK")
		
		    public void switchtoAlertAndAccept(WebDriver driver) {
		    	driver.switchTo().alert().accept();
		    }
		    
		    
		 // Method to switch to an alert and dismiss it (click "Cancel")
		 
		    public void switchtoAlertAndCancel(WebDriver driver) {
		    	driver.switchTo().alert().dismiss();
		    }
		    // Method to select an option from a dropdown using visible text
		    public void select(WebElement element,String text) {
		    	Select sel = new Select(element);
		    	sel.selectByVisibleText(text);
		    }
		    // Method to select an option from a dropdown using its index
		    public void select(WebElement element,int index) {
		    	Select sel = new Select(element);
		    	sel.selectByIndex(index);
		    }
		    // Method to perform a double-click action on a web element
		    public void mouseMoveOnElement(WebDriver driver ,WebElement element) {
		    	Actions act = new Actions(driver);
		    	act.doubleClick(element).perform();
		    }
	}
	    


