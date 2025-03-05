package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	WebElement orgNameEdt;
	
	//select class
	
	@FindBy(name="industry")
	WebElement industryDB;
	
	@FindBy(name="accounttype")
	WebElement typeDB;
	
	@FindBy(id="phone")
	WebElement phonetextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
			WebElement savebtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
		
	}
		//business logic
	public WebElement getIndustryDB() {
		return industryDB;
	}
	

	public WebElement getTypeDB() {
		return typeDB;
	}
	

	public WebElement getPhonetextfield() {
		return phonetextfield;
	}

	//BUSINESS LOGICS 
	public void createOrg(String ORGNAME1) {
		orgNameEdt.sendKeys( ORGNAME1);
		savebtn.click();
	}
		public void createOrg(String ORGNAME1 ,String industry ,String phoneNumber) {
			orgNameEdt.sendKeys( ORGNAME1 );
			Select sel = new Select(industryDB);
			sel.selectByVisibleText(industry);
			Select sel2 = new Select(typeDB);
			sel2.selectByVisibleText(industry);
			phonetextfield.sendKeys(phoneNumber);
			savebtn.click();
}
}
