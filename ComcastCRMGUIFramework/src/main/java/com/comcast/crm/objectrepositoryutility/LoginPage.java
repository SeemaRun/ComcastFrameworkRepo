package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
/**
 * @author Seema
 * 
 * Contains Login page elements & business lib like login()
 */

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
   // Rule2:object creation
	@FindBy(name="user_name")
	public WebElement usernameedt;
	
	@FindBy(name="user_password")
	public WebElement passwordedt;
	
	@FindBy(id="submitButton")
	public WebElement loginbutton;
	
	//Rule3: object Initialization
	
		//Rule4: Object Ecapsulation

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	/**
	 * login to application based username ,password , url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	//Rule5: provide ACtion(business Library)
	public void loginToapp(String url,String username,String password)
	{  
		
		waitForPageToLoad(driver);
		driver.get(url);
		usernameedt.sendKeys(username);
		passwordedt.sendKeys(password);
		loginbutton.click();
		driver.manage().window().maximize();
	}
	
	public void loginToapp(String username,String password)
	{  
		
		waitForPageToLoad(driver);
		usernameedt.sendKeys(username);
		passwordedt.sendKeys(password);
		loginbutton.click();
		driver.manage().window().maximize();
	}
}
