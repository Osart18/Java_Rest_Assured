package com.courseSelenium;

import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.courseSelenium.Base.Setup;
import com.pageFactory.Pages.Aritmetic;
import com.pageFactory.Pages.LandingPage;
import com.pageFactory.Pages.WindowsPage;
import com.pageFactory.Pages.resultPage;

       



public class SearchValidation {
	
  WebDriver driver;
  Aritmetic  aritmetic;
  LandingPage landingPage;
  WindowsPage windowspage;
  resultPage resultpage;
  Setup setup;            
  public static int count=0;
  
 
  
  
  @BeforeClass  
	public void beforeClass() {
	  		 
	  landingPage = new LandingPage(driver);	  
	  driver  = landingPage.Createdriver();	  	  	  	 
	  
	  resultpage  = new resultPage(driver);
	  windowspage = new WindowsPage(driver);
	  aritmetic = new Aritmetic(driver);
	  
	} 	
 
  @Test
public void search() throws InterruptedException {	
	  landingPage.visit("https://www.microsoft.com/es-mx/");
	  aritmetic.addElements(driver);
	  landingPage.SerchWindows(driver);
	  aritmetic.addElements(driver);
	  windowspage.SerchClick();
	  windowspage.textSerch(driver);
	  windowspage.closePopup();
	  windowspage.Buy();
	 // resultpage.aplicationsClick();
	  resultpage.gameMenu();
	  aritmetic.addElements(driver);
	  resultpage.getPrice(driver);
	  resultpage.gameChoose();	 
	  resultpage.closePop();
	  resultpage.getPrice2(driver);	  
	  resultpage.threedots();
	  resultpage.cart();
	  resultpage.deletecart();
	  System.out.println("No. of Images: "+ count);
  }
	  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }
  
  
  
}
