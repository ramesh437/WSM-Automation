package com.WSM.pages;

import com.WSM.utilities.Configreader;

public class CreateWorkshopPage {
	Configreader cr;
	public CreateWorkshopPage() {
		String proppath="//src//main//resources//Locators//CreateWorkshop.properties";
		cr= new Configreader(proppath);
	}

	public String getSearchBox() {
		return cr.getProperty("Search");


	}
	public String getSearchButton() {
		return cr.getProperty("SearchButton");
	}
	public String getCopyButton() {
		return cr.getProperty("copyButton");
	}
	public String getNoofHours(){
		return cr.getProperty("no.ofhours");
	}
	public String getNo_ofdays() {
		return cr.getProperty("no.ofdays");
	}
	public String getSelectdate() {
		return cr.getProperty("date");
	}
	public String getSelectMonth() {
		return cr.getProperty("month");
	}
	public String getSelectYear() {
		return cr.getProperty("year");
	}
	public String getSelectNextIcon() {
		return cr.getProperty("nextIcon");
	}
	public String getSelectDay() {
		return cr.getProperty("day");
	}
	public String getStarttime() {
		return cr.getProperty("start_time");
	}
	public String getendtime() {
		return cr.getProperty("end_time");
	}
	public String getLanguage() {
		return cr.getProperty("Language");
	}
	public String getSearchField() {
		return cr.getProperty("Search_field");
	}
	public String getBatchField() {
		return cr.getProperty("Batch");
	}
	public String getWeeksField() {
		return cr.getProperty("Weeks");
	}
	public String getSessionsField() {
		return cr.getProperty("Sessions");
	}
	public String getTimeZoneField() {
		return cr.getProperty("Time_zone");
	}
}
