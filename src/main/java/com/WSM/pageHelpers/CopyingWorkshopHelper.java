package com.WSM.pageHelpers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WSM.base.TestBase;
import com.WSM.pages.CopyWorkshopPage;

import com.WSM.pages.GeneralPage;

public class CopyingWorkshopHelper extends TestBase {
	public CopyWorkshopPage copywp;
	public GeneralPage gp;

	public CopyingWorkshopHelper() {

		gp=new GeneralPage(); 
		copywp=new CopyWorkshopPage();
	}
	
	public void AddWorkshop() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(copywp.getTraining())).click();
		driver.findElement(By.xpath(copywp.getLVC())).click();
	List<WebElement> listofhrefs =driver.findElements(By.xpath(copywp.getALL()));
	System.out.println(listofhrefs.get(0));
	listofhrefs.get(0).click();
		//driver.findElement(By.xpath(copywp.getALL())).click();
		driver.findElement(By.xpath(copywp.getAdd())).click();
		driver.findElement(By.xpath(copywp.getSlot())).click();
		
	}
	public void selectCourse(String CourseName) {
		driver.findElement(By.xpath("//div[@class='col-lg-6 col-sm-10'][1]/span")).click();
		WebElement searchfield=driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		searchfield.sendKeys(CourseName,Keys.ENTER);
		
		//no.of hours and days
		WebElement hours=driver.findElement(By.xpath(copywp.getNoofHours()));
		hours.clear();
		hours.sendKeys("2");
		
		WebElement days=driver.findElement(By.xpath(copywp.getNo_ofdays()));
		String s = days.getAttribute("value");
		System.out.println(s);
		if(s==null) {
			days.sendKeys(Keys.ARROW_UP);
		}
	}
public void selectdate(String Month,String Year,String Day) {
		
		WebElement date=driver.findElement(By.xpath(copywp.getSelectdate()));
		date.click();
		while(true) {
		String Monthtext =driver.findElement(By.xpath(copywp.getSelectMonth())).getText();
		String Yeartext =driver.findElement(By.xpath(copywp.getSelectYear())).getText();
		if(Monthtext.equals(Month)&&Yeartext.equals(Year)) {
			break;
		}
		else {
			driver.findElement(By.xpath(copywp.getSelectNextIcon())).click();
		}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> dates= driver.findElements(By.xpath(copywp.getSelectDay()));
		for(int i=0;i<=dates.size();i++) {
			
			String dateText= dates.get(i).getText();
			if(dateText.equals(Day)) {
				
				dates.get(i).click();
				
			}
		}
		
	}
public void selectTime(String StartTime,String EndTime) {
	
	WebElement Start_Time= driver.findElement(By.xpath(copywp.getStarttime()));
	Start_Time.clear();
	Start_Time.sendKeys((StartTime));
	WebElement End_Time=driver.findElement(By.xpath(copywp.getendtime()));
	End_Time.clear();
	End_Time.sendKeys(EndTime);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Select language
	driver.findElement(By.xpath(copywp.getLanguage())).click();
	WebElement Search_language=driver.findElement(By.xpath(copywp.getSearchField()));
	Search_language.sendKeys("English",Keys.ENTER);
	//Select Batch
	driver.findElement(By.xpath(copywp.getBatchField())).click();
	WebElement Search_Batch=driver.findElement(By.xpath(copywp.getSearchField()));
	Search_Batch.sendKeys("weekday",Keys.ENTER);
	//weeks
	WebElement weeks= driver.findElement(By.xpath(copywp.getWeeksField()));
	weeks.clear();
	weeks.sendKeys("1");
	//sessions
	WebElement sessions =driver.findElement(By.xpath(copywp.getSessionsField()));
	sessions.clear();
	sessions.sendKeys("2");
	//timezone
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(copywp.getTimeZoneField())).click();
	WebElement Search_TimeZone=driver.findElement(By.xpath(copywp.getSearchField()));
	Search_TimeZone.sendKeys("asia/kolkata",Keys.ENTER);
	
	//currency selection
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(copywp.getCurrency())).click();
	WebElement Search_currency=driver.findElement(By.xpath(copywp.getSearchField()));
	Search_currency.sendKeys("Inr",Keys.ENTER);
	
	//price
	driver.findElement(By.xpath(copywp.getprice())).sendKeys("1");
	
	//submit button
	driver.findElement(By.xpath("//div[@class='form-actions text-right']/input[@type='submit']")).click();
	
	
	}

}
