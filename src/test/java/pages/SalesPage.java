package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import libraries.SeleniumWrapper;


public class SalesPage extends MenuPage{
	
	
	private By leadsLink = By.xpath("//span[text()='Leads']");
	private By newBtn=By.xpath("//div[text()='New']");
	private By lastnameTxt=By.xpath("//input[@name='lastName']");
	private By companyTxt=By.xpath("//input[@name='Company']");
	//private By leadStatusBtn=By.xpath("//button[@data-value='Open - Not Contacted']");
	private By leadStatusBtn=By.xpath("//label[contains(text(),'Lead Status')]/following-sibling::div");
	
	private By statusTxt=By.xpath("//span[@title='Working - Contacted']");
	private By savebtn=By.xpath("//button[@name='SaveEdit']");
	private WebDriver driver;
	private SeleniumWrapper wrap;
    
    public SalesPage(WebDriver driver,ExtentTest node) {
    	super(driver,node);
    	this.driver = driver;
    	this.node = node;
    	wrap = new SeleniumWrapper(driver, node);
    }
    
	public SalesPage clickOnLeadsLink() {
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		oWait.until(ExpectedConditions.elementToBeClickable(leadsLink));
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(leadsLink)).click().perform();
		//driver.findElement(leadsLink).click();
		return this;
	}
	
	public SalesPage clickOnNewButton() {
		wrap.click(driver.findElement(newBtn), "New Button");
		return this;
	}
	
	public SalesPage enterLastName(String lastName) {
		wrap.type(driver.findElement(lastnameTxt), lastName);
		return this;
	}
	
	public SalesPage enterCompanyName(String companyName) {
		wrap.type(driver.findElement(companyTxt), companyName);
		return this;
	}
	
	public SalesPage clickAndSelectLeadStatus() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@name='NumberOfEmployees']"))).perform();
		try {
		Thread.sleep(3000);
		driver.findElement(leadStatusBtn).click();
		driver.findElement(statusTxt).click();
		Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
		
	public SalesPage clickOnSaveButton() {
		wrap.click(driver.findElement(savebtn), "Save Button");
		return this;
	} 
	
	

}
