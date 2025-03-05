package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	ExtentReports report;

	@BeforeSuite
	public void configBS() {

		{
			// Spark report config
			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Project");
			spark.config().setTheme(Theme.DARK);
			// add Env information and create test
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("Browser", "CHROME-100");

		}
	}

	@AfterSuite
	public void configAS() {
		report.flush();

	}

	// create test method give object of ExtentTest
	@Test

	public void createContactTest() {
		// To attached Screenshot
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page ");
		test.log(Status.INFO, "create contact");
		// verify the contact
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			// test.log(Status.PASS, "contact is not created");
			test.addScreenCaptureFromBase64String(src, "ErrorFile");
		}
		driver.close();

	}
}
