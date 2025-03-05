package com.comcast.crm.genericwebdriverutility;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	//testobject
	public static ThreadLocal<ExtentTest> test  = new ThreadLocal<ExtentTest>();
	//webdriver object
	public static ThreadLocal<WebDriver> driver  = new ThreadLocal<WebDriver>();
	//getters method
	public static ExtentTest getTest() {
		return test.get();
	}
	//settters for test object
	public static void  setTest (ExtentTest actTest) {
		 test.set(actTest);
	}
	//gettter setter for webdriver 
	public static WebDriver getDriver() {
		return driver.get();
	}
	//settters for test object
	public static void  setDriver (WebDriver actDriver) {
		 driver.set(actDriver);
	}
}
