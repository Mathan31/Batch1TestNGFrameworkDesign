package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import utilities.PropertiesReader;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void testCaseSetup() {
		excelFileName = "TC001";
		authors = "Sathya";
		category = "Smoke";
		testName = "Salesforce Login";
		testDescription = "Salesforce Login validation";
		module = "Login";
	}
	
		
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage(driver,node)
		.verifyLoginElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String userName,String password) {
		
		boolean result = new LoginPage(driver,node)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.verifyHomeElement()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage(driver,node)
		.enterUserName("sathya@systemz.com")
		.enterPassword("testing123")
		.clickLoginWithinvalidCredential()
		.validateErrorMsg();
		Assert.assertTrue(result);
	}
	
	

}
