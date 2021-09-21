package com.WSM.workshops;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.WSM.pageHelpers.HomePageHelper;

public class TC1_Login extends HomePageHelper{
	@BeforeSuite
	public void begin() {
		browser();
	}
	
	@Test
	public void Login() {
		url();
		loginFromProperty();
	}
	
	@AfterSuite
	public void end() {
		//DashboardHelper.logout();
		//destroy();
	}

}
