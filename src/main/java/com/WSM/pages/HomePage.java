package com.WSM.pages;

import com.WSM.utilities.Configreader;

public class HomePage {
	Configreader cr;
	public HomePage() {
		
		String proppath="//src//main//resources//Locators//Homepage.properties";
		cr=new Configreader(proppath);
	}
	
	public  String getUsername() {
		return cr.getProperty("E-mail");
	}
	public  String getPassword() {
		return cr.getProperty("Password");
	}
	public  String getSubmit() {
		return cr.getProperty("Button");
	}
	public  String Loginpopup() {
		return cr.getProperty("PopUp");
	}
	public  String LogoutSessions() {
		return cr.getProperty("LogoutsessionsButton");
	}

}
