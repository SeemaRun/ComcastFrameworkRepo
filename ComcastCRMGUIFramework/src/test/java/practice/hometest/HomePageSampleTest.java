package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
    @Test
    public void homePageTest(Method mtd) {
    	
    	System.out.println(mtd.getName() + "Test Start");
    	System.out.println("step-1");
    	System.out.println("step-2");
    	Assert.assertEquals("Home","Home");
    	System.out.println("step-3");
    	Assert.assertEquals("Home-CRM","Home-CRM");
    	System.out.println("step-4");
    	System.out.println(mtd.getName() + "Test End");
    	
    	
    }
    @Test
    public void verifyLogoHomePageTest(Method mtd) {
	
    System.out.println(mtd.getName() + "Test Start");
    SoftAssert assertObj = new   SoftAssert ();
    System.out.println("step-1");
    System.out.println("step-1");
    assertObj.assertTrue(true);
    System.out.println("step-3");
    System.out.println("step-4");
	
	
    System.out.println(mtd.getName() + "Test End");
	
	
	
	
}
}
