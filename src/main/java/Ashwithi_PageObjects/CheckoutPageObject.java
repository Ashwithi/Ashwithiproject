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

import ResusableAbstract.pageobject.AbstractComponent;

public class CheckoutPageObject extends AbstractComponent{
	WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(css="[placeholder='Select Country']")
WebElement selectcountry;

@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
WebElement select;

@FindBy(css=".action__submit")
WebElement submit;
By submit1=By.cssSelector(".action__submit");
By wait=By.cssSelector(".ta-results");	

	public void checkout(String country) throws InterruptedException {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(4000);
		
		Actions a =new Actions(driver);
		a.sendKeys(selectcountry,country).build().perform();
		 waitforelementtoappear(wait);
		 Thread.sleep(3000);
		 select.click();
		 
	
	}
	
	public ConfirmationPageObject submitorder() {
		
		 waitforelementtoappear(submit1);
		 submit.click();
		 ConfirmationPageObject confirmpage=new ConfirmationPageObject(driver);
		 return confirmpage;
	}

}








