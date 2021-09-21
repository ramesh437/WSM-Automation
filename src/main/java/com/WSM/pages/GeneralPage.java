package com.WSM.pages;

import com.WSM.utilities.Configreader;

public class GeneralPage {
	Configreader cr;
	public GeneralPage() {
		
		String proppath="//src//main//resources//Locators//General.properties";
		cr=new Configreader(proppath);
	}
	
	public  String geturl() {
		return cr.getProperty("url");
	}
    public String getbrowser() {
    	return cr.getProperty("Browser");
    }
    public String getusername() {
    	return cr.getProperty("username");
    }
    public String getpassword() {
    	return cr.getProperty("password");
    }

}
