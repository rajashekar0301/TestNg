package ecommerce.products.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class PO_CustomersPage {
	
	
	WebDriver driver;

	public PO_CustomersPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Locators
	@FindBy(how=How.XPATH,using = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customersMenu;
	
	//Methods
	
	public void customerMenu()
	{
		customersMenu.click();
		Reporter.log("Able to navigate Customers menu",true);
	}
	
	
	

}
