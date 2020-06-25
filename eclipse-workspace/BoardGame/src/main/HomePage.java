package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	//// button[contains(text(),'Sign In')]

	WebDriver driver;

	private By signin_Button = By.xpath("//button[contains(text(),'Sign In')]");
	private By username = By.xpath("//input[@id='inputUsername']");
	private By password = By.xpath("//input[@id='inputPassword']");
			By signin_Button2 = By.xpath("//button[contains(@class,'btn btn-primary')]");
			By profile_button = By.xpath("//span[@class='hidden-sm hidden-xs ng-binding']");
			By select_collection=By.xpath("//a[contains(text(),'Collection')]");
			By Titles=By.xpath("//div[@id='collection']//div[4]//td[1]");
			By Graph=By.xpath("//button[@class='btn btn-xs btn-empty feature-action-icon']//span[@class='glyphicon glyphicon-stats']");
			
			
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getsignin_Button() {
		return driver.findElement(signin_Button);
	}

	public WebElement getusername() {
		return driver.findElement(username);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement getsignin_Button2() {
		return driver.findElement(signin_Button2);
	}
	
	public WebElement getprofile_button() {
		return driver.findElement(profile_button);
	}
	public WebElement getselect_collection() {
		return driver.findElement(select_collection);
	}
	public WebElement getTitles() {
		return driver.findElement(Titles);
	}
	public WebElement getGraph() {
		return driver.findElement(Graph);
	}


}
