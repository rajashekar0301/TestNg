package ecommerce.products.PO;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_login {
	
	WebDriver driver;
	public PO_login(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//locators
	
	@FindBy(how=How.XPATH,using = "//input[@type='email']")
	private WebElement user_email;
	@FindBy(how=How.ID,using = "Password")
	private WebElement password;
	@FindBy(how=How.XPATH,using = "//button[@type='submit']")
	private WebElement login;
	
	//methods
	
	public void Enter_emaiID(String email) 
	{
		
		user_email.clear();
		user_email.sendKeys(email);
		Reporter.log("Able to enter the user email", true);
	}
	
	public void Enter_password(String pwd) 
	{
		
		password.clear();
		password.sendKeys(pwd);
		Reporter.log("Able to enter the user password", true);
	}
	
	public void submit_login () 
	{
		login.click();
		Reporter.log("User is able to click on the login Button", true);
	}
	
	public void login_validation() 
	{
		String actual =driver.getTitle();
		String expected ="Dashboard / nopCommerce administration";
		Assert.assertEquals(actual, expected,"Not able to login by given credentials");
		Reporter.log("user successfully logged In", true);
	}
}
