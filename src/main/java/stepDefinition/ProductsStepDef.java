package stepDefinition;

import com.pageObjects.*;
import stepDefinition.*;
import com.constants.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductsStepDef  
{
	LoginPage login_test = new LoginPage();
	ProductsPage productsObj = new ProductsPage();
	
	@Given("I log into Sauce Labs website successfully")
	public void i_log_into_sauce_labs_website_successfully() throws InterruptedException
	{
		login_test.setUserName(LoginConst.valid_username);
		login_test.setPassword(LoginConst.valid_password);
		System.out.println("Valid username and password are entered");
		login_test.clickLoginButton();
		System.out.println("Login button is clicked");
		Thread.sleep(3000);
	}

	@When("I verify names of products on products listing page")
	public void i_verify_names_of_products_on_products_listing_page() throws InterruptedException
	{
		productsObj.verify_displayed_product_names();
		Thread.sleep(3000);
	}

	@Then("I validate products names match with expected names")
	public void i_validate_products_names_match_with_expected_names() throws InterruptedException
	{
		productsObj.validate_displayed_product_names();
		Thread.sleep(3000);
	}

}
