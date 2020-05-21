package Test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import resources.Base;

//Validate that item removed from cart

public class RemoveItem extends Base {

	Homepage hp = new Homepage(driver);

	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
	}

	@Test(priority = 2, groups = { "Demo" })
	public void deleteitem() throws InterruptedException {
		List<WebElement> products = driver.findElements(By.cssSelector("p.shelf-item__title"));
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();

			if (name.contains("Skuul")) {
				driver.findElements(By.xpath("//div[text()='Add to cart']")).get(i).click();
			}

		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='shelf-item__del']")).click();

		String item = driver.findElement(By.xpath("//span[@class='bag__quantity']")).getText();

		Assert.assertEquals(item, "0");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
