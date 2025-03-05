package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganisationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.crm.generic.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrgTestNgTest extends BaseClass {

	@Test(groups ="smokeTest")

	public void createorgTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
   UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read testscript data from Excel file

		String ORGNAME1 = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		// Step2 : navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org Page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: click on "create organization" button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4:enter all the details & create new organisation
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(ORGNAME1);
		UtilityClassObject.getTest().log(Status.INFO,ORGNAME1 + "===Create a new Org");
		Thread.sleep(2000);
		// verify Header msg Expected result
		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(ORGNAME1)) {
			System.out.println(ORGNAME1 + "name is verified ==pass");
		} else {
			System.out.println(ORGNAME1 + "name is not verified == Fail");
		}

	}

	// second Testcase
	@Test(groups ="regressionTest")
	public void CreateOrganizationWithIndustriesTest()
			throws EncryptedDocumentException, IOException, InterruptedException {

		// read testscript data from Excel file

		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		// Step2 : navigate to organization module

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: click on "create organization" button

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: enter all the details & create new organisation

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// select dropdown for Industry
		CreatingNewOrganizationPage ciop = new CreatingNewOrganizationPage(driver);
		ciop.getIndustryDB();

		// select dropdown for type
		CreatingNewOrganizationPage cTop = new CreatingNewOrganizationPage(driver);
		cTop.getTypeDB();
		Thread.sleep(2000);
		// verify the industry and type info
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustries.equals(industry)) {
			System.out.println(industry + "information is verified==pass");
		} else {
			System.out.println(industry + "information is not verified==fail");
		}
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + "information is verified==pass");
		} else {
			System.out.println(type + "information is not verified==fail");
		}

		// verify Header msg Expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(headerinfo + " is created==Pass");
		} else {
			System.out.println(headerinfo + "is not created==FAIL");

		}
		// verify Header orgname info Expected Result
		String actorgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actorgName.equals(orgName)) {
			System.out.println(actorgName + " Information is created==Pass");
		} else {
			System.out.println(actorgName + "Information is not created==FAIL");
		}
	}

	// THIRD TEST SCRIPT
	@Test(groups ="regressionTest")
	public void CreateOrgWithPhoneNumberTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// read testscript data from Excel file
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("org", 7, 3);

		// Step2 : navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: click on "create organization" button

		OrganizationsPage cnip = new OrganizationsPage(driver);
		cnip.getCreateNewOrgBtn().click();

		// Step 4: enter all the details & create new organisation
		CreatingNewOrganizationPage cnap = new CreatingNewOrganizationPage(driver);
		cnap.createOrg(orgName);

		// select phoneNumber
		CreatingNewOrganizationPage cnpp = new CreatingNewOrganizationPage(driver);
		cnpp.getPhonetextfield();
		Thread.sleep(2000);

		// verify Header msg Expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(headerinfo + " is created==Pass");
		} else {
			System.out.println(headerinfo + "is not created==FAIL");

		}
		Thread.sleep(2000);
		// verify phoneNumber
		String actualphoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actualphoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber + " Information is created==Pass");
		} else {
			System.out.println(phoneNumber + " Information is not created==Fail");

		}

	}

}
