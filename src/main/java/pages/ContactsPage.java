package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//h1[contains(text(),'Free CRM Contact Us')]")
	WebElement title;
	
	@FindBy(xpath = "//p[contains(text(),'©')]")
	WebElement copyrightText;
	
	@FindBy(xpath = "//section[@id='third']")
	WebElement contactDetails;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkTitle() {
		return title.getText().toString();
	}

	public String checkCopyrightText() {
		return copyrightText.getText().toString();
	}
	
	public String checkContactDetails() {
		return contactDetails.getText().toString();
	}

}
