package practice.testng;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.crm.generic.basetest.BaseClass;



public class SampleInvoiceTest extends BaseClass {
    
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	
	
	@Test
	public void createInvoicewithContactTest() {
		
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	
}
