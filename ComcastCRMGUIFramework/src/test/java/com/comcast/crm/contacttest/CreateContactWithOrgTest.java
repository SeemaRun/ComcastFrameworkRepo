package com.comcast.crm.contacttest;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*create object*/
		FileUtility flib = new FileUtility();
    ExcelUtility elib = new ExcelUtility();
    JavaUtility jlib = new  JavaUtility();
    WebDriverUtility wlib = new WebDriverUtility();
    
    String BROWSER = flib.getDataFromPropertiesFile("browser");
    String URL = flib.getDataFromPropertiesFile("url");
    String USERNAME = flib.getDataFromPropertiesFile("username");
    String PASSWORD = flib.getDataFromPropertiesFile("password");
    
  
    
 
    
         // read testscript data from Excel file and random number
      
      String ORGNAME1 = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber() ;
      String contactLastName = elib.getDataFromExcel("contact", 7, 3);
      
      
		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Step1: login to app
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

		// Step2 : navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		// Step 3: click on "create organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 4: enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 5: navigate to contact module
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		// Step 3: click on "create CONTACT" button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// Step 4: enter all the details & create new CONTACT

		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		// org +lookup window
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// SWITCH To child window
		Thread.sleep(2000);

		// Switch to childwindow
		wlib.switchToTabOnURL(driver, "module=Accounts");
		
				driver.findElement(By.xpath("//input[@type='text' and @class=\"txtBox\"]")).sendKeys(ORGNAME1);
				driver.findElement(By.name("search")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='"+ ORGNAME1 +"']")).click();
			
			// // Switch back to parent window

		wlib.switchToTabOnURL(driver, "?module=Contacts&action");
			
			// to savebutton
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

			// verify contact
			boolean headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText().contains(contactLastName);
			if (headerInfo) {
				System.out.println(contactLastName + " header verified==Pass");
			} else {
				System.out.println(contactLastName + " header is verified==Fail");

			}

//verify Header ornName into Expected result
			String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			System.out.println(actOrgName);
			if (actOrgName.trim().contains(ORGNAME1)) {
				System.out.println(ORGNAME1 + " information is created==Pass");
			} else {
				System.out.println(ORGNAME1 + " information is not created==FAIL");

			}
			// Step 5: logout
			driver.quit();
		}

	}

