package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.crm.generic.basetest.BaseClass;

public class ListImpClass implements ITestListener ,ISuiteListener {
	//public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	System.out.println("Report Confuguration");
	 //EXTENTREPOTER
  	//Spark report config 
	  String time =	new Date().toString().replace(" ", "_").replace(":", "_");
  			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report+"+time+".html");
  			spark.config().setDocumentTitle("CRM Test Suite Results");
  			spark.config().setReportName("CRM Project");
  			spark.config().setTheme(Theme.DARK);
  			//Add env information and create test
  			 report = new ExtentReports();
  			report.attachReporter(spark);
  			report.setSystemInfo("OS","Windows-10");
  			report.setSystemInfo("Browser", "CHROME-100");
  			
     }
	 
	

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("========>"+ result.getMethod().getMethodName() +">====Start===");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==> STARTED <====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("========>"+ result.getMethod().getMethodName() +">====End===");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"==> COMPLETED <====");
	}

	 @Override
	    public void onTestFailure(ITestResult result) {
	        String testName = result.getMethod().getMethodName();
	        TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver; 
		       String filePath = ts.getScreenshotAs(OutputType.BASE64);
	        String time =	new Date().toString().replace(" ", "_").replace(":", "_");
	        
	       test.addScreenCaptureFromBase64String(filePath,testName);
	         test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <====");
	      /*  try {
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            File des = new File("./screenshot/"+testName + "+"+time+".png");
	            FileUtils.copyFile(src, des);
	        } catch (IOException e) {
	            e.printStackTrace();
	    */   }
	 
	 

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//	report.flush();
	}
 
	  
	
	
	
	
	
}
