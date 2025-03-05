package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.crm.generic.basetest.BaseClass;

public class CreateContactTestNgTest extends BaseClass {
	
	
	@Test(groups ="smokeTest")
	public void createContactTest() throws IOException {
		// TODO Auto-generated method stub

		/* read testscript data from excel file*/

		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		/* Create POM class objects
		
		 Step2 : navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		/* Step 3: click on "create contact" button*/
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		/* Step 4: enter all the details & create new contact*/
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.getContactLastNameField().sendKeys(lastName);

		/* clcik on save button*/

		ccp.getSavebutton().click();

		/* verify Header pclass="dvHeaderText" info Expected Result*/
		String actHeader = cp.getHeaderMsg().getText();
		/*Hard ASSERT because mandatory field*/
		boolean status =  actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		/*verify lastname after save ,here we use softassert bec field are not mandatory(lastname)*/
		String actLatName = driver.findElement(By.id("dtlview_Last Name")).getText();
        SoftAssert soft = new  SoftAssert();
        soft.assertEquals( actLatName, lastName);
        soft.assertAll();
	}
	
	
   /* Second TestScript*/
	@Test(groups ="regressionTest")
	public void CreateContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		/* read testscript data from Excel file and random number*/

		String ORGNAME1 = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact", 7, 3);

		/* Step2 : navigate to organization module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* Step 3: click on "create organization" button*/
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		/* Step 4: enter all the details & create new organization*/
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(ORGNAME1);
		Thread.sleep(5000);
		/* verify Header ornName into Expected result*/
		String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       System.out.println(actOrgName);
		if (actOrgName.contains(ORGNAME1)) {
			System.out.println(ORGNAME1 + " information is created==Pass");
		} else {
		System.out.println(ORGNAME1 + " information is not created==FAIL");

		}

		Thread.sleep(5000);
		/* Step 5: navigate to contact module*/
	   hp.getContactlink().click();
		

		/* Step 6: click on "create CONTACT" button*/
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		/* Step 7: enter all the details & create new CONTACT*/
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactwithOrg(contactLastName, ORGNAME1);

	/* verify Header orgName info Expected Result contact*/
		Thread.sleep(2000);
	   String 	HeaderContactText  = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (HeaderContactText.contains(contactLastName)) {
		System.out.println(contactLastName + " information is created==Pass");
		} else {
			System.out.println(contactLastName + " information is not created==FAIL");

		}
		
		String 	ActOrgName  = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		if (ActOrgName.trim().equals(ORGNAME1)) {
		System.out.println(ORGNAME1 + " informat is created==Pass");
		} else {
			System.out.println(ORGNAME1 + " informat is not created==FAIL");

		}
		

	}

	  /*Third TestScript*/
	@Test(groups ="regressionTest")
	public void CreateContactWithSupportDateTest() throws EncryptedDocumentException, IOException, InterruptedException {
		/* read testscript data from Excel file*/

		String LastName = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();

		/* navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		/* click on "create Contact" button*/
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		/* Step 4: enter all the details & create new organisation
		 date and time*/

		String startDate = jlib.getSystemDateYYYYDDMM();

		/* Calendar*/

		String endDate = jlib.getRequiredDateTYYYYDDMM(30);
		Thread.sleep(5000);

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(LastName, startDate ,endDate );
		Thread.sleep(5000);
		/* verify StartDate*/
		String actualStartDate = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
		if (actualStartDate.contains(startDate)) {
			System.out.println(startDate + " is created==Pass");
		} else {
			System.out.println(startDate + "is not created==FAIL");

		}

		/* verify enddate*/
		String actendDate = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
		if (actendDate.equals(endDate)) {
			System.out.println(endDate + "Information is created==Pass");

		} else {
			System.out.println(endDate + "Information is not created==Fail");

		}

	}

}
