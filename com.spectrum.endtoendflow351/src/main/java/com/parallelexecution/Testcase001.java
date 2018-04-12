package com.parallelexecution;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase001 extends InvokeBrowsers {

	@BeforeClass
	public void testcasedata() {
		testcasename="tc001redbus";
		testcasedescription = "launching redbus site";
		url="https://www.redbus.in/pilgrimages/";
	}
	
	@Test
	public void redbus() throws IOException {
		driver.get(url);
		String titlename  = driver.getTitle();

		if (driver.findElementByXPath("//section[@class='testimonials-wrapper']/div/h3").getText().contains("TRAVELLERS")) {
			status = "pass";
		} else {
			status = "fail";
		}
		Assert.assertEquals(titlename,"Pilgrimage Package: Book Pilgrimage Tours & Travel Packages - redBus");
		
	}

	

	
}
