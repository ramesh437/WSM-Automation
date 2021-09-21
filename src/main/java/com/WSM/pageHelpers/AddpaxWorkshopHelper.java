package com.WSM.pageHelpers;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.DoubleStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.WSM.base.TestBase;
import com.WSM.pages.AddpaxworkshopPage;
import com.WSM.pages.CopyWorkshopPage;
import com.WSM.pages.GeneralPage;

public class AddpaxWorkshopHelper extends TestBase{
	
	public AddpaxworkshopPage addpax;
	public GeneralPage gp;

	public AddpaxWorkshopHelper() {

		gp=new GeneralPage(); 
		addpax=new AddpaxworkshopPage();
	}
	public void AddPAx() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.findElement(By.xpath(addpax.getaddpax())).click();
	   try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   driver.findElement(By.xpath(addpax.getOfflineorder())).click();
	   ArrayList<String> AddpaxPage = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(AddpaxPage.get(1));
	  //WebElement form= driver.findElement(By.xpath("//form[@class='form-horizontal']"));  
	    
	  //firstname
	   WebElement email= driver.findElement(By.xpath(addpax.getFirstname()));
	   js.executeScript("arguments[0].scrollIntoView()", email);
	   Random randomGenerator1 = new Random();  
	   int FirstnameNo = randomGenerator1.nextInt(1000);
	   String FirstnameRandom="prismtest" + FirstnameNo;
	   email.sendKeys(FirstnameRandom);
	   //Last name
	   WebElement Lastname= driver.findElement(By.xpath(addpax.getlastname()));
	   String Lastrandom ="user" + FirstnameNo;
	   Lastname.sendKeys(Lastrandom);
	   //Email
	   WebElement emailbox= driver.findElement(By.xpath(addpax.getemail()));
	   Random randomGenerator = new Random();  
	   int randomInt = randomGenerator.nextInt(10000);  
	   emailbox.sendKeys("prismtestuser"+ randomInt +"@mailinator.com"); 
	   
	   //isdcode
	   driver.findElement(By.xpath(addpax.getIsdcode())).click();
	   WebElement Search_isdcode=driver.findElement(By.xpath(addpax.getSearchfield()));
	   Search_isdcode.sendKeys("+91",Keys.ENTER);
	   //phonenumber

	   long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
	  
	   WebElement phonenumber= driver.findElement(By.xpath(addpax.getphonenumber()));
	   phonenumber.sendKeys(String.valueOf(number));
	   
	   //country
	   driver.findElement(By.xpath(addpax.getcountry())).click();
	   WebElement Search_country=driver.findElement(By.xpath(addpax.getSearchfield()));
	   Search_country.sendKeys("india",Keys.ENTER);
	   //city
	   driver.findElement(By.xpath(addpax.getcity())).click();
	   WebElement Search_city=driver.findElement(By.xpath(addpax.getSearchfield()));
	   Search_city.sendKeys("Hyderabad",Keys.ENTER);
	   
	   //INVOICE DATE
	   WebElement invoicedate=driver.findElement(By.xpath(addpax.getInvoicedate()));
	  
	   js.executeScript("arguments[0].scrollIntoView()", invoicedate);
	   invoicedate.click();
	   
	   driver.findElement(By.xpath(addpax.getTodaydate())).click();
	   
	   //INVOICE DUE DATE
	   driver.findElement(By.xpath(addpax.getInvoiceduedate())).click();
	   driver.findElement(By.xpath(addpax.getTodaydate())).click();
	   
	   //WEBSITE
	   
	   driver.findElement(By.xpath(addpax.getWebsite())).click();
	   WebElement Search_website=driver.findElement(By.xpath(addpax.getSearchfield()));
	   Search_website.sendKeys("knowledgehut",Keys.ENTER);
	   
	   //PAYMENT MODE
	   driver.findElement(By.xpath(addpax.getPaymentMode())).click();
	   WebElement Search_mode=driver.findElement(By.xpath(addpax.getSearchfield()));
	   Search_mode.sendKeys("ICICI",Keys.ENTER);
	   
	   //REFERENCENO
	   WebElement ref_no=driver.findElement(By.xpath(addpax.getReferenceno()));
	   ref_no.sendKeys("ICICI"+randomInt);
	   
	   //PAYMENT DATE
	   driver.findElement(By.xpath(addpax.getPaymentdate())).click();
	   driver.findElement(By.xpath(addpax.getTodaydate())).click();
	   
	   //Nominating partner
	   driver.findElement(By.xpath(addpax.getNominatingpartner())).click();
	   
	   //CHECKBOX
	   WebElement checkbox = driver.findElement(By.xpath(addpax.getSendcheckbox()));
	   js.executeScript("arguments[0].scrollIntoView()", checkbox);
	   checkbox.click();
	   //submit
	   driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

}
