package com.WSM.pageHelpers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.WSM.base.TestBase;
import com.WSM.pages.CreateWorkshopPage;
import com.WSM.pages.GeneralPage;

public class CreateWorkshopHelper extends TestBase{

	public CreateWorkshopPage cwp;
	public GeneralPage gp;

	public CreateWorkshopHelper() {

		gp=new GeneralPage(); 
		cwp=new CreateWorkshopPage();
	}
 
	public void seacrhwithWorkshopID(String workshopcode) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement searchbox=driver.findElement(By.xpath(cwp.getSearchBox()));
		System.out.println(searchbox);
		searchbox.sendKeys(workshopcode);
		driver.findElement(By.xpath(cwp.getSearchButton())).click();

	}
	public void copyWorkshop() {
		WebElement copybutton=driver.findElement(By.xpath(cwp.getCopyButton()));
		copybutton.click();
		
		WebElement hours=driver.findElement(By.xpath(cwp.getNoofHours()));
		hours.clear();
		hours.sendKeys("2");
		
		WebElement days=driver.findElement(By.xpath(cwp.getNo_ofdays()));
		String s = days.getAttribute("value");
		System.out.println(s);
		if(s==null) {
			days.sendKeys(Keys.ARROW_UP);
		}
		
		
 
	}
	
	public void selectdate(String Month,String Year,String Day) {
		
		WebElement date=driver.findElement(By.xpath(cwp.getSelectdate()));
		date.click();
		while(true) {
		String Monthtext =driver.findElement(By.xpath(cwp.getSelectMonth())).getText();
	System.out.println(Monthtext);
		String Yeartext =driver.findElement(By.xpath(cwp.getSelectYear())).getText();
		System.out.println(Yeartext);
		if(Monthtext.equals(Month)&&Yeartext.equals(Year)) {
			break;
		}
		else {
			driver.findElement(By.xpath(cwp.getSelectNextIcon())).click();
		}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> dates= driver.findElements(By.xpath(cwp.getSelectDay()));
		for(int i=0;i<=dates.size();i++) {
			
			String dateText= dates.get(i).getText();
			if(dateText.equals(Day)) {
				
				dates.get(i).click();
				
			}
		}
		
	}
public void selectTime(String StartTime,String EndTime) {
	
	WebElement Start_Time= driver.findElement(By.xpath(cwp.getStarttime()));
	Start_Time.clear();
	Start_Time.sendKeys((StartTime));
	WebElement End_Time=driver.findElement(By.xpath(cwp.getendtime()));
	End_Time.clear();
	End_Time.sendKeys(EndTime);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Select language
	driver.findElement(By.xpath(cwp.getLanguage())).click();
	WebElement Search_language=driver.findElement(By.xpath(cwp.getSearchField()));
	Search_language.sendKeys("English",Keys.ENTER);
	//Select Batch
	driver.findElement(By.xpath(cwp.getBatchField())).click();
	WebElement Search_Batch=driver.findElement(By.xpath(cwp.getSearchField()));
	Search_Batch.sendKeys("weekday",Keys.ENTER);
	//weeks
	WebElement weeks= driver.findElement(By.xpath(cwp.getWeeksField()));
	weeks.clear();
	weeks.sendKeys("1");
	//sessions
	WebElement sessions =driver.findElement(By.xpath(cwp.getSessionsField()));
	sessions.clear();
	sessions.sendKeys("2");
	//timezone
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(cwp.getTimeZoneField())).click();
	WebElement Search_TimeZone=driver.findElement(By.xpath(cwp.getSearchField()));
	Search_TimeZone.sendKeys("asia/kolkata",Keys.ENTER);
	//submit button
	driver.findElement(By.xpath("//div[@class='form-actions text-right']/input[@type='submit']")).click();
	
	
	}
}
