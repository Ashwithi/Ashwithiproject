package MavenSleniumProject.AshwithiProjectMaven.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ashwithi.tests.BaseTest;
import Ashwithi_PageObjects.CartPagePageObject;
import Ashwithi_PageObjects.ProductCatalougePageObject;

public class ErrorValidations extends BaseTest {
@Test
public void submitlogin() throws IOException, InterruptedException {
		
		
	
		
	landing.loginApplication("ashwithisk@gmail.com", "Dansceash@21");
		Assert.assertEquals("Incorrect email or password.", landing.errormsgvalidation());
		
		
				
}
@Test
public void verifyproduct() throws IOException, InterruptedException {
	
	String productname="ZARA COAT 32";
	

	
	ProductCatalougePageObject productcatalouge=landing.loginApplication("tamanu@gmail.com", "Achu@1998");
			
	List<WebElement> products1 = productcatalouge.getproductlist();
	productcatalouge.addProductToCart(productname);
	CartPagePageObject cartpage=productcatalouge.goToCartPage();



boolean match=cartpage.Verifyproductdisplay(productname);
Assert.assertTrue(match);




	
	}
}

