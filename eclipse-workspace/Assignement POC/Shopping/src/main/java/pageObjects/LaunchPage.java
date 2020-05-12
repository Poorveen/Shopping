package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LaunchPage {
	public WebDriver driver;
	
	//size filters
	By xs = By.xpath("(//div[@class='filters']/div/label/span) [1]");
	By s  = By.xpath("(//div[@class='filters']/div/label/span) [2]");
	By m  = By.xpath("(//div[@class='filters']/div/label/span) [3]");
	By ml  = By.xpath("(//div[@class='filters']/div/label/span) [4]");
	By l  = By.xpath("(//div[@class='filters']/div/label/span) [5]");
	By xl  = By.xpath("(//div[@class='filters']/div/label/span) [6]");
	By xxl  = By.xpath("(//div[@class='filters']/div/label/span) [7]");
	
	public LaunchPage(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
	public WebElement getsizexs()
	{return driver.findElement(xs);
	}
	public WebElement getsizes() 
	{return driver.findElement(s);}
	
	public WebElement getsizem()
	{return driver.findElement(m);}
	
	public WebElement getsizeml()
	{return driver.findElement(ml);}
	
	public WebElement getsizel() 
	{return driver.findElement(l);}
	
	public WebElement getsizexl()
    {return driver.findElement(xl);}

	public WebElement getsizexxl()
	{return driver.findElement(xxl);}
		
	}
	

	

