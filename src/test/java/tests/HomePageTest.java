package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

	
	HomePage hp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		hp = new HomePage();
	}
	
	@Test(priority = 1)
	public void verifySiteLogoTest() {
		Assert.assertEquals(hp.checkLogo(),true,"Logo Not Found");
	}
	
	@Test(priority = 2)
	public void verifySiteIconTest() {
		Assert.assertEquals(hp.checkIcon(),true,"Icon Not Found");
	}
	
	@Test(priority = 3)
	public void verifyHeaderTextTest() {
		String headerText = hp.headerText();
		String expectedText = "CRM with Free calling and auto dialing features";
		Assert.assertEquals(headerText,expectedText,"Header does not match");
	}
	
	@Test(priority = 4)
	public void verifyService1Title1TextTest() {
		String service1Title1 = hp.services1Title1();
		String expectedText = "Free and CRM";
		Assert.assertEquals(service1Title1,expectedText,"Service 1 Title 1 does not match");
	}
	
	@Test(priority = 5)
	public void verifyService1Title2TextTest() {
		String service1Title2 = hp.services1Title2();
		String expectedText = "FREE CRM CLICK TO CALL";
		Assert.assertEquals(service1Title2,expectedText,"Service 1 Title 2 does not match");
	}
	
	@Test(priority = 6)
	public void verifyService1DescTextTest() {
		String service1Desc = hp.services1Desc();
		String expectedText = "Using Free crm, you can click to call your contacts and leads and burn thru your prospecting. With integrated calling to any US number our voip crm automates and speeds up your calling in CRM.";
		Assert.assertEquals(service1Desc,expectedText,"Service 1 Desc does not match");
	}
	
	@Test(priority = 7)
	public void verifyServicesListSizeTest() {
		int size = hp.serviceListCount();
		int expectedSize = 4;
		Assert.assertEquals(size,expectedSize,"List size does not match");
	}
	
	
	@Test(priority = 8)
	public void loginTest() throws InterruptedException {
		hp.clickOnLogin();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
