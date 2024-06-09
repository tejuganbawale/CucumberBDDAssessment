package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import com.pageObjects.*;
import com.constants.*;

public class LoginStepDef 
{
	LoginPage login_test = new LoginPage();
	
	@Given("I go to on saucedemo website")
	public void i_go_to_on_saucedemo_website() throws InterruptedException 
	{
	    
	    String actual_header = login_test.verifyLoginPageHeader();
	    System.out.println("Actual login header: "+ actual_header);
	    
	    if(actual_header.equals(LoginConst.expected_login_header))
	    {
	    	System.out.println("User is on saucedemo website as header is verified.");
	    }
	    
	}

	@When("Valid username and password are entered")
	public void valid_username_and_password_are_entered() throws InterruptedException 
	{
		login_test.setUserName(LoginConst.valid_username);
		login_test.setPassword(LoginConst.valid_password);
		System.out.println("Valid username and password are entered");
	   
	}

	@When("Login button is clicked")
	public void login_button_is_clicked() throws InterruptedException 
	{
		login_test.clickLoginButton();
		System.out.println("Login button is clicked");
	    
	}

	@Then("I land on products listing page")
	public void i_land_on_products_listing_page() throws InterruptedException 
	{
		String displayed_header = login_test.verifyProductsPageHeader();
		System.out.println("Displayed proucts header: "+ displayed_header);
		System.out.println("Expected proucts header: "+ LoginConst.expected_products_header);
		
		if(displayed_header == LoginConst.expected_products_header)
		{
			Assert.assertEquals(displayed_header,
					LoginConst.expected_products_header/* , "Products listing page header not matching" */);
		  System.out.println("I land on products listing page");
		}
		else
		{ //System.out.println("Products listing page header not matching"); 
			
		}
	    
	}

	@When("Invalid username and password are entered")
	public void invalid_username_and_password_are_entered() throws InterruptedException 
	{
		login_test.setUserName(LoginConst.invalid_username);
		login_test.setPassword(LoginConst.invalid_password);
		System.out.println("Invalid username and password are entered");
	    
	}

	@Then("Error displayed for failed login")
	public void error_displayed_for_failed_login() throws InterruptedException
	{
		String displayed_error = login_test.verifyLoginFailureErrorDisplayed();
		System.out.println("Error displayed for failed login: " + displayed_error);
		System.out.println("Expected failed login error: "+ LoginConst.expected_login_error);
	    
		if(displayed_error.equals(LoginConst.expected_login_error))
		{
			Assert.assertEquals(displayed_error, LoginConst.expected_login_error/* , "Login failure error message is not as per expectation" */);
		  System.out.println("Login has failed");
		}
		else
		{ 
			System.out.println("Login failure error message is not as per expectation"); 
		}
	
	}
}
