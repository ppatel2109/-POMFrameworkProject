package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CreateUserContactPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserContactPage;
import pages.UserHomePage;

public class UserContactPageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	CreateUserContactPage cp;
	UserHomePage uhp;
	UserContactPage ucp;
	
	
	public UserContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		lp = hp.clickOnLogin();
		uhp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		ucp=  uhp.userContactPage();
	}
	
	@Test(priority = 1)
	public void checkContactTest() {
		ucp.checkContact("ab cd");
	}
	
	@Test(priority = 2)
	public void deleteContactTest() {
		ucp.contactDelete("Abc Def");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
