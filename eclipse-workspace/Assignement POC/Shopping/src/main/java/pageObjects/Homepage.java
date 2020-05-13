package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	
	public WebDriver driver;
	
	By AddCart = By.xpath("//div[text()='Add to cart']");
	By checkout = By.xpath("//div[@class='buy-btn']");
	By closebutton=By.xpath("//div[@class='float-cart__close-btn']");
	By Oderbysort= By.xpath("//div[@class='sort']//select");
	
	
	   public Homepage(WebDriver driver){
		 this.driver = driver;
	} 
	
		public WebElement getAddcart() {
			return driver.findElement(AddCart);
		}
		
		public WebElement getcheckout() 
		{
			return driver.findElement(checkout);
		}
		
		public WebElement closebutton() 
		{
			return driver.findElement(closebutton);
		}
		public WebElement Oderbysort() 
		{
			return driver.findElement(Oderbysort);
		}
	}



