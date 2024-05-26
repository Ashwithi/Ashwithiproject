package Ashwithi_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResusableAbstract.pageobject.AbstractComponent;

public class LandingPageObject extends AbstractComponent{
	WebDriver driver;
	public LandingPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
@FindBy(id="userEmail")
WebElement email;
@FindBy(id="userPassword")
WebElement password;
@FindBy(css=".login-btn")
WebElement login;
@FindBy(css="[class*='flyInOut']")
WebElement Errormessage;
By wait3=By.cssSelector("[class*='flyInOut']");


public ProductCatalougePageObject loginApplication(String email1,String password1) throws InterruptedException {
	Thread.sleep(6000);
	email.sendKeys(email1);
	password.sendKeys(password1);
	//Thread.sleep(4000);
	login.click();
	//Thread.sleep(5000);
	ProductCatalougePageObject productcatalouge=new ProductCatalougePageObject(driver);
	return productcatalouge;
}

public void goTo() {
	driver.get("https://rahulshettyacademy.com/client");
}

public String errormsgvalidation() {


	
	waitforelementtoappear(wait3);
	
	
	return Errormessage.getText();
	
	
}



}
