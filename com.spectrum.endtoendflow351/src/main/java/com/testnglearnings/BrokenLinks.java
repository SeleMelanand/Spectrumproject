package com.testnglearnings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	public RemoteWebDriver driver;

	@Test
	public void brokenlink() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.impacloans.com/home");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElementByLinkText("Login").click();
		driver.findElementById("UserName").sendKeys("Anand.S");
		driver.findElementById("Password").sendKeys("Demo@1234");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement loginbutton = driver.findElementByXPath("//span[text()='Login']");
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		
		Actions actionsubmit = new Actions(driver);
		actionsubmit.moveToElement(loginbutton).perform();
		loginbutton.click();
		Thread.sleep(4000);
		List<WebElement> linklist = driver.findElementsByTagName("a");
		
		for (WebElement linkelement : linklist) {
			String url = linkelement.getAttribute("href");
			System.out.println(url);
			
			
		}
		
		
		
		
	}

}
