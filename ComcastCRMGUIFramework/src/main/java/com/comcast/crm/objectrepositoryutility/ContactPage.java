package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	
	//rule3: object initialization
		WebDriver driver;
		//create constructor
		public ContactPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		@FindBy(xpath ="//img[@title='Create Contact...']")
		private WebElement CreateNewOrgBtn;
		
		public WebElement getCreateNewOrgBtn() {
			return CreateNewOrgBtn;
		}
		
		@FindBy(className="dvHeaderText")
			private	WebElement headerMsg;
		

		public WebElement getHeaderMsg() {
			return headerMsg;
		}
		
		}
		

