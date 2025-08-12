package tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pages.LoginPage;


public class LoginTest extends baseTest{

	@Test
	public void testValidLogin() {
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.loginActions(props.getProperty("username"), props.getProperty("password"));
	    String url = loginPage.getTitleofBrowser();
	   
	    Assert.assertEquals(url,"OrangeHRM");
	}	    
	    
}
