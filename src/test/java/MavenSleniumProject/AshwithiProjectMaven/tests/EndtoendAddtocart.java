package MavenSleniumProject.AshwithiProjectMaven.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoendAddtocart {

	public static void main(String[] args) throws InterruptedException {
		
		String productname="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/client");
		
		
		

		
		
		
		
		driver.findElement(By.id("userEmail")).sendKeys("ashwithik@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Danceash@21");
		driver.findElement(By.cssSelector(".login-btn")).click();		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
	WebElement producttext=products.stream().filter(product->product.findElement(By.cssSelector(".card-body h5")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
	producttext.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	Thread.sleep(5000);

	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
boolean match=cart.stream().anyMatch(c->c.getText().equalsIgnoreCase(productname));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".subtotal button")).click();
Actions a =new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".ta-results"))));

driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

//driver.findElement(By.cssSelector(".action__submit")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit"))).click();

String actual=driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(actual.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();







	
	
		
		
		
		

	}

}
