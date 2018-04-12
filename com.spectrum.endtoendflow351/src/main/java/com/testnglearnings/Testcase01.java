package com.testnglearnings;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase01 extends InvokeBrowsers {

	@BeforeClass
	public void testcasedata() {
		testcasename="tc01redbus";
		testcasedescription = "launching redbus site";
		url="https://www.redbus.in/pilgrimages/";
	}
	
	@Test
	public void redbus() throws IOException {
		driver.get(url);
		if (driver.findElementByXPath("//section[@class='testimonials-wrapper']/div/h3").getText().contains("TRAVELLERS")) {
			status = "pass";
		} else {
			status = "fail";
		}
	}

	

	
}
