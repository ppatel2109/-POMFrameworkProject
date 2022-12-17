package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class UserHomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Parth Patel')]")
	WebElement username;

	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement calendarBtn;

	@FindBy(xpath = "//span[contains(text(),'Contact')]")
	WebElement contactBtn;

	@FindBy(xpath = "//div[@id='main-nav']/div[3]/button")
	WebElement contactsAddBtn;

	@FindBy(xpath = "//div[@id='main-nav']/div[2]/button")
	WebElement calendarAddBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement category;
	
	@FindBy(xpath = "//div[starts-with(@class,'vertical-timeline')]//a[starts-with(@href,'/contact')]")
	List<WebElement> allContactsList;
	
	@FindBy(xpath = "//a[@href='/settings/billing/']")
	WebElement freeAcc;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactPageBtn;
	



	public UserHomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean usernameCheck(String name) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]")).isDisplayed();
	}

	public CreateUserContactPage clickOnCreateContactPage() throws InterruptedException {
		contactsAddBtn.click();
		return new CreateUserContactPage();
	}

	public void moveToContacts() {
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
	}

	public int allContactsListNumber() {
		return allContactsList.size();
	}
	
	public String freeAccountCheck() {
		return freeAcc.getText().toString();
	}
	
	public UserContactPage userContactPage() {
		contactBtn.click();
		return new UserContactPage();
	}

}
