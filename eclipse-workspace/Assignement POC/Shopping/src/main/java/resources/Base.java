package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

public static WebDriver driver;
	
	public Properties prop;
	public static String path = System.getProperty("user.dir");
	
public WebDriver initializerDriver(WebDriver driver) throws IOException {
	
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream( path+"\\src\\main\\java\\resources\\Data.properties");
	prop.load(fis);

	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	String url=prop.getProperty("url");
	System.out.println(url);	
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",path+"\\resources\\chromedriver.exe");
	
		driver =new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.firefox.driver",path+"\\resources\\geckodriver.exe");
		  driver = new FirefoxDriver();
	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.IE.driver",path+"\\resourcess\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	return driver; 
}
  public void getScreenshot(String result) throws IOException {
	 File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File(path+"\\screenshots\\"+result+"screenshot.png") );
  }
}

