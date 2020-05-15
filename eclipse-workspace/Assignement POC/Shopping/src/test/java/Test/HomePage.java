package Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import resources.Base;

//Verify the title of the page

public class HomePage extends Base {

	@BeforeTest
	public void initializerDriver() throws IOException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");

	}

	@Test(priority = 3)
	public void Titlename() {
		String title = driver.getTitle();
		Assert.assertEquals("React Shopping Cart", title);
		System.out.println(title);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
