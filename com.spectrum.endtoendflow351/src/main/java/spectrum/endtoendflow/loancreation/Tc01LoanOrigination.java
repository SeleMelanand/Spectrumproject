package spectrum.endtoendflow.loancreation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tc01LoanOrigination extends SpectrumUtility{
	
	public long starttime, endtime,duration;  

	@DataProvider(name = "getdatafromexcel")
	public Object[][] getData() {
		return DataInputProvider.getSheet("loandetails","Sheet1");
	}

	@Test(dataProvider = "getdatafromexcel")
	public void loancreation(String LoanProcessorBranch,String LoanProcessor, String Loanofficerbranch, String Loanofficer, String Loantype,String Loanprogram,String fnmdocument) throws InterruptedException {
		starttime = System.currentTimeMillis();
		browserlaunch();
		spectrumlogin();		
		
		WebDriverWait wait2 = new WebDriverWait(driver,240);
		wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//span[@class='nav-text'])[3]")));
		
		//Navigate to loan creation page
		driver.findElementByXPath("//div[@class='mat-button-focus-overlay']/following::div/ul[2]/li[3]/a").click();
		
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
		//Thread.sleep(3000);
		takesnapshot("loancreation");

		/*new Tc02OrderingCredit(driver).CreditOrder();
		new Tc03Pricing(driver).pricing();
		new Tc04OrderingUnderwritingDecision(driver).underwritingdecision();*/
	}

	/*@Test(priority =2)
	public void timecalculate(){
	endtime = System.currentTimeMillis();
	duration = endtime- starttime;
	duration = duration/60000;
	System.out.println("Duration taken for loan process in spectrum:"+ duration+" minutes");
	}*/
	
	
	

}
