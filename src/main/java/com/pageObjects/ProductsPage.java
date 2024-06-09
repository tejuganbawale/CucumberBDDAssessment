package com.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.ProductsConst;

import support.Hooks;

public class ProductsPage extends LoginPage 
{
	public static WebDriver Pp_driver = LoginPage.lp_driver;
	public int displayed_products_count;
	String product_name;
	
	By login_page_header = By.xpath("//div[@class='login_logo']");
	By bag_name = By.id("item_4_title_link");
	By light_name = By.id("item_0_title_link");
	By bolt_tshirt_name = By.id("item_1_title_link");
	By jacket_name = By.id("item_5_title_link");
	By onesie_name = By.id("item_2_title_link");
	By red_shirt_name = By.id("item_3_title_link");
	
	By add_bag_button = By.id("add-to-cart-sauce-labs-backpack");
	By add_light_button = By.id("add-to-cart-sauce-labs-bike-light");
	By add_bolt_tshirt_button = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By add_jacket_button = By.id("add-to-cart-sauce-labs-fleece-jacket");
	By add_onesie_button = By.id("add-to-cart-sauce-labs-onesie");	
	By add_red_tshirt_button = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	
	By remove_bag_button = By.id("add-to-cart-sauce-labs-backpack");
	By remove_light_button = By.id("add-to-cart-sauce-labs-bike-light");
	By remove_bolt_tshirt_button = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By remove_jacket_button = By.id("add-to-cart-sauce-labs-fleece-jacket");
	By remove_onesie_button = By.id("add-to-cart-sauce-labs-onesie");	
	By remove_red_tshirt_button = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	
	By products_sorting_filter = By.xpath("//select[@class='product_sort_container']");
	
	By menu_burger_icon = By.id("react-burger-menu-btn");
	
	public void verify_displayed_product_names() throws InterruptedException
	{
		
	    for(int i=0; i<6; i++)
	    {
	    	product_name = Pp_driver.findElement(By.id("item_"+i+"_title_link")).getText();
    	    Thread.sleep(2000);
            System.out.println("Product displayed on listing: "+product_name);               
	    }
	}
	
	public void validate_displayed_product_names()
	{
		for(int i=0; i<6; i++)
	    {
	    	product_name = Pp_driver.findElement(By.id("item_"+i+"_title_link")).getText();
	    	for(int j=0; j<6; j++)
	    	{
	    		if(product_name == ProductsConst.PRODUCTS[j])
                {
                	System.out.println("Product displayed on listing: "+product_name);
                	displayed_products_count++;
                }
	    	}
	    }
		if(displayed_products_count > 0)
		{
			System.out.println(displayed_products_count + " products are displayed less than expecte total 6 products");
		}
		else
		{ System.out.println("All 6 products are displayed on listing page as expected"); }
	}
	
	
	
}
