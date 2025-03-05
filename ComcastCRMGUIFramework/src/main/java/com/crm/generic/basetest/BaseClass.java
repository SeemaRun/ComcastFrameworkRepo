package com.crm.generic.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericdatabaseutility.DataBaseUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	/*create object of  utility file for fetching data from property and excel file*/
	
	public DataBaseUtility dblib = new DataBaseUtility();
	
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public  static WebDriver sdriver = null;
	
	
	
	 @BeforeSuite(groups= {"smokeTest","regressionTest"})
     public void configBS() throws SQLException {
  	 System.out.println("===Connect to DB,Report config ===");  
  	// dblib.getDBConnection();
  	 
  			
     }
	 
	 //@Parameters ("Browser")
	 @BeforeClass(groups= {"smokeTest","regressionTest"})
		public void configBC() throws IOException {
		 System.out.println("==Launch the Browser==");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		
	      
	      if (BROWSER.equals("chrome")) {
	    	driver = new ChromeDriver();
	      } else if (BROWSER.equals("firefox")) {
	     	driver = new FirefoxDriver();
	      } else if (BROWSER.equals("edge")) {
		  driver = new EdgeDriver();
	     } else {
		 driver = new ChromeDriver();
	    }
	      sdriver = driver;           // Assigning driver to sdriver
	      UtilityClassObject.setDriver(driver);
		}
		
		@BeforeMethod(groups= {"smokeTest","regressionTest"})
		public void configBM() throws IOException {
			System.out.println("==login==");
			String URL = flib.getDataFromPropertiesFile("url");
			String USERNAME = flib.getDataFromPropertiesFile("username");
			String PASSWORD = flib.getDataFromPropertiesFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToapp(URL, USERNAME, PASSWORD);
		}
		
		@AfterMethod(groups= {"smokeTest","regressionTest"})
		   public void configAM() throws InterruptedException {
			  
			   HomePage hp = new HomePage(driver);
			   hp.logout();
			   System.out.println("==logout==");
			
			   
		   }
		   @AfterClass(groups= {"smokeTest","regressionTest"})
		   public void configAC() {
			   System.out.println("===== Close the Browser =====");
			   driver.quit();
		   }
	
     @AfterSuite(groups= {"smokeTest","regressionTest"})
     public void configAS() throws SQLException {
  	 System.out.println("===close Db,Report backup ===");  
  	 //dblib.closeDBConnection();
  	 
     }
}
