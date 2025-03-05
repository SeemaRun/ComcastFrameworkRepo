package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
       
	
	public OrganizationsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	WebElement searchedt;
	
	@FindBy(name="search_field")
	WebElement searchDD;
	
	@FindBy(name="submit")
	WebElement searchbtn;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	WebElement createNewOrgBtn;
	
	
	

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
		
	}

	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getSearchDD() {
		return searchDD;
		
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
}
