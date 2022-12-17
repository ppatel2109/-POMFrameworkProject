package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class UserContactPage extends TestBase {
	
	
	
	public UserContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkContact(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"));
	}
	
	public void contactDelete(String contactName) {
		driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]/../..//i[@class='trash icon']"));
	}
	

}
