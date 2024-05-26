package Ashwithi_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResusableAbstract.pageobject.AbstractComponent;

public class orderdisplay extends AbstractComponent{
	WebDriver driver;

	public orderdisplay(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

@FindBy(xpath="//tr/td[2]")
List<WebElement> verifyorderdispayed;


	



public boolean verifyorderdisplayed(String productname) {
	
boolean match=	verifyorderdispayed.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
return match;

	
	
}



}



