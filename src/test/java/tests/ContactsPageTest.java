package tests;

import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	HomePage hp;
	ContactsPage cp;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		cp = hp.clickOnContacts();
	}
	
	@Test(priority = 1)
	public void checkTitleTest() {
		String title = cp.checkTitle();
		String expectedTitle = "Free CRM Contact Us";
		Assert.assertEquals(title, expectedTitle,"title does not match");
	}
	
	@Test(priority = 2)
	public void checkCopyrightTextTest() {
		String copyrigthText = cp.checkCopyrightText();
		String expectedCopyrightText = "2022 © Free CRM";
		Assert.assertEquals(copyrigthText, expectedCopyrightText,"Copyright text does not match");
	}
	
	@Test(priority = 3)
	public void checkContactDetailsTest() {
		String contactText = cp.checkContactDetails();
		String expectedContactText = "Free CRM Contact Us\r\n"
				+ "3053 Filmore St. Ste. 299\r\n"
				+ "San Francisco, CA 94123\r\n"
				+ "By phone: 415-200-2844";
		Assert.assertEquals(contactText, expectedContactText,"Contact detail does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
