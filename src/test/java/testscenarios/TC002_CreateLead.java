package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC002_CreateLead extends BaseClass{
	
	@BeforeTest
	public void testCaseSetup() {
		excelFileName = "TC002";
		authors = "Yalini";
		category = "Sanity";
		testName = "Create Lead";
		testDescription = "Create Lead using mandatory fields";
		module = "Create lead";
	}
	
			
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String userName,String password) {
		boolean result = new LoginPage(driver,node)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(FakerDataFactory.getLastName())
		.enterCompanyName(FakerDataFactory.getCompanyName())
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElement();
		Assert.assertTrue(result);
		
		
	}
	
	
}
