package stepDefinition;

import com.pageObjects.*;
import stepDefinition.*;

import java.util.List;
import java.util.Map;

import com.pageObjects.CartPage;
import com.pageObjects.LoginPage;
import com.pageObjects.ProductsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutStepDef 
{
	LoginPage loginObj = new LoginPage();
	ProductsPage productsObj = new ProductsPage();
	CartPage cartObj = new CartPage();
	CheckoutPage checkObj = new CheckoutPage();
	
	List<Map<String, String>> credsList;
	
	@When("I enter following user details in checkout process")
	public void i_enter_following_user_details_in_checkout_process(io.cucumber.datatable.DataTable credsTable) throws InterruptedException
	{
		credsList = credsTable.asMaps(String.class, String.class);
		   
		   for(Map<String, String> cred : credsList)
		   {
			   checkObj.enter_user_details_for_chekout(cred.get("FirstName"), cred.get("LastName"), cred.get("PostalCode"));
		   }
	}

	@When("I verify billing details")
	public void i_verify_billing_details() throws InterruptedException
	{
		String payable_amount = checkObj.verify_billing_details();
		System.out.println("Total amount to be paid: "+payable_amount);
	}

	@Then("I confirm the placed order")
	public void i_confirm_the_placed_order() throws InterruptedException 
	{
		String order_completion_message = checkObj.confirm_current_order();
		System.out.println("Current order status is: " + order_completion_message);
	}

}
