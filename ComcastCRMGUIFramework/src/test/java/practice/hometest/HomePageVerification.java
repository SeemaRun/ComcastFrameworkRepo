package practice.hometest;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class HomePageVerification {
     
	// first testcase 
	@Test
	public void homePageTest(Method mtd){
		
		System.out.println(mtd.getName() + "Test start");
		String expectedPage = "Home Page";
		//LAUNCH THE BROWSER
		WebDriver driver = new ChromeDriver();
		//implicitlywait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 //navigate the application
		driver.get("http://localhost:8888");
		//login -username
		driver.findElement(By.name("user_name")).sendKeys("admin");
		//password
		driver.findElement(By.name("user_password")).sendKeys("password");
		//login button
		driver.findElement(By.id("submitButton")).click();
		//verify home button
	String actTitle	  = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	//Hard Assert
	Assert.assertEquals( actTitle	, expectedPage);
	driver.close();
	}

	
	
	
	// second testcase 
		@Test
		public void verifyLogoHomePageTest(Method mtd){
		
			System.out.println(mtd.getName() + "Test start");
			
			//LAUNCH THE BROWSER
			WebDriver driver = new ChromeDriver();
			//implicitlywait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 //navigate the application
			driver.get("http://localhost:8888");
			//login -username
			driver.findElement(By.name("user_name")).sendKeys("admin");
			//password
			driver.findElement(By.name("user_password")).sendKeys("password");
			//login button
			driver.findElement(By.id("submitButton")).click();
			//verify LOGO BUTTON
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
		Assert.assertEquals(true, status);
	driver.close();
		System.out.println(mtd.getName() + "Test End");
			
			
			
		}
	
	
}
	
	
	
	
	
	

