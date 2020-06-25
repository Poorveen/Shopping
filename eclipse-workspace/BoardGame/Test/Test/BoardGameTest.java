package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.HomePage;
import resources.Base;

public class BoardGameTest extends Base{
	
	String MusthaveGames1 = "Gloomhaven";
	String MusthaveGames2 = "Arlecchino (2010)";
	String MusthaveGames3 = "C-Cross";
	String MusthaveGames4 = "Delta V";
	
	@BeforeTest
	public void initializerDriver() throws IOException {
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		

	}

	// Verify the title of the page
	@Test
	public void Titlename() throws IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("BoardGameGeek | Gaming Unplugged Since 2000", title);
		HomePage hp = new HomePage(driver);
		hp.getsignin_Button().click();
		hp.getusername().sendKeys(prop.getProperty("username"));
		hp.getpassword().sendKeys(prop.getProperty("password"));
		hp.getsignin_Button2().click();
		hp.getprofile_button().click();
		hp.getselect_collection().click();
		
		WebElement collectionTable =driver.findElement(By.xpath("//div[@class='legacy']"));
		int collectioncount = collectionTable.findElements(By.xpath("//div[@id='collection']//div[4]//td[1]")).size();
		
		for(int i=1;i<collectioncount;i++) {
			
			String value = collectionTable.findElement(By.xpath("(//div[@id='collection']//div[4]//td[1])["+i+"]")).getText();
			if(value.contains(MusthaveGames2)) {
				Assert.assertTrue(true);
			}
			}
		
		
			
			
	}
		
	}

