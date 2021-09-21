package com.WSM.pageHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WSM.base.TestBase;
import com.WSM.pages.GeneralPage;
import com.WSM.pages.HomePage;

public class HomePageHelper extends TestBase{
	
	public GeneralPage gp;
	public HomePage hp;
	

	public HomePageHelper() {

		gp=new GeneralPage();
		hp=new HomePage();
		
	}

	public void browser() {

		driver= initialization(gp.getbrowser());
		browsersettings();
	}

	public void url() {
		driver.get(gp.geturl());
//		asrt.assertEquals(driver.getTitle(),"Prism - AI driven, full stack digital learning experience platform","TitleNot Matched");
//		asrt.assertAll();
	}

	public void loginFromProperty() {
		driver.findElement(By.xpath(hp.getUsername())).sendKeys(gp.getusername());
		driver.findElement(By.xpath(hp.getPassword())).sendKeys(gp.getpassword());
		driver.findElement(By.xpath(hp.getSubmit())).click();
		boolean popup= driver.findElement(By.xpath(hp.Loginpopup())).isDisplayed();
		if(popup=true) {
			
			driver.findElement(By.xpath(hp.LogoutSessions())).click();
		}
		
	}
}
