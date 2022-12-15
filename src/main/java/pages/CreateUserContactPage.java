package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreateUserContactPage extends TestBase {

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='category' and @role='listbox']")
	WebElement category;
	
	@FindBy(xpath = "	//span[contains(text(),'Affiliate')]")
	WebElement catElement;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;
	

	public CreateUserContactPage() throws InterruptedException {
		PageFactory.initElements(driver, this);
	}
	

	
	
	public void createNewContact(String fName, String lName, String cat, String desc) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		category.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+cat+"')]")).click();
		description.sendKeys(desc);
		saveBtn.click();
	}

}
