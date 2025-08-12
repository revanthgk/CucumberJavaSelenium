package com.ecom.stepdefinitions;


import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetProducts {
	RequestSpecification httpResponse;
	Response response;
	
	@Given("Set the base url")
	public void set_the_base_url() {
	   RestAssured.baseURI = "https://fakestoreapi.com/";
	}

	@When("I hit the get products list API")
	public void i_hit_the_get_products_list_api() {
		httpResponse = RestAssured.given();
	    response = httpResponse.get("products");
	}

	@Then("I expect to see the statuscode as {int}")
	public void i_expect_to_see_the_statuscode_as(Integer int1) {
		Assertions.assertEquals(response.getStatusCode(), 200);
	}
	
	@Then("I validate the rate of product {} as {}")
	public void i_validate_the_rate_of_product_number_as_product_price(String productId, String productPrice) {
		int prodId=Integer.parseInt(productId)-1;
	    JsonPath jsonPath = response.jsonPath();
	    String s = jsonPath.getJsonObject("rating["+prodId+"].rate").toString();
	    Assertions.assertEquals(s, productPrice);
	}
}
