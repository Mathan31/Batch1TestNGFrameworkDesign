package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import libraries.SeleniumWrapper;


public class LoginPage extends MenuPage{
	
	private By usernameTxt=By.id("username");
	private By passwordTxt=By.id("password");
	private By loginBtn=By.id("Login");
	private By remembermeChBox=By.xpath("//label[text()='Remember me']");
	private By forgotLink=By.id("forgot_password_link");
	private By loginFailureMsg = By.cssSelector("#error");
	private WebDriver driver;
	private SeleniumWrapper wrap;
    
    public LoginPage(WebDriver driver,ExtentTest node) {
    	super(driver,node);
    	this.driver = driver;
    	this.node = node;
    	wrap = new SeleniumWrapper(driver, node);
    }
	
	public boolean verifyLoginElement() {
		if(wrap.verifyDisplayedwithReturn(driver.findElement(usernameTxt), "UserName") && 
				wrap.verifyDisplayedwithReturn(driver.findElement(passwordTxt), "Password") && 
				wrap.verifyDisplayedwithReturn(driver.findElement(loginBtn), "Login Button") && 
				wrap.verifyDisplayedwithReturn(driver.findElement(remembermeChBox), "Remember Check Box") && 
				wrap.verifyDisplayedwithReturn(driver.findElement(forgotLink), "Forgot Link") ) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String userName) {
		wrap.type(driver.findElement(usernameTxt), userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		wrap.type(driver.findElement(passwordTxt), password);
		return this;
	}
	
	public HomePage clickLogin() {
		wrap.click(driver.findElement(loginBtn), "Login Button");
		return new HomePage(driver,node);
	}
	
	public LoginPage clickLoginWithinvalidCredential() {
		wrap.click(driver.findElement(loginBtn), "Login Button");
		return this;
	}
	
	public boolean validateErrorMsg() {
		
		if(wrap.verifyDisplayedwithReturn(driver.findElement(loginFailureMsg), "Login failure msg")) {
			return true;
		}else {
			return false;
		}
	}
	
}
