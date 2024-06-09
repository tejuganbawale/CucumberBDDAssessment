package stepDefinition;

import com.pageObjects.*;
import stepDefinition.*;

//import com.beust.jcommander.internal.Maps;
import com.constants.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import org.testng.Assert;


public class CartStepDef 
{
	LoginPage loginObj = new LoginPage();
	ProductsPage productsObj = new ProductsPage();
	CartPage cartObj = new CartPage();
	String chosen_product;
	List<List<String>> productList;
	
	
	@When("I add following products to cart")
	public void i_add_following_products_to_cart(io.cucumber.datatable.DataTable productTable)  throws InterruptedException
	{	   
	   productList = productTable.asLists(String.class);
   
	   for(List<String> prod : productList)
	   {
		   System.out.println("Input product name: " + prod.get(0).trim());
		   cartObj.add_products_to_cart(prod.get(0));
	   }
	}

	@Then("I validate desired products are present in cart")
	public void i_validate_desired_products_are_present_in_cart() throws InterruptedException
	{
		for(List<String> prod : productList)
		   {
			   System.out.println("Input product name: " + prod.get(0).trim());
			   cartObj.verify_products_in_cart(prod.get(0));
		   }
		//System.out.println("Products are present in the cart");
	}
	
	

}
