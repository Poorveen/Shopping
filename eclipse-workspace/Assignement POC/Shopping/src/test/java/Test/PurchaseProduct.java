package Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.Base;

//Verify that user can successfully buy more than one products that were added to his/her cart

public class PurchaseProduct extends Base {
	@Test(priority = 2)
	public void productadd() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");

		Homepage hp = new Homepage(driver);

		List<WebElement> products = driver.findElements(By.cssSelector("p.shelf-item__title"));
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();

			if (name.contains("Skuul")) {
				driver.findElements(By.xpath("//div[text()='Add to cart']")).get(i).click();
			}

		}
		hp.getcheckout().click();
		driver.switchTo().alert().accept();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
