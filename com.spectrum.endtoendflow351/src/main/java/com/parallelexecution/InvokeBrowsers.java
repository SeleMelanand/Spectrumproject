package com.parallelexecution;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

// high level plan to execute all the testcases in a singel browsers

public class InvokeBrowsers {
	public RemoteWebDriver driver;
	public ExtentHtmlReporter html;
	public ExtentReports extent;
	public ExtentTest test;
	public String status, testcasename, testcasedescription, url;
	public static String destination;

	@BeforeMethod
	public void chromebrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void htmlreportgenerator() {
		html = new ExtentHtmlReporter("./reports/thursdayresult001.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	@AfterTest
	public void teststep() throws IOException {
		try {
			test = extent.createTest(testcasename, testcasedescription);	
			test.assignAuthor("Anand");
			test.assignCategory("sanity");
			
			takesnapshot(testcasename);


		} catch (Exception e) {
			System.out.println("After method not executed successfully");
		}

		reportclose();
	}

	@AfterSuite
	public void browserclose() {
		driver.quit();
		//driver.close();
	}

	public void takesnapshot(String testcase) throws IOException {
		DateFormat df = new SimpleDateFormat("MMddyyyyHHmmss");
		Date d = new Date();
		String number = df.format(d);

		destination = "./reports/images/" + testcase + number + ".jpg";
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(destination));
		} catch (WebDriverException e) {
			System.out.println("Webdriver exception occured while taking screenshot - " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Folder not found exception occured while takign screenshot- "+ e.getMessage());
		}

		if (status.equalsIgnoreCase("pass")) {
			test.pass("Testcase passed successfully", MediaEntityBuilder
					.createScreenCaptureFromPath("./../reports/images/" + testcase + number + ".jpg").build());
		} else {
			test.fail("Testcase failed", MediaEntityBuilder
					.createScreenCaptureFromPath("./../reports/images/" + testcase + number + ".jpg").build());
		}
	}

	public void reportclose() {
		extent.flush();
	}

	/*
	 * public void spectrumlogin() throws ArithmeticException{
	 * 
	 * driver.get("https://uat.impacloans.com/home");
	 * driver.findElementByLinkText("Login").click();
	 * if(driver.getTitle().contains("SPECTRUM")){
	 * 
	 * status= "pass"; } else{ status ="fail"; } }
	 */

	/*
	 * public void iebrowser() { System.setProperty("webdriver.ie.driver",
	 * "./drivers/IEDriverServer.exe"); driver = new InternetExplorerDriver();
	 * driver.manage().window().maximize(); }
	 */

}
