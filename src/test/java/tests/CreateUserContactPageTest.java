package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CreateUserContactPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserHomePage;
import utils.TestUtil;

public class CreateUserContactPageTest extends TestBase {

	HomePage hp;
	LoginPage lp;
	CreateUserContactPage cp;
	UserHomePage uhp;
	String FILENAME = "C:\\QA\\Selenium_Workspace\\POMFrameworkProject\\src\\main\\java\\testdata\\POMExcel.xlsx";
	String sheetName = "Sheet1";
	

	public CreateUserContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		hp = new HomePage();
		lp = hp.clickOnLogin();
		uhp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		uhp.moveToContacts();
		Thread.sleep(2000);
		cp = uhp.clickOnCreateContactPage();

	}

	@Test(priority = 1)
	public void createContactTest() {
		cp.createNewContact("Parth", "Patel", "Lead", "dcbjaCBakj akscj oieuf98weuf clkzx");
	}
	
	@DataProvider
	public Object[][] getTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getTestData")
	public void createMultipleContact(String fName, String lName, String cat, String desc) throws InterruptedException {
		uhp.clickOnCreateContactPage();
		cp.createNewContact(fName, lName, cat, desc);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
