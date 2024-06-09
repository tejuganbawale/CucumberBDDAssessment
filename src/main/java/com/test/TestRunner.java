package com.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "Features/Logout.feature"  //"Features/AddToCart.feature"
  ,glue = {"stepDefinition", "support"} 
  ,plugin = {"pretty",
		      "json:target/MyReports/report.json",
				"junit:target/MyReports/report.xml"
		      /*
			   * , "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
			   */
		    }
  ,publish=true
  )

public class TestRunner {}