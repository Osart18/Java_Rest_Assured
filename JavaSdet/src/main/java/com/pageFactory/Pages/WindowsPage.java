package com.pageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.courseSelenium.Base.Setup;

public class WindowsPage extends Setup {	
	
	By search = By.id("search");
	By textBox = By.id("cli_shellHeaderSearchInput");
	String textSerch = "Xbox";
	By buy = By.xpath("//*[@id=\"coreui-pivotheader-s3sdtmy\"]/div/div/header/a[1]");
	By closePopup = By.xpath("//*[@id=\"R1MarketRedirect-close\"]");
	
	public WindowsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void SerchClick() throws InterruptedException  {		
		  Thread.sleep(5000);		 
		  click(search);			 
		  /*	  
		  if (isDisplayed(buy)) {
				click(searchWindowsMenu);				
			}else {
				System.out.println("Page not found ");
			}						
	    }
	*/
	}
	
	
	public void textSerch(WebDriver driver) throws InterruptedException  {
		Thread.sleep(2000);
		writeText(textBox, textSerch);	
		String  title1 = driver.getTitle();
		System.out.println("The title in third page is: "+ title1);
  }
	
	public void Buy() throws InterruptedException  {
		Thread.sleep(1000);
		click(buy);			
  }
	
	public void closePopup() throws InterruptedException  {
		Thread.sleep(1000);
		if (isDisplayed(closePopup)) {
			click(closePopup);				
		}
					
  }
	
	

}
