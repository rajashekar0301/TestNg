package ecommerce.products.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BrowserManager {
	
	public static WebDriver getDriver(String Browser_Type,String URL)
	{
		WebDriver driver = null;
		if (Browser_Type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver =new ChromeDriver();
		}else if (Browser_Type.equalsIgnoreCase("Firefox")) {
			driver =new FirefoxDriver();
		}else {
			Assert.assertTrue(false, "No Browser Type Passed");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(URL);
		Reporter.log("Navigte to Browser as :" +Browser_Type+"URL:"+URL, true);
		return driver;
	}
	
	

}
