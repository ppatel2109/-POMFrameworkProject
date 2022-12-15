package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.UserHomePage;

public class UserHomePageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	UserHomePage uhp;
	
	public UserHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		lp = hp.clickOnLogin();
		uhp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void checkUserNameTest() {
		Assert.assertTrue(uhp.usernameCheck("Parth Patel"), "username is not same");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
