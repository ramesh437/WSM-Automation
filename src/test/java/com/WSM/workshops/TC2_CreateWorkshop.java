package com.WSM.workshops;

import org.testng.annotations.Test;

import com.WSM.pageHelpers.CreateWorkshopHelper;

public class TC2_CreateWorkshop extends CreateWorkshopHelper {
	
	@Test(priority=1)
		public void seacrhworkshop(){
		seacrhwithWorkshopID("KHI-AMC-V163-9997316860");
		}
	@Test(priority=2)
	public void copyingWorkshop() {
		copyWorkshop();
		selectdate("February","2021","12");
		
	}
	@Test(priority=3)
	public void Entertime() {
		selectTime("06:30 PM","07:00 PM");
	}
	
	

}
