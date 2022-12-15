package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SignupPage extends TestBase {
	
	@FindBy(id = "terms")
	WebElement termsCheckbox;
	
	@FindBy(xpath = "//li[contains(text(),'Email is required')]")
	WebElement emailError;
	
	@FindBy(id = "email")
	WebElement emailBox;
	
	@FindBy(xpath = "//input[@class='search']")
	WebElement countryDropdown;
	
	@FindBy(xpath = "//div[contains(text(),'Canada')]")
	WebElement country;
	
	@FindBy (id = "phone_number")
	WebElement phoneBox;
	
	@FindBy(id = "recaptcha-anchor")
	WebElement recaptchaCheckbox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signupBtn;
	
	@FindBy(xpath = "//div[@class='menu transition visible']/div")
	List<WebElement> countryListCount;
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String emailError() {
		return emailError.getText().toString();
	}
	
	public VerifyEmailPage verifyEmail(String email, String number, String country) {
		emailBox.sendKeys(email);
		countryDropdown.click();
		driver.findElement(By.xpath("//div[contains(text(),'"+country+"')]")).click();
		phoneBox.sendKeys(number);
		signupBtn.click();
		return new VerifyEmailPage();
	}
	
	public void clickOnSignup() {
		signupBtn.click();
	}
	
	public int countryCount() {
		country.click();
		return countryListCount.size();
	}

}
