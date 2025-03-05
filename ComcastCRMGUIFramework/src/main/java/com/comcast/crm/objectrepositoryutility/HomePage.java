package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;

public class HomePage {

	
	
	//rule3: object initialization
	WebDriver driver;
	//create constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(linkText = "Organizations")
		WebElement orgLink;
	
		@FindBy(linkText ="Contacts")
		WebElement contactlink;
		
		@FindBy(linkText ="More")
		WebElement morelink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		WebElement adminImg;
		
		@FindBy(xpath ="//a[text()='Sign Out']")
		WebElement signOutLink;
		
		@FindBy(linkText ="Campaigns")
		WebElement campaignlink;
		
		//Rule4: Object Ecapsulation
		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getOrgLink() {
			return orgLink;
		}

		public WebElement getContactlink() {
			return contactlink;
		}

		public WebElement getMorelink() {
			return morelink;
		}

		public WebElement getCampaignlink() {
			return campaignlink;
			
		}
		
		public WebElement getAdminImg() {
			return adminImg;
		}

		public WebElement getSignOutLink() {
			return signOutLink;
		}

		//Rule5: provide ACtion(business Library)
		public void navigateToCampaignPage() {
			Actions act = new Actions(driver);
			act.moveToElement(morelink).perform();
			campaignlink.click();
			
		}
	
	public void logout() throws InterruptedException {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.waitForElementToBeClickable(driver, adminImg);
		//Actions act = new Actions(driver);
		//act.moveToElement(adminImg).perform();
		adminImg.click();
		signOutLink.click();
	}
}



