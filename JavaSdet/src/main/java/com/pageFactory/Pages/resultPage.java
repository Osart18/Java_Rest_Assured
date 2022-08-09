package com.pageFactory.Pages;

import java.util.Arrays;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.courseSelenium.Base.Setup;



public class resultPage extends Setup {
	
	String[] precio1;
	
	By aplications = By.xpath("//*[@id=\"refine-by-menu-title-Categorías\"]/div/ul/li[1]/a");
	By game = By.xpath("//*[@id=\"refine-by-menu-title-Categorías\"]/div/ul/li[3]/a");	
    By chooseGame = By.xpath("//*[@id=\"coreui-productplacementlist-1g76zxk\"]/div[3]/div[2]/div[47]/a/div[1]/picture/img");    	
    By getPrice1 = By.xpath("//*[@id=\"coreui-productplacementlist-1g76zxk\"]/div[3]/div[2]/div[47]/a");
    By getPrice2 = By.xpath("//div[@id='productPrice']"); 
                             //*[@id="ProductPrice_productPrice_PriceContainer-8"]/span[1]  arriba esta lo que obtiene solamente  
	By closepopup = By.xpath("//*[@id=\"email-newsletter-dialog\"]/div[3]/div[1]");
	By dots = By.xpath("//*[@id=\"ButtonPanel_buttonPanel_OverflowMenuTrigger\"]");
	                    //*[@id="ButtonPanel_buttonPanel_OverflowMenuTrigger"]
	By addToCart = By.xpath("//*[@id=\"buttonPanel_AddToCartButton\"]");
	
	By validateCart = By.xpath("//div[@id=\"store-cart-root\"]");	
	
    By closepopup2 = By.xpath("//*[@id=\"lp-proactive-invite\"]/div/button[2]");
	By deleteCart = By.xpath("//*[@id='store-cart-root']/div/div/div/section[1]/div/div/div/div[1]/div/div[2]/div[2]/div/button[1]");                    

	
	
	public resultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public void aplicationsClick() throws InterruptedException  {		
		  Thread.sleep(2000);				 
		  click(aplications);											
	}
	
	
	public void gameMenu() throws InterruptedException  {		
		  Thread.sleep(2000);				 
		  click(game);											
	}
	 
	  
	
	 public void gameChoose() throws InterruptedException  {		
		  Thread.sleep(2000);				 
		  click(chooseGame);											
	}
	 
	 public void getPrice(WebDriver driver) throws InterruptedException {
		 Thread.sleep(2000);
		  String text;
		   //  String text = driver.findElement(By.xpath("//*[@id=\"ProductPrice_productPrice_PriceContainer-1\"]/span[1]")).getAttribute("innerText");
		   //  String text2 = driver.findElement(By.xpath()).getAttribute("textcontent");			
		  text=getPriceGame(getPrice1);	
		  String[] divideText= text.split("\\$"); 
		  String part2 = divideText[1];			  
		  precio1= part2.split("\\+");
		 		  
		  		 		 
		}
	 
	 public void closePop() throws InterruptedException  {
			Thread.sleep(2000);
			if (isDisplayed(closepopup)) {
				click(closepopup);				
			}
	 }
	 
	 public void getPrice2(WebDriver driver) throws InterruptedException {
		  Thread.sleep(1000);
		  String text;		   			 
		  text=getPriceGame(getPrice2);			  
		  String[] divideText= text.split("\\$"); 		 
		  String part2 = divideText[1];		 
		  String[] precio2= part2.split("\\+");
			
		  
		  if (precio1[0].equals(precio2[0])) {
			  System.out.println("Precios iguales: ");
			 // Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
		  }else {
			  System.out.println("Precios diferentes: "+precio1[0]+" "+precio2[0]);
		  }
	  }		   		 		 		
	 	 

	 public void threedots() throws InterruptedException  {		
		  Thread.sleep(3000);				 
		  click(dots);											
		  click(addToCart);
	}
	 
	 public void cart() throws InterruptedException  {		
		 Thread.sleep(2000);		 
		 if (isDisplayed(closepopup2)) {
				click(closepopup2);				
		}
		 String text;		
		  text=getPriceGame(validateCart);			 
		  if (text.equals("Tu carro est� vac�o")) {
			  System.out.println("Cart is Empty");			 
		  }else {
			  System.out.println("One element available");
		  }
	 }
	 
	 @SuppressWarnings("unlikely-arg-type")
	public void deletecart() throws InterruptedException  {		
		 Thread.sleep(1000);		 
		 click(deleteCart);
		 
		 String text;		
		  text=getPriceGame(validateCart);
		  
		  
		  
		  String[] divideText= text.split("\n"); 		 
		  String part2 = divideText[3];	
		  
		  
		//  for (int i = 0; i < divideText.length; i++) {
	    //        System.out.println(divideText[i]+" I "+i);
	    //    }
		  
		  if (part2.equals("Tu carro ")) {
			  System.out.println("Element was delete");			 
		  }else {
			  System.out.println("One element available ");
			  
		  }
	 }
	 
	 


}

