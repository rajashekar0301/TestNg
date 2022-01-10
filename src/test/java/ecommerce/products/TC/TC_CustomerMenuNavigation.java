package ecommerce.products.TC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ecommerce.products.PO.PO_CustomersPage;
import ecommerce.products.PO.PO_login;
import ecommerce.products.Utils.BrowserManager;

public class TC_CustomerMenuNavigation {
	
	
	@Test
	@Parameters({"browser","url"})
	public void TC_CustomerMenu(String browser ,String url )
	{
		WebDriver driver;
		driver =BrowserManager.getDriver(browser,url);
		PO_login obj =PageFactory.initElements(driver, PO_login.class);
		obj.Enter_emaiID("admin@yourstore.com");
		obj.Enter_password("admin");
		obj.submit_login();
		obj.login_validation();
		PO_CustomersPage obj1=PageFactory.initElements(driver, PO_CustomersPage.class);
		obj1.customerMenu();
		
	}

}
