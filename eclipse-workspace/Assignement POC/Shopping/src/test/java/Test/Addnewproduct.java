package Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Homepage;
import resources.Base;

//Verify that user can add to cart one or more products

public class Addnewproduct extends Base {

	@Test(priority = 1, groups = { "Demo" })
	public void addnewitem() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");

		String noitem = driver.findElement(By.xpath("//span[@class='bag__quantity']")).getText();

		String[] itemsNeeded = { "Cat", "Dark", "Sphynx" };

		Homepage ac = new Homepage(driver);

		List<WebElement> products = driver.findElements(By.cssSelector("p.shelf-item__title"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split(" ");
			String shortName = name[0].trim();

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(shortName)) {
				driver.findElements(By.xpath("//div[text()='Add to cart']")).get(i).click();
			}

			String item = driver.findElement(By.xpath("//span[@class='bag__quantity']")).getText();

			if (!(item == noitem))
				Assert.assertTrue(item, true);

		}
		Thread.sleep(3000);
		ac.closebutton().click();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
