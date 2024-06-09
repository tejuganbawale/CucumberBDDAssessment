package com.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Hooks;

public class LoginPage /* extends BasePage */ 
{
	public static WebDriver lp_driver;
	
	By login_page_header = By.xpath("//div[@class='login_logo']");
	By username_text = By.id("user-name");
	By password_text = By.id("password");
	By login_button = By.id("login-button");
	By product_listing_header = By.xpath("//span[@class='title']");
	By login_failure_error = By.xpath("//div[@class='error-message-container error']");		
	
	public LoginPage() { super(); }
	 
	
	/*public LoginPage(WebDriver driver) 	
	{
		super(driver);
		//LoginPage login_obj = new LoginPage();			
	}*/

	public void navigateToSauceDemoWebsite(WebDriver driver) 
	{
		    lp_driver = driver;
			driver.navigate().to("https://www.saucedemo.com/");
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			
    } 
	
	public String verifyLoginPageHeader() throws InterruptedException
	{
		Thread.sleep(1000);
		String actual_login_header = lp_driver.findElement(login_page_header).getText();
		return actual_login_header;
	}
	
	public LoginPage setUserName(String user_name) throws InterruptedException
	{
		lp_driver.findElement(username_text).click();
		Thread.sleep(1000);
		lp_driver.findElement(username_text).sendKeys(user_name);
		return this;
	}
	
	public LoginPage setPassword(String password) throws InterruptedException
	{
		lp_driver.findElement(password_text).click();
		Thread.sleep(1000);
		lp_driver.findElement(password_text).sendKeys(password);
		return this;
	}

	public LoginPage clickLoginButton() throws InterruptedException
	{
		lp_driver.findElement(login_button).click();
		Thread.sleep(2000);
		return this;
		
	}
	
	public String verifyProductsPageHeader() throws InterruptedException
	{
		Thread.sleep(1000);
		String actual_product_header = lp_driver.findElement(product_listing_header).getText().trim();
		return actual_product_header;
	}

	public String verifyLoginFailureErrorDisplayed() throws InterruptedException
	{
		Thread.sleep(1000);
		String actual_failure_error;
		
		actual_failure_error = lp_driver.findElement(login_failure_error).getText();
			
		return actual_failure_error;
	}
	
//public LoginPage DriverInitilize() {
//		return this;
//		
//	}

	


}
