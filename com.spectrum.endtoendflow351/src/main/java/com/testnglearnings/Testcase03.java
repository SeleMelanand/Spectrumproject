package com.testnglearnings;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase03 extends InvokeBrowsers{
	
	@BeforeClass
	public void testcasedata() {
		testcasename="tc03sandstar";
		testcasedescription = "launching sandstar site";
		url="https://www.sandstar.us/Account/LogOn?ReturnUrl=%2fHome";
	}
	
		@Test(priority =3)
		public void sandstar() throws IOException{
			
			driver.get(url);
			String ab = driver.findElementByXPath("//div[@class='item active']/h3").getText();
			if(ab.contains("MANAGEMENT")){
				status="pass";
				takesnapshot(testcasename);
			}
			else
			{
				status="fail";
				takesnapshot(testcasename);

			}
			System.out.println(Thread.currentThread().getId());

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

