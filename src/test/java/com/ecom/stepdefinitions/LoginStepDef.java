package com.ecom.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.ecom.factory.DriverFactory;
import com.ecom.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	LoginPage loginPage =new LoginPage(DriverFactory.getDriver());
	
	@Given("I Launch the Login Page")
	public void i_launch_the_login_page() {
	    DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("I enter the username {} and password {}")
	public void i_enter_the_username_and_password(String username, String passwrod) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(passwrod);
	}
	

	@When("I click the login button")
	public void i_click_the_login_button() {
	    loginPage.clickLoginButton();
	}

	@Then("I expect to see the home page")
	public void i_expect_to_see_the_home_page() {
	    Assertions.assertEquals(DriverFactory.getDriver().getTitle(),"OrangeHRM");
	}
}
