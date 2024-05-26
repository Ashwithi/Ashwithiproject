package Ashwithi_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ResusableAbstract.pageobject.AbstractComponent;

public class ConfirmationPageObject extends AbstractComponent{
	WebDriver driver;

	public ConfirmationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css=".hero-primary")
WebElement confirmationmsg;

By wait2=By.cssSelector(".hero-primary");


	
	
	
	
	


	public String confirmmessage() throws InterruptedException {
		waitforelementtoappear(wait2);
		Thread.sleep(4000);
		return confirmationmsg.getText();
		
		
		
	}
	

	
	
	
	
	
	
}