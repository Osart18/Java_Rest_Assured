package com.unosquare;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileReader;

//import static io.restassured.RestAssured.*;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class PostLogin {
	
	public ApiCore
	apiCore;
	
	
	@Test	  
	  public void PostLogin() throws IOException, ParseException {
					
		Response response= apiCore.PostLogin(".\\Json\\Register.json","https://reqres.in/api/users/2");
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode,200);
		 Reporter.log("Sucess 200 validation");
		 response.then().body("data.email",equalTo("janet.weaver@reqres.in"));
		 Reporter.log(response.body().asString());

      }
	
	@BeforeSuite
	public void beforeSuite() {
		 apiCore = new ApiCore();
	} 	
	
	

}	


