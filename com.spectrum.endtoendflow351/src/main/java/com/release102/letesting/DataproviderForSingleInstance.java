package com.release102.letesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import spectrum.endtoendflow.loancreation.DataInputProvider;
import spectrum.endtoendflow.loancreation.SpectrumUtility;

public class DataproviderForSingleInstance extends SpectrumUtility {

	@DataProvider(name = "testdataexcel")
	public Object[][] getData() {
			
		return DataInputProvider.getSheet("loandetails2","Sheet1");
		
	}
	
	@Test(dataProvider="testdataexcel")
	public void loancreation(String LoanProcessorBranch,String LoanProcessor, String Loanofficerbranch, String Loanofficer, 
			String Loantype,String Loanprogram,String fnmdocument) throws InterruptedException{
		spectrumlogin();		
		
		List<WebElement> loannum=  driver.findElementsByXPath("//span[contains(@class,'text-underline')]");
		int count = loannum.size();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[contains(@class,'text-underline')])["+count+"]")));
		takesnapshot("loginpage");
		
		WebDriverWait wait2 = new WebDriverWait(driver,240);
		wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//span[@class='nav-text'])[3]")));
		
		//Navigate to loan creation page
		driver.findElementByXPath("//div[@class='mat-button-focus-overlay']/following::div/ul[2]/li[3]/a").click();
		
		// intorduce the loop for the below code 
		/*int counter = DataInputProvider.rowCount;
		System.out.println("Total number of rows: "+ counter);
		
		for(int i=0;i<counter;i++){*/
		
		Thread.sleep(20000);
		WebElement ddlpb = driver.findElementById("LoanProcessorBranch");
		Select  dropdownlpb = new Select(ddlpb);
		dropdownlpb.selectByVisibleText(LoanProcessorBranch);
		
		WebElement ddlp = driver.findElementById("LoanProcessor");
		Select  dropdownlp = new Select(ddlp);
		dropdownlp.selectByVisibleText(LoanProcessor);
		
		WebElement ddlob = driver.findElementById("LoanOfficerBranch");
		Select  dropdownlob = new Select(ddlob);
		dropdownlob.selectByVisibleText(Loanofficerbranch);
		
		WebElement ddlo = driver.findElementById("LoanOfficer");
		Select  dropdownlo = new Select(ddlo);
		dropdownlo.selectByVisibleText(Loanofficer);
		
		WebElement ddloantype = driver.findElementById("MortgageType");
		Select  dropdownloantype = new Select(ddloantype);
		dropdownloantype.selectByVisibleText(Loantype);
					
		driver.findElementByXPath("//input[@formcontrolname='LoanProgramType']").click();
		driver.findElementByXPath("//input[@formcontrolname='LoanProgramType']").sendKeys(Loanprogram);
		driver.findElementByXPath("//input[@formcontrolname='LoanProgramType']").sendKeys(Keys.DOWN);
		driver.findElementByXPath("//input[@formcontrolname='LoanProgramType']").sendKeys(Keys.ENTER);
		
		driver.findElementByXPath("//input[@accept='.fnm']").sendKeys("D:\\Selenium\\Projects\\com.spectrum.endtoendflow351\\fnmfile\\"+fnmdocument+".fnm");

		driver.findElementByXPath("//button[@id='browseFNM']/following::button").click();		
		
		wait2.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[contains(@class,'col-blue')]"), "New Loan"));
		getloannumber();
		takesnapshot("loancreationsingleinstance");
		
		driver.findElementByXPath("//div[@class='mat-button-focus-overlay']/following::div/ul[2]/li[3]/a").click();
	//	}
		
		
		} 
		
	}

