package practice.testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class SampleTestForScreenshot {
     
	@Test
	public void amazonTest() throws IOException {
	
		WebDriver driver = new ChromeDriver();
		// Set implicit wait
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://flipkart.com");
		
		//step1 create an object of Takesscreenshot
		TakesScreenshot ts = (TakesScreenshot) driver; 
		//step 2- use getscreenshotAs method to get file type of screeshot
	 File src =	ts.getScreenshotAs(OutputType.FILE);
	// step 3- 
     File des = new File("./screenshot/test.png");
		
		//step4 store screen on local driver
     FileUtils.copyFile(src, des);
		driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
