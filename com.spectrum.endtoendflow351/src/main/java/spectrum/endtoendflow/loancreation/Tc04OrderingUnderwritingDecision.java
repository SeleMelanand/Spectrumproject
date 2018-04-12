package spectrum.endtoendflow.loancreation;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tc04OrderingUnderwritingDecision extends SpectrumUtility{
	
	public Tc04OrderingUnderwritingDecision(RemoteWebDriver driver){
		this.driver= driver;
	}
		
	@Test(dependsOnMethods="CreditOrder") 
	public void underwritingdecision() throws InterruptedException{

		/*browserlaunch();
		spectrumlogin();	
		driver.findElementByXPath("(//i[contains(@class,'btn-icon-lg')])[3]").click();
		driver.findElementById("overlay-search-input").sendKeys("3111006579",Keys.ENTER);
		
		Thread.sleep(5000);
		driver.findElementByXPath("//li[@class='search-item']/span").click();
		String loantype  ="iQM";*/
		
		// till this line above code needs to be removed when it is merged to other testcases
		//Mainly this sleep is given to make system generate the MISMO file after credit is ordered.
		Thread.sleep(4000);

		getloantype();
		driver.findElementByXPath("(//a[contains(@class,'theme-link')])[3]").click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		if(loantype.equalsIgnoreCase("conventional")||loantype.equalsIgnoreCase("fha")){		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("UserName")));		
	
		driver.findElementById("UserName").sendKeys("12");
		driver.findElementById("UserName").clear();

		driver.findElementById("UserName").sendKeys("4340862");
		driver.findElementById("Password").sendKeys("2SV378TM");
		
		driver.findElementByXPath("(//button[contains(@class,'raised-button')])[1]").click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[contains(@class,'decision-info')]/div/div[5]")));
		
		takesnapshot("AUSOrder");
		driver.findElementByXPath("//span[contains(@class,'pull-right')]/md-icon").click();
		getloannumber();
		System.out.println("DU ordered Successfully: "+ loannumber);

		}else{
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//button[contains(@class,'mat-primary')])[1]/span")));
			driver.findElementByXPath("(//button[contains(@class,'mat-primary')])[1]/span").click();
			System.out.println("Out of scope");
		}
		
		Thread.sleep(2000);
		
	}
	

}
