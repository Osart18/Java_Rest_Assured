package com.pageFactory.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.courseSelenium.SearchValidation;

import com.courseSelenium.Base.Setup;

public class Aritmetic extends Setup {
	
	 List<WebElement> listImages,listImages1;
	 

	public Aritmetic(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addElements(WebDriver driver) {
		 listImages=driver.findElements(By.tagName("img"));
		 listImages1=driver.findElements(By.tagName("h2"));
		 //System.out.println("No. of Images: "+listImages.size());
		 
		 try {
			SearchValidation.count = SearchValidation.count + listImages.size();
			SearchValidation.count = SearchValidation.count + listImages1.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
}
