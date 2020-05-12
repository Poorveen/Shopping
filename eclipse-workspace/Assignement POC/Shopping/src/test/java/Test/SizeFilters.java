package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LaunchPage;
import resources.Base;


public class SizeFilters extends Base{
	
	@Test
	public void size() throws IOException, InterruptedException {
		driver =initializerDriver(driver);
		driver.get("https://react-shopping-cart-67954.firebaseapp.com");
		
		LaunchPage l = new LaunchPage(driver);
		
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
		 driver=null;
	}
	
}


