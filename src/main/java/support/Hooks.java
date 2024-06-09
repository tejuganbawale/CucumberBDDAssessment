package support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.pageObjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{
	public static WebDriver chrome_driver;
	LoginPage lp = new LoginPage();

   @Before
   public void setup()
   {
	   System.out.println("************ Launching the browser *************");
		      
	   System.setProperty("webdriver.chrome.driver","D:\\Selenium Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
	   
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--incognito");
	   chrome_driver = new ChromeDriver(options);
	   
	   lp.navigateToSauceDemoWebsite(chrome_driver);
	   
	}

   
   @After
   public void tearDown()
   {	   
	   //chrome_driver.close(); 
	   //chrome_driver.quit();
		
	   System.out.println("************** Closing the browser ***************");
   }
}
