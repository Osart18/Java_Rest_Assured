package com.unosquare;

import static io.restassured.RestAssured.*;


import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostReq {
	
	
	@Test	  
	  public void testPostUser() throws IOException, ParseException {
		baseURI = "https://reqres.in";
		 Reporter.log("URL: "+ baseURI);
							
		//Request object(whenever you want to send request to the server)
		RequestSpecification httpRequest = RestAssured.given(); 
		
		//Map<String, Object> map = new HashMap<String,Object>();
		JSONObject  map = new JSONObject();
		map.put("id",15);
		map.put("email","sergion@reqres.in");
		map.put("first_name","Sergio");
		map.put("last_name","Lawson");        
		map.put("avatar","https://reqres.in/img/faces/7-image.jpg");		
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(map.toString());
		Response response = httpRequest.post("/api/users");
		
		
		given()
		    // .log().all()
		     .body(map.toString())
		  .when()
		  	 .post("/api/users")
		  		.then()			  		
		  		.statusCode(201);
		         Reporter.log("Sucess 201 validation");
		        // Reporter.log(response.body().asString());
		         Reporter.log(response.getBody().asString());
		         
		       // Retrieve the body of the Response
		     	 ResponseBody body = response.getBody();

		     	// By using the ResponseBody.asString() method, we can convert the  body
		     	// into the string representation.
		     	 System.out.println("Response Body is: " + body.asString());
		     	 System.out.println("URL is: " + baseURI);
		         		         		
		  
	  }

}


