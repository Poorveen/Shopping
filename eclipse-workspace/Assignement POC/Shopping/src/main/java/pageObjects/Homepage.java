package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	public WebDriver driver;

	By AddCart = By.xpath("//div[text()='Add to cart']");
	By checkout = By.xpath("//div[@class='buy-btn']");
	By closebutton = By.xpath("//div[@class='float-cart__close-btn']");
	By Oderbysort = By.xpath("//div[@class='sort']//select");
	By addquantity = By.xpath("//button[contains(text(),'+')]");
	By cart = By.xpath("//span[@class='bag bag--float-cart-closed']");
	By removeitem = By.xpath("//div[@class='shelf-item__del']");
	By product = By.xpath("//small[@class='products-found']/span");

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getremoveitem() {
		return driver.findElement(removeitem);
	}

	public WebElement getAddcart() {
		return driver.findElement(AddCart);
	}

	public WebElement getcheckout() {
		return driver.findElement(checkout);
	}

	public WebElement closebutton() {
		return driver.findElement(closebutton);
	}

	public WebElement Oderbysort() {
		return driver.findElement(Oderbysort);
	}

	public WebElement getaddquantity() {
		return driver.findElement(addquantity);
	}

	public WebElement getcart() {
		return driver.findElement(cart);
		
	}
	public WebElement product() {
		return driver.findElement(product);
	}
}
