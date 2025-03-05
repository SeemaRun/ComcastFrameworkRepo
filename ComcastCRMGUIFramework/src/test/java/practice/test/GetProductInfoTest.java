package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.genericfileutility.ExcelUtility;

public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		Thread.sleep(2000);
		//capture product  priceinfo
		//STORE X PATH IN A VARIABLE
	
	String x=	"//span[text()='"+productName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
	driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
        ExcelUtility elib = new ExcelUtility();
        int rowcount = elib.getRowcount("product");

        Object[][] objArr = new Object[rowcount][2];
        for (int i = 0; i < rowcount; i++) {
            objArr[i][0] = elib.getDataFromExcel("product", i + 1, 0);
            objArr[i][1] = elib.getDataFromExcel("product", i + 1, 1);
		}
		
		
		
		return objArr;
	}
	
}
