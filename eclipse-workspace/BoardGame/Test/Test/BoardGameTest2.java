package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import main.HomePage;
import resources.Base;

public class BoardGameTest2 extends Base {

	String[] MendatoryGames = { "Gloomhaven", "Arlecchino (2010)", "C-Cross", "Delta V" };

	@BeforeTest
	public void initializerDriver() throws IOException {
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));

	}

	// Verify the title of the page
	@Test
	public void Titlename() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getsignin_Button().click();
		hp.getusername().sendKeys(prop.getProperty("username"));
		hp.getpassword().sendKeys(prop.getProperty("password"));
		hp.getsignin_Button2().click();
		hp.getprofile_button().click();
		hp.getselect_collection().click();
		
		List<WebElement> collectionTitles=driver.findElements(By.xpath("(//div[@id='collection']//div[4]//td[1]//a)"));
		for (int i = 0; i < collectionTitles.size(); i++) {
			String[] name = collectionTitles.get(i).getText().split(" ");
			String MusthaveGames = name[0].trim();
			List<String> collectionList = Arrays.asList(MendatoryGames);
			if (collectionList.contains(MusthaveGames)){
				Assert.assertTrue(true);
						}
				}
		
		Actions actions = new Actions(driver);
		WebElement elementLocator =driver.findElement(By.xpath("(//div[@id='collection']//div[4]//td[1]//a)[1]"));	
		actions.doubleClick(elementLocator).perform();
		hp.getGraph().click();
		
		//td[3]
		List<WebElement> s= driver.findElements(By.xpath("//td[3]"));
		
		for (int i = 0; i < s.size()-1; i++) {
			String name = s.get(i).getText();
			String str[] = name.split(",");
			List<String> al = new ArrayList<String>();
			al = Arrays.asList(str);
			for(String a: al)
				System.out.println(a);
			
			Collections.sort(al);
			System.out.println(al);
			
			
	}	

	}}
