package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

	private WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By adminLinkBtn = By.xpath("//a[contains(@href,'admin')]"); 
	private By addBtn = By.xpath("//button[text()=' Add ']");
	private By selectRole = By.xpath("//label[contains(text(),'User Role')]//parent::div//following-sibling::div//div//div//div[contains(text(),'ESS')]");
	private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
}
