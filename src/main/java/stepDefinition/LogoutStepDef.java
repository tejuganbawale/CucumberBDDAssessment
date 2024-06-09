package stepDefinition;

import com.pageObjects.*;
import stepDefinition.*;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDef 
{
	LoginPage loginObj = new LoginPage();
	ProductsPage productsObj = new ProductsPage();
	CartPage cartObj = new CartPage();
	CheckoutPage checkObj = new CheckoutPage();
	LogoutPage logoutObj = new LogoutPage();
	
	@When("I open menu list")
	public void i_open_menu_list() throws InterruptedException 
	{
		logoutObj.click_menu_icon();
	}

	@When("I click on logout option")
	public void i_click_on_logout_option() throws InterruptedException 
	{
		logoutObj.logout_account();
	}
}
