package com.parallelexecution;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase003 extends InvokeBrowsers{
	
	@BeforeClass
	public void testcasedata() {
		testcasename="tc003sandstar";
		testcasedescription = "launching sandstar site";
		url="https://www.sandstar.us/Account/LogOn?ReturnUrl=%2fHome";
	}
	
		@Test
		public void sandstar() throws IOException{
			
			driver.get(url);
			String ab = driver.findElementByXPath("//div[@class='item active']/h3").getText();
			if(ab.contains("Management")){
				status="pass";
			}
			else
			{
				status="fail";

			}
		}

		
		
		
		/*chromebrowser();
		driver.get("https://uat.impacloans.com/home");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElementByLinkText("Login").click();
		driver.findElementById("UserName1").sendKeys("Anand.S");
		driver.findElementById("Password").sendKeys("Demo@1234");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement loginbutton;
		loginbutton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//form[@name='material_login_form']/fieldset/button/span")));
		loginbutton.click();
		Thread.sleep(2000);

		System.out.println(driver.findElementByXPath("//span[text()='Quick Pricer']").getText());
	*/
}

