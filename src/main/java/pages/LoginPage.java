package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	// page factory or object repo(OR)

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[contains(@class,'submit button')]")
	WebElement loginBtn;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasswordBtn;

	@FindBy(linkText = "Sign Up")
	WebElement signupBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public UserHomePage login(String username, String pwd) {
		email.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new UserHomePage();
	}

}
