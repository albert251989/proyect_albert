package SIEV.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import SIEV.helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	private By userNameField;
	private By userPassField;
	private By regionDrop;
	private By userTypeDrop;
	private By loginButton;
	private By invalidLoginAlert;
	private By userLoged;
	

	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userNameField = By.id("loginForm:txtUsr");
		userPassField = By.id("loginForm:txtPwd");
		regionDrop = By.id("loginForm:cmbRegion_input");
		userTypeDrop = By.id("loginForm:j_idt52_input");
		loginButton = By.id("loginForm:btnLog");
		invalidLoginAlert = By.xpath("/html/body/center[1]/div/div/ul/li");
		userLoged = By.id("encabezadoForm:j_idt21");
	}
	
	public void Login(String user,String password) {
		driver.findElement(userNameField).sendKeys(user);
		driver.findElement(userPassField).sendKeys(password);
		Select region = new Select(driver.findElement(regionDrop));
		region.selectByVisibleText(Helpers.LoginPageHelpers.REGION_VALUE);
		Select userType = new Select(driver.findElement(userTypeDrop));
		userType.selectByVisibleText(Helpers.LoginPageHelpers.USER_TYPE_VALUE);
	}
	
	public void assertWrongLogin() {
		Assert.assertTrue(!driver.findElement(userNameField).getAttribute("value").isEmpty());
		Assert.assertTrue(!driver.findElement(userPassField).getAttribute("value").isEmpty());
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(invalidLoginAlert).getText().contains("invalido"));
	}
	
	public void assertLogin() {
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(userLoged).getText().contains(Helpers.LoginPageHelpers.USER_VALUE));
	}
	
}
