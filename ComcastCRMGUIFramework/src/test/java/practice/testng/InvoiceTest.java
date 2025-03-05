package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTest {
  @Test(retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class)
  
  public void activateSim() {
	  System.out.println("execute createInvoicTest");
	  Assert.assertEquals("", "Login");
	  System.out.println("step-1");
  
  System.out.println("step-2");

System.out.println("step-3");
System.out.println("step-4");

  }
	
	
	
}
