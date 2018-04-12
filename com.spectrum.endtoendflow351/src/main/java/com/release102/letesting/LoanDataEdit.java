package com.release102.letesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanDataEdit extends Tc01LoanOrigination{
	
	public LoanDataEdit(RemoteWebDriver driver){
		this.driver= driver;
	}
	public void loandetails(String purchaseprice, String loanamount, String downpayment) throws InterruptedException{
		
		driver.findElementByXPath("(//ul[@class='nav'])[1]/li[4]/a[2]/span/span").click();
		driver.findElementByXPath("(//ul[@class='nav'])[1]/li[4]/ul/li[2]/a").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[contains(@class,'print-header')]/following::span[2]/i").click();
		
		WebDriverWait loaneditwait = new WebDriverWait(driver,50);
		//loaneditwait.until(ExpectedConditions.visibilityOf(driver.findElementById("Term")));
		loaneditwait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//select[@formcontrolname='OccupancyTypeId']")));
		
		//driver.findElementByXPath("//input[@id='PurchasePrice']")
		Actions actionpp = new Actions(driver);
		actionpp.moveToElement(driver.findElementById("PurchasePrice")).perform();
		driver.findElementById("PurchasePrice").clear();
		driver.findElementById("PurchasePrice").sendKeys(purchaseprice);
		
		Actions actiondp = new Actions(driver);
		actiondp.moveToElement(driver.findElementById("DownPayment")).perform();
		driver.findElementById("DownPayment").clear();
		driver.findElementById("DownPayment").sendKeys(downpayment);
		
		Actions actionla = new Actions(driver);
		actionla.moveToElement(driver.findElementById("LoanAmount")).perform();
		driver.findElementById("LoanAmount").clear();
		driver.findElementById("LoanAmount").sendKeys(downpayment);
		
		
		/*Actions actiondp = new Actions(driver);
		actiondp.moveToElement(driver.findElementByXPath("//input[@id='DownPayment']")).perform();
		driver.findElementByXPath("//input[@id='DownPayment']").clear();
		driver.findElementByXPath("//input[@id='DownPayment']").sendKeys(downpayment);
		
		Actions actionla = new Actions(driver);
		actionla.moveToElement(driver.findElementByXPath("//input[@id='LoanAmount']")).perform();
		driver.findElementByXPath("//input[@id='LoanAmount']").clear();
		driver.findElementByXPath("//input[@id='LoanAmount']").sendKeys(loanamount);*/
		
				
		/*driver.findElementByXPath("//input[@id='DownPayment']").clear();
		driver.findElementByXPath("//input[@id='DownPayment']").sendKeys(downpayment);
		
		driver.findElementByXPath("//input[@id='LoanAmount']").clear();
		driver.findElementByXPath("//input[@id='LoanAmount']").sendKeys(loanamount);*/
		
		
		/*driver.findElementByXPath("//input[@id='PurchasePrice']").click();
		driver.findElementByXPath("//input[@id='PurchasePrice']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='PurchasePrice']").sendKeys(purchaseprice);
		driver.findElementByXPath("//input[@id='PurchasePrice']").sendKeys(Keys.TAB);

		//Thread.sleep(3000);
		//driver.findElementByXPath("//input[@id='DownPayment']").click();
		//driver.findElementByXPath("//input[@id='DownPayment']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='DownPayment']").sendKeys(Keys.CLEAR);
		driver.findElementByXPath("//input[@id='DownPayment']").sendKeys(downpayment);
		driver.findElementByXPath("//input[@id='DownPayment']").sendKeys(Keys.TAB);
	//	Thread.sleep(3000);

		//driver.findElementByXPath("//input[@id='LoanAmount']").click();
		//driver.findElementByXPath("//input[@id='LoanAmount']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='LoanAmount']").sendKeys(Keys.CLEAR);
		driver.findElementByXPath("//input[@id='LoanAmount']").sendKeys(loanamount);
		driver.findElementByXPath("//input[@id='LoanAmount']").sendKeys(Keys.TAB);*/
	//	Thread.sleep(3000);

		driver.findElementById("MonthlyPayment").click();
		
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(2000);
	
	}
	
	public void propertydetailsedit(String propertyaddress, String propertycity, String propertystate, String propertyzipcode, String propertyyearbuit) throws InterruptedException{
		
		driver.findElementByXPath("//div[@class='box-header']/h5/i").click();
		Thread.sleep(3000);
		WebDriverWait loaneditwait = new WebDriverWait(driver,50);
		loaneditwait.until(ExpectedConditions.visibilityOf(driver.findElementById("County")));
	
		driver.findElementByXPath("//input[@id='AddressLine1']").click();
		driver.findElementByXPath("//input[@id='AddressLine1']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='AddressLine1']").sendKeys(propertyaddress);
		//Thread.sleep(3000);

		driver.findElementByXPath("//input[@id='City']").click();
		driver.findElementByXPath("//input[@id='City']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='City']").sendKeys(propertycity);
		//Thread.sleep(3000);

		driver.findElementByXPath("//input[@id='autoZip']").click();
		driver.findElementByXPath("//input[@id='autoZip']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='autoZip']").sendKeys(propertyzipcode);
		//Thread.sleep(3000);

		WebElement proprtystateelement= driver.findElementById("State");
		Select  dropdownpropertystate = new Select(proprtystateelement);
		dropdownpropertystate.selectByVisibleText(propertystate);
	
		driver.findElementByXPath("//input[@id='YrBuilt']").click();
		driver.findElementByXPath("//input[@id='YrBuilt']").sendKeys(Keys.CONTROL+"a",Keys.CLEAR);
		driver.findElementByXPath("//input[@id='YrBuilt']").sendKeys(propertyyearbuit);
		
		driver.findElementByXPath("//button[@mdtooltip='Save']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//span[@class='nav-text'])[1]").click();

	}

}
