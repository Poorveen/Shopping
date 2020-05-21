package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

//Verify that all the text product name price is available

public class Productinfo extends Base {

	@BeforeTest
	public void initializerDriver() throws IOException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
	}

	@Test(priority = 1, groups = { "Demo" })
	public void productlist() {
		List<WebElement> productlist = driver.findElements(By.cssSelector("p.shelf-item__title"));

		ArrayList<String> allproductlist = new ArrayList<String>();

		for (int i = 0; i < productlist.size(); i++) {
			allproductlist.add(productlist.get(i).getText());
		}

		List<WebElement> pricelist = driver.findElements(By.cssSelector("div.val"));

		ArrayList<String> newpricelist = new ArrayList<String>();

		for (int i = 0; i < pricelist.size(); i++) {
			newpricelist.add(pricelist.get(i).getText());
		}
		System.out.println(allproductlist);

		System.out.println(newpricelist);
	}
	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
