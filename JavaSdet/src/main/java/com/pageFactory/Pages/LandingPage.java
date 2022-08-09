package com.pageFactory.Pages;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;

import com.courseSelenium.Base.Setup;

public class LandingPage extends Setup {
	
	By searchWindowsMenu = By.id("shellmenu_2");
	By xpathwindows = By.xpath("//*[@id=\"shellmenu_2\"]");
	
	
	
	public  LandingPage(WebDriver driver)  {
			super(driver);			
	}	
	
	public void SerchWindows(WebDriver driver) throws InterruptedException  {		

	  Thread.sleep(2000);		
	  if (isDisplayed(xpathwindows)) {
			click(searchWindowsMenu);	
			 String  title1 = driver.getTitle();
			 System.out.println("The title in second page is: "+ title1);
		}else {
			System.out.println("Page not found ");
		}
	 
    }
	
	

}
