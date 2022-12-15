package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

public class SignupPageTest extends TestBase {
	
	SignupPage sp;
	HomePage hp;

	public SignupPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		sp = hp.clickOnSignUp();
	}
	
	@Test(priority = 1)
	public void checkErrorTest() {
		sp.clickOnSignup();
		Assert.assertEquals(sp.emailError(), "[[Email is required]]","email error does not match");
	}
	
	@Test(priority = 2)
	public void signupTest() {
		sp.verifyEmail("ancandcn@email.com", "5487776545", "India");
	}
	
	@Test(priority =3)
	public void countryCountTest() {
		Assert.assertEquals(sp.countryCount(), 250,"Country count does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
