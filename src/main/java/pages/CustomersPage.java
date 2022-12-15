package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CustomersPage extends TestBase{
	
	@FindBy(xpath = "//section[@id='fourth']//img")
	List<WebElement> customersList;
	
	@FindBy(xpath = "//h1[contains(text(),'Free CRM Customers')]")
	WebElement title;
	
	@FindBy(xpath = "//*[contains(text(),'Free CRM Customers')]/..")
	WebElement desc;
	
	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}

	
	public int checkCustomerList() {
		return customersList.size();
	}
	
	public String checkTitle() {
		return title.getText().toString();
	} 
	
	public String checkDesc() {
		return desc.getText().toString();
	} 
	
	
}
