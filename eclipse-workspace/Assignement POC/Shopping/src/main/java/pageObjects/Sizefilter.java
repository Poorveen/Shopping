package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class Sizefilter {
	public WebDriver driver;
	
	//size filters
	By xs = By.xpath("(//div[@class='filters']/div/label/span) [1]");
	By s  = By.xpath("(//div[@class='filters']/div/label/span) [2]");
	By m  = By.xpath("(//div[@class='filters']/div/label/span) [3]");
	By ml = By.xpath("(//div[@class='filters']/div/label/span) [4]");
	By l  = By.xpath("(//div[@class='filters']/div/label/span) [5]");
	By xl = By.xpath("(//div[@class='filters']/div/label/span) [6]");
	By xxl= By.xpath("(//div[@class='filters']/div/label/span) [7]");
	
	public Sizefilter(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
	public WebElement getsizexs()
	{return driver.findElement(xs);
	}
	public boolean xsisselected()
	{return driver.findElement(xs).isEnabled();
	}
	
	public WebElement getsizes() 
	{return driver.findElement(s);}
	
	public String sisselected(String name)
	{return driver.findElement(s).getAttribute(name);
	}
	
	public WebElement getsizem()
	{
		return driver.findElement(m);
		}
	
	public WebElement getsizeml()
	{return driver.findElement(ml);}
	
	public WebElement getsizel() 
	{return driver.findElement(l);}
	
	public WebElement getsizexl()
    {return driver.findElement(xl);}

	public WebElement getsizexxl()
	{return driver.findElement(xxl);}
		
	}
	

	

