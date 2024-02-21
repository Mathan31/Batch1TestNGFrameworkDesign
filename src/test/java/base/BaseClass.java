package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass {
	
	public  static WebDriver driver;
	public static String propFileName = "Environment";
	public  int iBrowserType = Integer.parseInt(PropertiesReader.getPropertyValue(propFileName, "Browser")); //1- chrome,2 - edge,3 - FF,4 - IE
	public String sURL = PropertiesReader.getPropertyValue(propFileName, "URL");
	public String excelFileName = "";
	
	@BeforeClass
	public  void invokeBrower() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : "+iBrowserType+", So invoking chrome browser.");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is : "+iBrowserType+", So invoking edge browser.");
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("User option is : "+iBrowserType+", So invoking FF browser.");
			driver = new FirefoxDriver();
			break;
		case 4:
			System.out.println("User option is : "+iBrowserType+", So invoking IE browser.");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("User option is wrong : "+iBrowserType+", So invoking the default chrome browser.");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@BeforeMethod
	public void navigateURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public  void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name = "TestCaseData")
	public Object[][] excelData(){
		Object[][] values = ExcelReader.getValueFromExcel(excelFileName);
		return values;
	}

}
