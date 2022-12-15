package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.CustomersPage;
import pages.HomePage;

public class CustomersPageTest extends TestBase {

	HomePage hp;
	CustomersPage cp;

	public CustomersPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		cp = hp.clickOnCustomers();
	}

	@Test(priority = 1)
	public void checkCustomersListTest() {
		int actualNumber = cp.checkCustomerList();
		int expectedNumber = 6;
		Assert.assertEquals(actualNumber, expectedNumber, "Customers list size does not match");
	}

	@Test(priority = 2)
	public void checkTitleTest() {
		String actualTitle = cp.checkTitle();
		String expectedTitle = "Free CRM Customers";
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
	}

	@Test(priority = 3)
	public void checkDescTest() {
		String actualDesc = cp.checkDesc();
		String expectedDesc = "Free CRM Customers\r\n"
				+ "Here are some of the companies and organizations worldwide using Free CRM to do more for less. We've been in business since 2003 and are one of the world's leading CRM providers. Our job is to keep your data safe and available to you anytime and we've been doing that for over 19 years.";
		Assert.assertEquals(actualDesc, expectedDesc, "Description does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
