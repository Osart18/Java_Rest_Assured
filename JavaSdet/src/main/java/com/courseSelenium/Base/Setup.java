package com.courseSelenium.Base;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup{

	private WebDriver driver;
	String price;
	
	public Setup(WebDriver driver) {
	   this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void base(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver Createdriver() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
		 driver = new ChromeDriver();
		 return driver;
	}
	
	public WebElement findElement(By locator) {
		 return driver.findElement(locator);
		 //  switch (locatorType)
		   //    case locatorType.Xpath:			   
	}
	
//	public  List<WebElement> findElements(By locator) {
//		 return driver.findElements(locator);		 		  
//	}
	
	public String getPriceGame(By locator) {			
		return  price = driver.findElement(locator).getAttribute("innerText");
	}
	
	public String getTex(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();			
	}
	
	public void writeText(By locator, String text)   {		
		 driver.findElement(locator).sendKeys(text,Keys.ENTER);			
    }
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
		String  title1 = driver.getTitle();
		 System.out.println("The title in first page is: "+ title1);		 
	}
	
	
}
/*



public void Click(WebElement element) {
	

}


public void SendKeys(WebElement element, String value) {
	

}




enum LocatorType{
Xpath,
Css,
Tag,
Id
}

*/