package Ashwithi.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Ashwithi_PageObjects.LandingPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPageObject landing;
	
	
	public WebDriver initializedriver() throws IOException {
	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\AshwithiProjectMaven\\src\\main\\java\\ashwithi\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String browsername=prop.getProperty("Browser");
	if(browsername.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	
	
	else if(browsername.equalsIgnoreCase("edge")) {
		
		
	}
	
	else if(browsername.equalsIgnoreCase("firefox")) {
		System.setProperty("driver.edge.driver","path");
		driver=new EdgeDriver();
		
	}
	
		
	
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPageObject initializebrowser() throws IOException {
		driver=initializedriver();
landing=new LandingPageObject(driver);
		landing.goTo();
		return landing;
		
		
		
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	
	public void teardown() {
		driver.close();
	}
	

}
