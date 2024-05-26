package Ashwithi_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResusableAbstract.pageobject.AbstractComponent;

public class CartPagePageObject extends AbstractComponent{
	WebDriver driver;

	public CartPagePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
@FindBy(css=".cartSection h3")
List<WebElement> productlist;


@FindBy(css=".subtotal button")
WebElement checkout;



public boolean Verifyproductdisplay(String productname) {
	
	
boolean match=productlist.stream().anyMatch(c->c.getText().equalsIgnoreCase(productname));
return match;

}

public CheckoutPageObject GotoCheckout() {
	checkout.click();
	
	CheckoutPageObject checkout=new CheckoutPageObject(driver);
	return checkout;
}


}