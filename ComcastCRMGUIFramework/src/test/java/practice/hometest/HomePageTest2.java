package practice.hometest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest2 {
        
	@Test
    public void homePageTest(Method mtd) {
    	
    	System.out.println(mtd.getName() + "Test Start");
    	SoftAssert assertObj  = new SoftAssert();
    	System.out.println("step-1");
    	System.out.println("step-2");
    	assertObj.assertEquals("Home","Homepage"); //change actual and expected conditon
    	System.out.println("step-3");
    	assertObj.assertEquals("Home-CRM","Home-CRM");
    	System.out.println("step-4");
    	assertObj.assertAll();
    	System.out.println(mtd.getName() + "Test End");
    	
    	
    }
    @Test
    public void verifyLogoHomePageTest(Method mtd) {
	
    System.out.println(mtd.getName() + "Test Start");
    SoftAssert assertObj = new SoftAssert();
    System.out.println("step-1");
    System.out.println("step-1");
    assertObj.assertTrue(true);
    System.out.println("step-3");
    System.out.println("step-4");
    assertObj.assertAll();;
	
    System.out.println(mtd.getName() + "Test End");
	

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
