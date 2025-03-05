package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws IOException {
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
      
      String ORGNAME1 = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber() ;
      String contactLastName = elib.getDataFromExcel("contact", 7, 3);
      
	      
	      
	      //Launch the browser
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

	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

	    driver.findElement(By.id("submitButton")).click();

	    // Step2 : navigate to organization module
	    driver.findElement(By.linkText("Contacts")).click();
	     // Step 3: click on "create organization" button
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    //Step 4: enter all the details & create new organisation 
	    //date and time
	      
	      String   startDate   =  jlib.getSystemDateYYYYDDMM();
	      
	      //Calendar
	     
	    String  endDate =  jlib.getRequiredDateTYYYYDDMM(30);
	    
	    
	     driver.findElement(By.name("lastname")).sendKeys(contactLastName);
	     //start and end date
	     driver.findElement(By.name("support_start_date")).clear();
	     driver.findElement(By.name("support_start_date")).sendKeys(startDate );
	     driver.findElement(By.name("support_end_date")).clear();
	     driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	     //to savebutton
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	    //verify StartDate
	    String actualStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	  if(actualStartDate.contains(startDate))
	  {
		  System.out.println(startDate + " is created==Pass");
	    } 
	  else { 
		  System.out.println(startDate + "is not created==FAIL");
		  
	    }
	    
	   	  //verify enddate
	   	String actendDate =  driver.findElement(By.id("dtlview_Support End Date")).getText();
	   	if(actendDate .equals(endDate)) {
	   		System.out.println(endDate +"Information is created==Pass");
	   	
	   	}else {
	   		System.out.println(endDate +"Information is not created==Fail");
	   		
	   	}
	
	     //Step 5: logout
	      driver.quit();
	}
	
	}


