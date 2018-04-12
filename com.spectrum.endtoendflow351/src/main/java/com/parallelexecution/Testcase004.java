package com.parallelexecution;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testcase004 extends InvokeBrowsers{
	@BeforeClass
	public void testcasedata() {
		testcasename="tc004kpntravelsprinttext";
		testcasedescription = "launching kpntravels and print text";
		url="http://kpntravels.in/";
	}
	
	@Test
	public void kpntravels(){
		driver.get(url);
		try {
			System.out.println(driver.findElementByXPath("//div[@class='content-about']/div/div[2]/div/h3").getText());
			status="pass";
		} catch (Exception e) {
			System.out.println("Exception occured");
			status="fail";
		}
		
		
		
		
		/*ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("tesecase name", "Description of testcase");
		test.assignAuthor("Anand");
		test.assignCategory("Basic sanity");
		
		if(status.equalsIgnoreCase("pass"))	{
		test.pass("testcase passed");
		}
		
		else{
		test.fail("testcase failed");
		}
		
		extent.flush();*/
		
		
	}
}
