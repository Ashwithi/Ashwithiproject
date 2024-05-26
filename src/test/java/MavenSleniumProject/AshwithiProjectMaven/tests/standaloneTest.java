package MavenSleniumProject.AshwithiProjectMaven.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ashwithi.tests.BaseTest;
import Ashwithi_PageObjects.CartPagePageObject;
import Ashwithi_PageObjects.CheckoutPageObject;
import Ashwithi_PageObjects.ConfirmationPageObject;
import Ashwithi_PageObjects.LandingPageObject;
import Ashwithi_PageObjects.ProductCatalougePageObject;
import Ashwithi_PageObjects.orderdisplay;
import ResusableAbstract.pageobject.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneTest extends BaseTest {
	
	String productname="ZARA COAT 3";
	
@Test(dataProvider="getdata",groups= {"purchase"})
public void submit(HashMap<String,String> input) throws IOException, InterruptedException {
		
	
		
	
		
		ProductCatalougePageObject productcatalouge=landing.loginApplication(input.get("username"),input.get("password"));
				
		List<WebElement> products1 = productcatalouge.getproductlist();
		productcatalouge.addProductToCart(input.get("product"));
		CartPagePageObject cartpage=productcatalouge.goToCartPage();

	
	
	boolean match=cartpage.Verifyproductdisplay(input.get("product"));
	Assert.assertTrue(match);
	CheckoutPageObject checkout=cartpage.GotoCheckout();
	checkout.checkout("india");
	ConfirmationPageObject confirm=checkout.submitorder();
	
String confirmmsge=confirm.confirmmessage();
	
	

Assert.assertTrue(confirmmsge.equalsIgnoreCase("THANKYOU FOR THE ORDER."));






		}
@Test(dependsOnMethods= {"submit"})
public void ordersubmit() throws InterruptedException {
	ProductCatalougePageObject productcatalouge=landing.loginApplication("ashwithik@gmail.com", "Danceash@21");
	
	orderdisplay orderpage=	productcatalouge.order();
  	Assert.assertTrue(orderpage.verifyorderdisplayed(productname));
	
	
	
	
}


@DataProvider
public Object[][]  getdata() {
	HashMap<String,String> map=new HashMap<String,String>();
	map.put("username", "ashwithi@gmail.com");
	map.put("password", "Dansceash@21");
	map.put("product", "ZARA COAT 32");
	

	
	HashMap<String,String> map1=new HashMap<String,String>();
	map.put("username", "tamanu@gmail.com");
	map.put("password", "Achu@1998");
	map.put("product", "ADIDAS ORIGINAL");
	
	return new Object[][] {{map},{map1}};

	
	
}	

//@DataProvider
//public Object[][]  getdata() {
//	return new Object[][] {{"ashwithi@gmail.com","Dansceash@21","ZARA COAT 32"},{"tamanu@gmail.com", "Achu@1998","ADIDAS ORIGINAL"}};
	
}



	
	


