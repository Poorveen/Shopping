package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.Base;

//Verify that all the sort options work correctly

public class SortLowesttoHighest extends Base {

	String name;

	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
	}

	@Test(priority = 1, groups="Demo")
	public void lowsort() throws InterruptedException {
		Thread.sleep(10000);
		List<WebElement> products = driver.findElements(By.cssSelector("div.val"));

		ArrayList<String> originalprice = new ArrayList<String>();

		for (int i = 0; i < products.size(); i++) {
			originalprice.add(products.get(i).getText());
		}

		ArrayList<String> copyoriginalprice = new ArrayList<String>();
		for (int i = 0; i < originalprice.size(); i++) {
			copyoriginalprice.add(originalprice.get(i));
		}

		if (!originalprice.equals(copyoriginalprice)) {
			WebElement mySelectElement = driver.findElement(By.xpath("//div[@class='sort']//select"));
			Select dropdown = new Select(mySelectElement);
			dropdown.selectByVisibleText("Lowest to highest");
			Thread.sleep(10000);
		}
		List<WebElement> product2 = driver.findElements(By.cssSelector("div.val"));
		ArrayList<String> newprice = new ArrayList<String>();
		for (int k = 0; k < product2.size(); k++) {
			newprice.add(product2.get(k).getText());
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
