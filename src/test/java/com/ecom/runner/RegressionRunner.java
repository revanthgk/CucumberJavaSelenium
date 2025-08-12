package com.ecom.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"com.ecom.stepdefinitions","com.ecom.hooks"},
	    tags = "@regression",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html",
	        "json:target/cucumber.json"
	    }
	)
public class RegressionRunner extends AbstractTestNGCucumberTests {
}
