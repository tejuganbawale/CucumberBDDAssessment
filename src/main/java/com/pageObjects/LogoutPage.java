package com.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Hooks;

public class LogoutPage extends CheckoutPage
{
	public static WebDriver lo_driver = CheckoutPage.Cko_driver;
	
	By menu_burger_icon = By.id("react-burger-menu-btn");
	By logout_menu = By.id("logout_sidebar_link");
	
	public void click_menu_icon() throws InterruptedException
	{
		Cko_driver.findElement(menu_burger_icon).click();
		Thread.sleep(1000);		
	}
	
	 public void logout_account() throws InterruptedException
	 {
		 Cko_driver.findElement(logout_menu).click();
	     Thread.sleep(1000);	     
	 }
	
}
