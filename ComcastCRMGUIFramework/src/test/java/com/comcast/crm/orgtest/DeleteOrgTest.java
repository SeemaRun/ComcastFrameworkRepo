 package com.comcast.crm.orgtest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganisationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
	/*create object*/
		FileUtility flib = new FileUtility();
    ExcelUtility elib = new ExcelUtility();
    JavaUtility jlib = new  JavaUtility();
    WebDriverUtility wlib = new  WebDriverUtility();
    
    String BROWSER = flib.getDataFromPropertiesFile("browser");
    String URL = flib.getDataFromPropertiesFile("url");
    String USERNAME = flib.getDataFromPropertiesFile("username");
    String PASSWORD = flib.getDataFromPropertiesFile("password");
    
  //random number
    

    
         // read testscript data from Excel file
      
      String ORGNAME1 = elib.getDataFromExcel("org", 10, 2) + jlib.getRandomNumber();
      
      
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
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     driver.get(URL);
      LoginPage lp =  new LoginPage(driver);
      lp.loginToapp(USERNAME,PASSWORD );

    // Step2 : navigate to organization module
      HomePage hp = new HomePage(driver);
      hp.getOrgLink().click();
   Thread.sleep(2000);
     // Step 3: click on "create organization" button
      OrganizationsPage cnp = new  OrganizationsPage(driver);
      cnp.getCreateNewOrgBtn().click();
      
      //Step 4:enter all the details & create new organisation
      CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
      cnop.createOrg(ORGNAME1);
   
    //verify Header msg Expected result
      OrganisationInfoPage oip = new OrganisationInfoPage(driver);
      String actOrgName = oip.getHeaderMsg().getText();
      if(actOrgName.contains(ORGNAME1)) {
    	  System.out.println(ORGNAME1 + "name is verified ==pass");
      }else {
    	  System.out.println(ORGNAME1 + "name is not verified == Fail");
      }
    
     //GO BACK to organisation page
      hp.getOrgLink().click();
      
      //Search for organisation
      cnp.getSearchedt().sendKeys(ORGNAME1);
    wlib.select(cnp.getSearchDD(), "Organization Name");
    cnp.getSearchbtn().click();
    //this is for dynamic element 
    driver.findElement(By.xpath("//a[text()='"+ ORGNAME1+"']/../../td[8]/a[text()='del']")).click();
      
      
     //Step 5: logout
      hp.logout();
      
      driver.quit();


	}

	}

