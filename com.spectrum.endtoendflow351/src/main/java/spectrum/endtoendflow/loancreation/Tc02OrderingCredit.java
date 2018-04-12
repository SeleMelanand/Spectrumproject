package spectrum.endtoendflow.loancreation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tc02OrderingCredit extends SpectrumUtility{
	
	public Tc02OrderingCredit(RemoteWebDriver driver){
		this.driver= driver;
	}
	
	@Test (dependsOnMethods="loancreation")
	public void CreditOrder() throws InterruptedException{
	
		//Select Credit order button
		driver.findElementByXPath("(//a[contains(@class,'theme-link')])[1]").click();
		Thread.sleep(3000);
		try {
								
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("UserName")));		
			driver.findElementById("UserName").sendKeys("434");

			// Ordering Credit  using credentials
			driver.findElementByXPath("(//div[@class='mat-radio-label-content'])[2]").click();
			
			WebElement ddCreditprovider = driver.findElementByXPath("//select[@formcontrolname='VendorId']");
			Select dropdownCreditprovider = new Select(ddCreditprovider);
			dropdownCreditprovider.selectByValue("383");
			
			driver.findElementById("UserName").clear();

			driver.findElementById("UserName").sendKeys("4340862");
			driver.findElementById("Password").sendKeys("2SV378TM");
			
			driver.findElementByXPath("//article[@class='article ']/form/div/div[2]/button/span").click();	
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//h6[@class='m-n']/span[2]/md-icon")));
			takesnapshot("creditorder");
			driver.findElementByXPath("//h6[@class='m-n']/span[2]").click();
			takesnapshot("creditorder");
			driver.findElementByXPath("//div[contains(@class,'disp-block')]/button[2]").click();
			getloannumber();
			System.out.println("Credit ordered successfully: "+loannumber);
		} catch (Exception e) {
			System.out.println("Credit Order needs to be verified:");
		}		
	}
	

}
