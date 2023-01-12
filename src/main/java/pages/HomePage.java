package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(css = "img[alt*='Free CRM Logo']")
	WebElement mainLogo;

	@FindBy(xpath =  "//span[contains(text(),'Log In')]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;

	@FindBy(linkText = "Pricing")
	WebElement pricingBtn;

	@FindBy(linkText = "Features")
	WebElement featuresBtn;

	@FindBy(linkText = "Customers")
	WebElement customersBtn;

	@FindBy(linkText = "Contact")
	WebElement contactBtn;

	@FindBy(css = "img[alt='cogmento small logo']")
	WebElement icon;

	@FindBy(xpath = "//h1[@class='txt-white']")
	WebElement headerText;

	@FindBy(xpath = "//p[@class='offset-top-22']/a")
	List<WebElement> servicesList;
	
	@FindBy(xpath = "//i[@class='fa fa-users skrollable skrollable-after']")
	WebElement services1Icon;

	@FindBy(xpath = "//h5[contains(text(),'Service')]")
	WebElement services1Title1;

	@FindBy(xpath = "//h5[contains(text(),'Sell')]")
	WebElement services1Title2;

	@FindBy(xpath = "//p[contains(text(),\"Convert leads into accounts faster with the world'\")]")
	WebElement services1Desc;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean checkLogo() {
		return mainLogo.isDisplayed();
	}

	public LoginPage clickOnLogin() throws InterruptedException {
		Thread.sleep(2000);
		loginBtn.click();
		return new LoginPage();

	}

	public SignupPage clickOnSignUp() throws InterruptedException {
		Thread.sleep(2000);
		signupBtn.click();
		return new SignupPage();

	}


	public ContactsPage clickOnContacts() throws InterruptedException {
		Thread.sleep(2000);
		contactBtn.click();
		return new ContactsPage();

	}


	public CustomersPage clickOnCustomers() throws InterruptedException {
		Thread.sleep(2000);
		customersBtn.click();
		return new CustomersPage();
	}
	
	public boolean checkIcon() {
		return icon.isDisplayed();
	}
	
	public boolean checkService1Icon() {
		return services1Icon.isDisplayed();
	}
	
	public String headerText() {
		return headerText.getText().toString();
	}
	
	public int serviceListCount() {
		return servicesList.size();
	}
	
	public String services1Title1() {
		return services1Title1.getText().toString();
	}
	
	public String services1Title2() {
		return services1Title2.getText().toString();
	}
	
	public String services1Desc() {
		return services1Desc.getText().toString();
	}
	
	
}
