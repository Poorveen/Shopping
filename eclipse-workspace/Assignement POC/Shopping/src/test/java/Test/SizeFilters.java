package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Sizefilter;
import resources.Base;

//Verify that filtering functionality correctly filters product based on the filter applied
public class SizeFilters extends Base {

	Sizefilter l = new Sizefilter(driver);
	Homepage hp = new Homepage(driver);

	@BeforeClass
	public void size() throws IOException, InterruptedException {
		driver = initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
	}

	@Test
	public void sizeXS() throws InterruptedException {
		Sizefilter l = new Sizefilter(driver);
		Homepage hp = new Homepage(driver);
		l.getsizexs().click();
		Thread.sleep(3000);
		String product = hp.product().getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		Assert.assertEquals("1", sizecount);
		l.getsizexs().click();
	}

	@Test(dependsOnMethods = { "sizeXS" })
	public void sizeS() throws InterruptedException {
		Sizefilter l = new Sizefilter(driver);
		Homepage hp = new Homepage(driver);
		l.getsizes().click();
		Thread.sleep(3000);
		String product = hp.product().getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		Assert.assertEquals("2", sizecount);
		l.getsizes().click();
	}

	@Test(dependsOnMethods = { "sizeS" })
	public void sizeM() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[3]")).click();
		Thread.sleep(3000);
		String product = driver.findElement(By.xpath("//small[@class='products-found']/span")).getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		Assert.assertEquals("1", sizecount);
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[3]")).click();

	}

	@Test(dependsOnMethods = { "sizeM" })
	public void sizeML() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[4]")).click();
		Thread.sleep(3000);
		String product = driver.findElement(By.xpath("//small[@class='products-found']/span")).getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		Assert.assertEquals("0", sizecount);
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[4]")).click();

	}

	@Test(dependsOnMethods = { "sizeML" })
	public void sizeL() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[5]")).click();
		Thread.sleep(3000);
		String product = driver.findElement(By.xpath("//small[@class='products-found']/span")).getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		Assert.assertEquals("10", sizecount);
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[5]")).click();

	}

	@Test(dependsOnMethods = { "sizeL" })
	public void sizeXL() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[6]")).click();
		Thread.sleep(3000);
		String product = driver.findElement(By.xpath("//small[@class='products-found']/span")).getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[6]")).click();
		Assert.assertEquals("10", sizecount);

	}

	@Test(dependsOnMethods = { "sizeXL" })
	public void sizeXXL() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[7]")).click();
		Thread.sleep(3000);
		String product = driver.findElement(By.xpath("//small[@class='products-found']/span")).getText();
		String[] name = product.split(" ");
		String sizecount = name[0].trim();
		Assert.assertEquals("4", sizecount);
		driver.findElement(By.xpath("(//span[@class='checkmark'][1])[7]")).click();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
