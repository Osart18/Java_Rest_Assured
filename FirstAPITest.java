package com.unosquare;


import org.testng.Assert;


import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers;


import static org.hamcrest.core.IsEqual.*;



import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given; 


              
public class FirstAPITest {
  @Test
  public void f() {
	    RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");
		
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode,200);
		Reporter.log("Sucess 200 validation");
		
		response.then().body("data.id",equalTo(2));
		Reporter.log(response.body().asString());
		
		response.then().body("data.email",equalTo("janet.weaver@reqres.in"));
		Reporter.log(response.body().asString());
		
		response.then().body("data.first_name",equalTo("Janet"));
		Reporter.log(response.body().asString());
		
		response.then().body("data.last_name",equalTo("Weaver"));
		Reporter.log(response.body().asString());				
		
		response.then().body("data.avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));
		Reporter.log(response.body().asString());
		
		response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
		Reporter.log(response.body().asString());
		
		response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		Reporter.log(response.body().asString());
  }
  
@Test
  
  public void f_b() {
	  given()
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat().body("data.id", equalTo(2))
	        .assertThat().body("data.email", equalTo("janet.weaver@reqres.in"))
	        .assertThat().body("data.first_name", equalTo("Janet"))
	        .assertThat().body("data.last_name", equalTo("Weaver"))
	        .assertThat().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
	        .assertThat().body("support.url", equalTo("https://reqres.in/#support-heading"))
	        .assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	        
	  
	  Reporter.log("Sucess 200 validation");
	  
  }
  
  
  @Test
  
  public void exercise_1() {
	  given()
	  .when()
	  	.get("https://reqres.in/api/unknown/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat().body("data.id", equalTo(2))
	        .assertThat().body("data.name", equalTo("fuchsia rose"))
	        .assertThat().body("data.year", equalTo(2001))
	        .assertThat().body("data.color", equalTo("#C74375"))
	        .assertThat().body("data.pantone_value", equalTo("17-2031"))
	        .assertThat().body("support.url", equalTo("https://reqres.in/#support-heading"))
	        .assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	        
	  
	  Reporter.log("Sucess 200 validation");
	  
  }
  
  @Test
  public void exercise_1A(){
	  RestAssured.baseURI = "https://reqres.in/api/";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("/unknown/2"); 
	  
	  int statusCode = response.getStatusCode();
	  
	  response.then().body("data.id",equalTo(2));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("data.name",equalTo("fuchsia rose"));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("data.year",equalTo(2001));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("data.color",equalTo("#C74375"));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("data.pantone_value",equalTo("17-2031"));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
	  Reporter.log(response.body().asString());
	  
	  response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	  Reporter.log(response.body().asString());
      
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  
  

}


