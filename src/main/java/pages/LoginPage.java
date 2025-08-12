package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.Utils;

public class LoginPage {

	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By userName = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//button[text()=' Login ']");
	
	
	
	
	public void enterUserName(String Name)
	{
		
		Utils.waitForElementVisible(driver, userName, 30);
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(Name);
	}
	public void enterPassWord(String pass)
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	public void clickLoginBtn()
	{
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(loginBtn)).click().perform();
		
	}
	
	public void loginActions(String Username,String Password)
	{
		
		enterUserName(Username);
		enterPassWord(Password);
		clickLoginBtn();
	}
	
	public String getTitleofBrowser()
	{
		String Title = driver.getTitle();
		return Title;
	}
	
}
