package com.WSM.pages;

import com.WSM.utilities.Configreader;

public class AddpaxworkshopPage {
	
	Configreader cr;
	public AddpaxworkshopPage() {
		String proppath="//src//main//resources//Locators//AddpaxWorkshop.properties";
		cr= new Configreader(proppath);
	}
	
	public String getaddpax() {
		return cr.getProperty("Pax");
		}
	public String getOfflineorder() {
		return cr.getProperty("Offlineorder");
		}
	public String getFirstname() {
		return cr.getProperty("First_name");
		}
	public String getlastname() {
		return cr.getProperty("Last_name");
		}
	public String getemail() {
		return cr.getProperty("Email");
		}
	public String getIsdcode() {
		return cr.getProperty("IsdCode");
		}
	public String getphonenumber() {
		return cr.getProperty("phonenumber");
		}
	public String getcountry() {
		return cr.getProperty("country");
		}
	public String getcity() {
		return cr.getProperty("city");
		}
	public String getInvoicedate() {
		return cr.getProperty("invoicedate");
		}
	public String getTodaydate() {
		return cr.getProperty("todaydate");
		}
	public String getInvoiceduedate() {
		return cr.getProperty("invoiceduedate");
		}
	public String getWebsite() {
		return cr.getProperty("website");
		}
	public String getSearchfield() {
		return cr.getProperty("Search_field");
		}
	public String getPaymentMode() {
		return cr.getProperty("paymentmode");
		}
	public String getReferenceno() {
		return cr.getProperty("referenceno");
		}
	public String getPaymentdate() {
		return cr.getProperty("paymentdate");
		}
	public String getNominatingpartner() {
		return cr.getProperty("nominatingpartner");
	}
	public String getSendcheckbox() {
		return cr.getProperty("sendemailcheckbox");
		}
	}