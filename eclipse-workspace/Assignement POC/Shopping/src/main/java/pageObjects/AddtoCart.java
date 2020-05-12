package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddtoCart {
	
	public WebDriver driver;
	
	By AddCart = By.xpath("//div[text()='Add to cart']");
	By checkout = By.xpath("//div[@class='buy-btn']");
	
	public AddtoCart(WebDriver driver) 
		{
		this.driver = driver;
		}
		public WebElement getAddcart() {
			return driver.findElement(AddCart);
		}
		
		public WebElement getcheckout() 
		{
			return driver.findElement(checkout);
		}
	}



