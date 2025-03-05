package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
    
	WebDriver driver;
	public OrganisationInfoPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
      }

	@FindBy(xpath="//span[@class='dvHeaderText']")
	WebElement headerMsg;
	

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	}
	
	

