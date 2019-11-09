package SIEV.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SIEV.common.Constants;
import SIEV.helpers.Helpers;
import SIEV.pages.PageLogin;

public class Tests {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void init() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty(Constants.driverKey,Constants.driverValue);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Constants.endPoint);
		Helpers.threadSleep(5);
	}
	
	@Test
	public void LoginFailTest() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login(Helpers.LoginPageHelpers.WRONG_USER_VALUE, Helpers.LoginPageHelpers.WRONG_PASS_VALUE);
		pageLogin.assertWrongLogin();
	}
	
	@Test
	public void LoginOkTest() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login(Helpers.LoginPageHelpers.USER_VALUE, Helpers.LoginPageHelpers.PASS_VALUE);
		pageLogin.assertLogin();
	}
	
	@AfterMethod
	public void endTest() {
		driver.close();
	}
	
}
