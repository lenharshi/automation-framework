package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseTest  {
	
	protected WebDriver driver;
	protected Properties props;
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws Exception
	{
		loadConfig();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			 throw new IllegalArgumentException("Browser not supported: " + browser);
		}
		driver.manage().window().maximize();
		driver.get(props.getProperty("baseUrl"));
	}
	
	public void loadConfig() throws Exception
	{
		props=new Properties();
		try(InputStream in = getClass().getClassLoader().getResourceAsStream("Properties/Config.properties"))		
		{
			if(in==null)
			{
				throw new RuntimeException("No input data found:" +in);
			}
			props.load(in);
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
