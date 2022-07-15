package com.unosquare;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiCore {
	
	//en una clase el primer metodo es el metodo constructor y no debe llevar valor de retorno (VOID)
	

	public Response PostLogin(String filePath, String url) throws IOException, ParseException {
		// TODO Auto-generated method stub
		

		 JSONParser json = new JSONParser();
		 FileReader reader = new FileReader(filePath);
		 Object obj = json.parse(reader);
		 
		 JSONObject emailjsonobj=(JSONObject)obj;
		 
		 String email= (String) emailjsonobj.get("email");
		 String password= (String) emailjsonobj.get("password");
		 
		 System.out.println("Email: "+ email);
		 System.out.println("Password: "+ password);
	 
		 
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get(url);		
		 
		
		return response;
	}
	
	
	
	 
	
	


}
