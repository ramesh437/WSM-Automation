package com.WSM.workshops;

import org.testng.annotations.Test;

import com.WSM.pageHelpers.CopyingWorkshopHelper;

public class TC3_CopyWorkshop extends CopyingWorkshopHelper {
	
	@Test(priority=1)
	public void copyworkshop() {
		AddWorkshop();
		selectCourse("React JS");		
	}
	@Test(priority=2)
	public void selectdateforworkshop(){
		selectdate("September","2021","27");
		//selectTime("06:30 PM","07:00 PM");
	}
	@Test(priority=3)
	public void selecttimeforworkshop(){
		
		selectTime("06:30 PM","07:00 PM");
	}
	

}
