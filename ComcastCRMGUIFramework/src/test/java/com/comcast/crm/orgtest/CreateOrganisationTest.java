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

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganisationInfoPage;

import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class CreateOrganisationTest {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
	/*create object*/
		FileUtility flib = new FileUtility();
    ExcelUtility elib = new ExcelUtility();
    JavaUtility jlib = new  JavaUtility();
    
    String BROWSER = flib.getDataFromPropertiesFile("browser");
    String URL = flib.getDataFromPropertiesFile("url");
    String USERNAME = flib.getDataFromPropertiesFile("username");
    String PASSWORD = flib.getDataFromPropertiesFile("password");
    
  //random number
    

    
         // read testscript data from Excel file
      
      String ORGNAME1 = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber() ;
      
      
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
      lp.loginToapp("admin", "password");

    // Step2 : navigate to organization module
      HomePage hp = new HomePage(driver);
      hp.getOrgLink().click();
   
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
    
     //verify Header orgname info Expected Result
     
     //Step 5: logout
      hp.logout();
      
      driver.quit();


	}

	}


    
           
      	
      
 
	

