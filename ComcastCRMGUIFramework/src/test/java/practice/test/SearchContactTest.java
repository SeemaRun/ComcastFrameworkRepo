package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.crm.generic.basetest.BaseClass;

/**
 * test class for Contact module
 *  @author Seema
 */

public class SearchContactTest extends BaseClass {
	/**
	 * Scenario : login()==> navigateContact==>createcontact() ==verify
	 */
	@Test
	public void searchContactTest() {
		/*Step 1 : login to app*/

		 
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username","pass");
		
	}

}
