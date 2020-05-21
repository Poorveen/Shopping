package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

//Verify that all the sort options work correctly 
public class SortHighesttoLowest extends Base {

	String name;

	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
	}

	@Test(priority = 1, groups = { "Demo" })
	public void highestsort() throws InterruptedException {

		List<WebElement> products = driver.findElements(By.cssSelector("div.val"));

		ArrayList<String> originalpricelist = new ArrayList<String>();

		for (int i = 0; i < products.size(); i++) {
			originalpricelist.add(products.get(i).getText());
		}
		ArrayList<String> copyoriginalpricelist = new ArrayList<String>();
		for (int i = 0; i < originalpricelist.size(); i++) {
			copyoriginalpricelist.add(originalpricelist.get(i));

		}
		String str = Arrays.toString(copyoriginalpricelist.toArray());
		String newchecoutprice = str.replace("$", "");
		//System.out.println("newchecoutprice" + newchecoutprice);

		if (!originalpricelist.equals(copyoriginalpricelist)) {
			Thread.sleep(2000);
			WebElement mySelectElement = driver.findElement(By.xpath("//div[@class='sort']//select"));
			Select dropdown = new Select(mySelectElement);
			dropdown.selectByVisibleText("Highest to lowest");
		}

		List<WebElement> product2 = driver.findElements(By.cssSelector("div.val"));
		ArrayList<String> newpricelist = new ArrayList<String>();
		for (int k = 0; k < product2.size(); k++) {
			newpricelist.add(product2.get(k).getText());
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
