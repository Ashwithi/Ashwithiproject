package ResusableAbstract.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ashwithi_PageObjects.CartPagePageObject;
import Ashwithi_PageObjects.orderdisplay;



public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement addtocart;
	@FindBy(css="button[routerlink*='myorders']")
	WebElement order;
	public void waitforelementtoappear(By findBy) {
		
		
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//tr/td[2]	 wait.until(ExpectedConditions.visibilityOfElementLocated((findBy)));
		//tr/td[2]

	}
	public void waitforinvisible(WebElement ele) {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf((ele)));
	}
	
	public CartPagePageObject  goToCartPage() throws InterruptedException {
		Thread.sleep(4000);
		addtocart.click();
		CartPagePageObject  cartpage=new CartPagePageObject (driver);
		return cartpage;
	}
	
	public orderdisplay order() {
		order.click();
		
		orderdisplay dipay=new orderdisplay(driver);
		return dipay;
		
	}
	
	

}
