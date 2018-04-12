package com.parallelexecution;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase002 extends InvokeBrowsers {
	
	@BeforeClass
	public void testcasedata() {
		testcasename="tc002kpntravelscheckcontent";
		testcasedescription = "launching kpn travels site and checking for content";
		url="http://kpntravels.in/";
	}

	@Test
	public void kpntravels() throws IOException {
		
		driver.get(url);
		String abc = driver.findElementByXPath("//div[@class='content-about']/div/div[2]/div/h3").getText();
		if (abc.equalsIgnoreCase("Plan Your Travel")) {
			status = "pass";
		} else {
			status = "fail";
		}
	}
	
	
	
	
	
	/*@Test
	public void irctc() throws InterruptedException {
		chromebrowser();
//		iebrowser();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		Thread.sleep(5000);
		
		//System.out.println(driver.findElementByClassName("labeltxt1").getText());
		driver.findElementByXPath("//a[text()='Sign up']").click();
		driver.findElementById("userRegistrationForm:idno").sendKeys("email@gmail.com");
		System.out.println(driver.findElementByXPath("//div[@class='irfooterlink']").getText());
	}
	*/
	
}
