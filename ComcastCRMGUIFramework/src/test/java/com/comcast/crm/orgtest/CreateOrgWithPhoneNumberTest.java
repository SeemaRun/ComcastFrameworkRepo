package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgWithPhoneNumberTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

	    
	    String BROWSER = pObj.getProperty("browser");
	    String URL = pObj.getProperty("url");
	    String USERNAME = pObj.getProperty("username");
	    String PASSWORD = pObj.getProperty("password");
	    
	  

	    //generate the random number
	    Random random = new Random();
	    int randomInt = random.nextInt(1000);

	         // read testscript data from Excel file
	      FileInputStream fis1 = new FileInputStream("./testdata/testScriptdata.xlsx");
	      Workbook wb = WorkbookFactory.create(fis1);
	      Sheet sh = wb.getSheet("org");
	      Row row = sh.getRow(7);
	      String orgName = row.getCell(2).toString() + randomInt ;
	      String phoneNumber = row.getCell(3).getStringCellValue();
	      
	      wb.close();
	      
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
	    driver.findElement(By.linkText("Organizations")).click();
	     // Step 3: click on "create organization" button
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    //Step 4: enter all the details & create new organisation 
	    
	     driver.findElement(By.name("accountname")).sendKeys(orgName);
	     //select phoneNumber
	     driver.findElement(By.id("phone")).sendKeys(phoneNumber);
	     //to save
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	     
	     

	     
	    //verify Header msg Expected result
	    String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	  if(headerinfo.contains(orgName))
	  {
		  System.out.println(headerinfo + " is created==Pass");
	    } 
	  else { 
		  System.out.println(headerinfo + "is not created==FAIL");
		  
	    }
	    
	   	  //verify phoneNumber
	   	String actualphoneNumber =  driver.findElement(By.id("dtlview_Phone")).getText();
	   	if(actualphoneNumber .equals(phoneNumber)) {
	   		System.out.println(phoneNumber +" Information is created==Pass" );
	   	}
	   	else {
	   		System.out.println(phoneNumber +" Information is not created==Fail" );
	   		
	   	}
	     //Step 5: logout
	      driver.quit();
	}
	}
	


