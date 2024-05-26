package Ashwithi_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResusableAbstract.pageobject.AbstractComponent;

public class ProductCatalougePageObject extends AbstractComponent{
	WebDriver driver;

	public ProductCatalougePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
    By wait=By.cssSelector(".mb-3");
By addtocartbutton =By.cssSelector(".card-body button:last-of-type");

public List<WebElement> getproductlist() {
	
	waitforelementtoappear(wait);
	return products;
}

public WebElement GetproductByname(String productname) {
	
WebElement prod=	getproductlist().stream().filter(product->product.findElement(By.cssSelector(".card-body h5")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
	
	return prod;
	
}

public void addProductToCart(String productname) throws InterruptedException {
	Thread.sleep(6000);

	WebElement prod1=GetproductByname(productname);
	
	prod1.findElement(addtocartbutton).click();
	
	

}








}