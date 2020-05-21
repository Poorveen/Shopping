package Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.Base;

//Validate the total amount of products in cart is equal to checkout amount.

public class SumofProducts extends Base {
	float total = 0;

	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
	}

	@Test(priority = 1, groups="Demo")
	public void additem() throws InterruptedException {
		String[] itemsNeeded = { "Cat" };
		List<WebElement> products = driver.findElements(By.cssSelector("p.shelf-item__title"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split(" ");
			String shortName = name[0].trim();
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(shortName)) {
				driver.findElements(By.xpath("//div[text()='Add to cart']")).get(i).click();
			}
		}
		{
			List<WebElement> shelfproducts = driver.findElements(By.xpath("(//div[@class='shelf-item__price']/p)"));
			for (int i = 0; i < shelfproducts.size(); i++) {
				String checkoutprice = shelfproducts.get(i).getText();
				String str = checkoutprice;
				String newchecoutprice = str.replace("$", "");
				float l = Float.parseFloat(newchecoutprice);
				total = total + l;
			}

		}

		String finalamount = driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText();
		String str = finalamount;
		String newfinalamount = str.replace("$", "");
		float finalcheckoutamt = Float.parseFloat(newfinalamount);
		
		Assert.assertEquals(total, finalcheckoutamt, 0);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
