package Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.Sizefilter;
import resources.Base;

//Verify that filtering functionality correctly filters product based on the filter applied
public class SizeFilters extends Base {

	@Test(priority = 1, groups = { "Demo" })
	public void size() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");

		Sizefilter l = new Sizefilter(driver);

		l.getsizexs().click();

		l.getsizes().click();

		l.getsizem().click();

		l.getsizeml().click();

		l.getsizel().click();

		l.getsizexl().click();

		l.getsizexxl().click();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
