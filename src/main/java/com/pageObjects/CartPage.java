package com.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.constants.ProductsConst;

import support.Hooks;

public class CartPage extends ProductsPage
{
	public static WebDriver Cp_driver = LoginPage.lp_driver;
	
	By cart_icon = By.xpath("//a[@class='shopping_cart_link']");
	By continue_shopping_button = By.id("continue-shopping");
	By checkout_button = By.id("checkout");
	
	//use of tables
	public void add_products_to_cart(String selected_product) throws InterruptedException
	{
		for(int i=0; i<6; i++)
	    {
	    	String prod_name = Cp_driver.findElement(By.id("item_"+i+"_title_link")).getText().trim();
	    	//System.out.println("given product:"+selected_product+":actual product:"+prod_name+":");
	    		
	    	if(prod_name.equals(selected_product))
                {
	    			//Cp_driver.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")) .click();
	    		switch(prod_name) 
	    		{
	    		  case "Sauce Labs Backpack":
	    			  Cp_driver.findElement(add_bag_button).click();
	    		      break;
	    		  case "Sauce Labs Bike Light":
	    			  Cp_driver.findElement(add_light_button).click();
		    		  break;
	    		  case "Sauce Labs Bolt T-Shirt":
	    			  Cp_driver.findElement(add_bolt_tshirt_button).click();
		    		    break;
	    		  case "Sauce Labs Fleece Jacket":
	    			  Cp_driver.findElement(add_jacket_button).click();
		    		    break;
	    		  case "Sauce Labs Onesie":
	    			  Cp_driver.findElement(add_onesie_button).click();
		    		    break;
	    		  case "Test.allTheThings() T-Shirt (Red)":
	    			  Cp_driver.findElement(add_red_tshirt_button).click();
	    			  break;
	    		  default:
	    			  System.out.println("Provided product is not found on Products listing page");
	    		}
	    		    
	    		    Thread.sleep(3000);
                	System.out.println("Provided product "+ selected_product +" exists on product listing and is added to the cart");               	
                }	    	
	    }	
	}
	
	
	public void verify_products_in_cart(String selected_product) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)Cp_driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		Cp_driver.findElement(cart_icon).click();
		Thread.sleep(1000);
		List<WebElement> links = Cp_driver.findElements(By.className("inventory_item_price"));
	    System.out.println("The size of items list is " + links.size());

        for(int i=1; i<=links.size(); i++)
	    {
	    	String item_name_in_cart = Cp_driver.findElement(By.xpath("(//div[@class='inventory_item_name'])["+i+"]")).getText();
	    	
	    	
	    	if(selected_product.equals(item_name_in_cart))
	    	{
	    		System.out.println("Product at position "+ i +" is "+item_name_in_cart+ " as expected");
	    	}
			
	    }

	}
	
}
