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

public class PostReq2 {
	
	
	@Test	  
	  public void testPostUser() throws IOException, ParseException {
		baseURI = "https://reqres.in";
		Reporter.log("URL: "+ baseURI);
							
		//Request object(whenever you want to send request to the server)
		RequestSpecification httpRequest = RestAssured.given(); 
		
		
		
		//JSONObject para imprimirlo con formato, ejemplo "email"  System.out.println(request)); esta necesita libreria en pom.xml la de json-simple
		//esta otra opción es igual a la anterior System.out.println(request.toJSONString))
		//Map<String, Object> map = new HashMap<String,Object>();
	 //   JSONObject  request = new JSONObject(map);
		//request.put("email","sydney@fife");
		
		JSONObject  request = new JSONObject();	
		request.put("email","sydney@fife");
		httpRequest.header("Content-Type","application/json");
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		httpRequest.body(request.toString()); 
		Response response = httpRequest.post("/api/register");
		
				
		given()		   		         
		    // .log().all()
		     .body(request.toString())
		  .when()
		  	 .post("/api/register")
		  .then()			  		
		  		.assertThat().statusCode(400)
		        .log().all();
		         Reporter.log(response.getBody().asString());
		         
		       
		     /*    
		         RestAssured.baseURI = "https://reqres.in/api"; 
				 RequestSpecification httpRequest = RestAssured.given(); 
				 httpRequest.headers("Content-Type", "application/json");
				 httpRequest.body(requestParams.toString());
				 Response response = httpRequest.post("/users");
		       */  		         		
		  
	  }

}


