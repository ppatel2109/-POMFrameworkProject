package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		lp = hp.clickOnLogin();
	}
	
	
	@Test(priority = 1)
	public void loginTest() {
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
