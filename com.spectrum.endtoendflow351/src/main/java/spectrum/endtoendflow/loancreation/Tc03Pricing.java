package spectrum.endtoendflow.loancreation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tc03Pricing extends SpectrumUtility{
	
	public Tc03Pricing(RemoteWebDriver driver){
		this.driver= driver;
	}
	@Test
	public void pricing() throws InterruptedException{
		String purchaseprice1;
		
		/*browserlaunch();
		spectrumlogin();	
		driver.findElementByXPath("(//i[contains(@class,'btn-icon-lg')])[3]").click();
		driver.findElementById("overlay-search-input").sendKeys("3111006591",Keys.ENTER);
		
		Thread.sleep(8000);
		driver.findElementByXPath("//li[@class='search-item']/span").click();
		Thread.sleep(4000);*/
		// till this line above code needs to be removed when it is merged to other testcases
		
		//retrieving the value of appraised value, purpose of loan
		try {
			Thread.sleep(2000);
			getloantype();

			driver.findElementByXPath("(//ul[@class='nav'])[1]/li[4]/a[2]/span/span").click();
			//driver.findElementByXPath("(//ul[@class='nav'])[1]/li[4]/ul/li/a/span/span").click();
			driver.findElementByXPath("(//ul[@class='nav'])[1]/li[4]/ul/li[2]/a").click();
			WebDriverWait wait1 = new WebDriverWait(driver, 25);
			wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='box-header']/h5/i")));
			
			//purchase or refinance loan retrieving the value of purchase/appraised value
			if(loantype.equalsIgnoreCase("conventional")||loantype.equalsIgnoreCase("fha")){
			String ppvalue = driver.findElementByXPath("//div[@id='summary-print-section']/div[3]/div[2]/div").getText();
			
			String intervalue = ppvalue.replace('$', ' ').trim();
			
			purchaseprice1  = intervalue.replaceAll(",", "").substring(0, intervalue.length()-4);
				
			}else{
				String ppvalue = driver.findElementByXPath("//div[@id='summary-print-section']/div[3]/div[2]/div").getText();
				String intervalue = ppvalue.replace('$', ' ').trim();
				purchaseprice1  = intervalue.replaceAll(",", "").substring(0, intervalue.length()-4);				
			}

			driver.findElementByXPath("(//a[@class='mat-button'])[1]/span/span").click();

			//Below is the code  navigating to pricing page
			wait1.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//p[@class='s-subheader'])[2]/following:: div/div[11]/label")));
			driver.findElementByXPath("(//a[contains(@class,'theme-link')])[2]").click();
			
			wait1.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//iframe[@class='pricing-frame']")));
			
			driver.switchTo().frame(driver.findElementByClassName("pricing-frame"));

			driver.findElementById("SalesAmount").clear();
			driver.findElementById("SalesAmount").sendKeys(purchaseprice1);
			driver.findElementById("AppraisalAmount").clear();
			driver.findElementById("AppraisalAmount").sendKeys(purchaseprice1);	
			driver.findElementById("CustomLenderField8").sendKeys("2");
			driver.findElementById("FICO").clear();
			driver.findElementById("FICO").sendKeys("710");
			
			
			driver.findElementById("CustomProductFilter02").click();
			driver.findElementById("CustomProductFilter02").sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			
			driver.findElementById("LORequestCompensationInPricing").click();
			driver.findElementById("LORequestCompensationInPricing").sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			
			driver.findElementById("AUS").click();
			driver.findElementById("AUS").sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);


			driver.findElementById("PrepayPenalty").click();
			driver.findElementById("PrepayPenalty").sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			
				if(loantype.equalsIgnoreCase("FHA")){
						driver.findElementById("LoanAmount").clear();
						driver.findElementById("LoanAmount").sendKeys("115000");
			
						WebElement numberofunits = driver.findElementById("NumofUnits");
						Select  ddnumberofunits = new Select(numberofunits);
						ddnumberofunits.selectByVisibleText("1 Unit");
				
						driver.findElementById("CashoutAmount").clear();
						driver.findElementById("CashoutAmount").sendKeys("0");
				}else{
						System.out.println("loan is not a fha loan hence submitting the loan");	
					}
			driver.findElementById("btnSubmit_search_bottom").click();
			
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//table[@id='ResultPanel_tblDisqualified']/tbody/tr[1]/th[1]")));
			driver.findElementByXPath("//table[@id='ResultPanel_tblQualified']/tbody/tr[3]/td[2]/a").click();
			//Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//table[@id='ResultPanel_tblQualified']/tbody/tr[4]/td/div[2]/table/tbody/tr[1]/th")));
			driver.findElementByXPath("(//div[@class='tableWrapGreen'])[2]/table/tbody/tr[4]/td[4]/a").click();
			takesnapshot("pricing");
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById("btnSubmit_Save360_TransferAndLogout_1")));
			takesnapshot("pricing");
			driver.findElementById("btnSubmit_Save360_TransferAndLogout_1").click();
			
			driver.switchTo().defaultContent();
			WebDriverWait pricingwait = new WebDriverWait(driver, 300);
			pricingwait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//a[contains(@class,'theme-link')])[5]")));	
			//pricingwait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//p[@class='s-subheader'])[2]/following:: div/div[11]/label")));
			
			driver.findElementByXPath("//section[@class='sidebar-content']/my-app-sidenav-menu/ul/li[3]/a/span/span").click();
			Thread.sleep(5000);
			driver.findElementByXPath("//section[@class='sidebar-content']/my-app-sidenav-menu/ul/li[1]/a/span/span").click();
			getloannumber();
			System.out.println("Pricing done successfully: "+ loannumber);
		} catch (Exception e) {
			System.out.println("Pricing updated, waiting for updates from Encomapss");
			driver.findElementByXPath("//section[@class='sidebar-content']/my-app-sidenav-menu/ul/li[1]/a/span/span").click();
		}

	}
}
