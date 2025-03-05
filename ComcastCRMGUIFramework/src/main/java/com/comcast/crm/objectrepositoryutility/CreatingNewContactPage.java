package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility {
    
	//rule3: object initialization
		WebDriver driver;
		//create constructor
		public CreatingNewContactPage (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
			@FindBy(xpath="//input[@type='text' and @name='lastname']")
			WebElement contactLastNameField;
			
			// org +lookup window
			@FindBy(xpath="//input[@name='account_name']/following-sibling::img") 
	     WebElement orglookup;
		
			@FindBy(id="search_txt")
			WebElement searchbutton;
			
			@FindBy(xpath="//input[@type='text' and @class=\"txtBox\"]")
			WebElement selectorgName;
					
			@FindBy(name="search") //.click();
			WebElement searchnowbutton;
			
			@FindBy(xpath="//input[@name='support_start_date']")
			 WebElement supportsatrtdatefield;
			
			@FindBy(xpath="//input[@name='support_end_date']")
			WebElement supportenddatetextfield;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			WebElement savebutton;
			
			public WebDriver getDriver() {
				return driver;
			}

			

			public WebElement getSavebutton() {
				return savebutton;
			}

			public WebElement getContactLastNameField() {
				return contactLastNameField;
			}

			public WebElement getSupportsatrtdatefield() {
				return supportsatrtdatefield;
			}

			public WebElement getSupportenddatetextfield() {
				return supportenddatetextfield;
				
				
			}
		public WebElement getOrglookup() {
				return orglookup;
			}

			public WebElement getSearchbutton() {
				return searchbutton;
			}

			public WebElement getSelectorgName() {
				return selectorgName;
			}

			public WebElement getsearchnowbutton() {
				return searchnowbutton;
			}

			//Business logic
			public void createContactWithSupportDate(String lastName,String startDate,String endDate) throws InterruptedException {
				Thread.sleep(2000);
				contactLastNameField.sendKeys(lastName);
				supportsatrtdatefield.clear();
				supportsatrtdatefield.sendKeys(startDate);
				supportenddatetextfield.clear();
				supportenddatetextfield.sendKeys(endDate);
				savebutton.click();
				
			}
        public void createContactwithOrg(String LastName, String orgName) throws InterruptedException {
        	contactLastNameField.sendKeys(LastName);
        	orglookup.click();
        	// Switch to childwindow
    		switchToTabOnURL(driver, "module=Accounts");
    		searchbutton.sendKeys(orgName);
    		searchnowbutton.click();
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
          // Switch back to parent window

          switchToTabOnURL(driver, "?module=Contacts&action");
          savebutton.click();

			}
			}

