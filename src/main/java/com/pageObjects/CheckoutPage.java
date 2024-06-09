package com.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Hooks;

public class CheckoutPage extends CartPage
{
	public static WebDriver Cko_driver = CartPage.Cp_driver;
	
		By first_name_text_field = By.id("first-name");
		By last_name_text_field = By.id("last-name");
		By postal_code_text_field = By.id("postal-code");
		By continue_button = By.id("continue");
		By cancel_button = By.id("cancel");
		
		By total_bill_amount_label = By.className("summary_total_label");
		By finish_button = By.id("finish");
		By order_placed_label = By.className("complete-header");
		By back_to_home_button = By.id("back-to-products");
		
		public void enter_user_details_for_chekout(String f_name, String l_name, String zip_code) throws InterruptedException
		{
			Cko_driver.findElement(cart_icon).click();
			Thread.sleep(1000);
			
			Cko_driver.findElement(checkout_button).click();
			Thread.sleep(1000);
			
			Cko_driver.findElement(first_name_text_field).click();
			Thread.sleep(1000);
			Cko_driver.findElement(first_name_text_field).sendKeys(f_name);
			Thread.sleep(1000);
			Cko_driver.findElement(last_name_text_field).click();
			Thread.sleep(1000);
			Cko_driver.findElement(last_name_text_field).sendKeys(l_name);
			Thread.sleep(1000);
			Cko_driver.findElement(postal_code_text_field).click();
			Thread.sleep(1000);
			Cko_driver.findElement(postal_code_text_field).sendKeys(zip_code);
			Thread.sleep(1000);		
		    
			Cko_driver.findElement(continue_button).click();
			Thread.sleep(3000);
		}
		
		public String verify_billing_details() throws InterruptedException
		{
			String billing_amnt = Cko_driver.findElement(total_bill_amount_label).getText().trim();
			return billing_amnt;
		}
		
		public String confirm_current_order() throws InterruptedException
		{
			Cko_driver.findElement(finish_button).click();
			Thread.sleep(1000);	
			
			String confirmation_message = Cko_driver.findElement(order_placed_label).getText().trim();
			
			Cko_driver.findElement(back_to_home_button).click();
			Thread.sleep(1000);	
			
			return confirmation_message;
		}
		
}
		

