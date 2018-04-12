package spectrum.endtoendflow.loancreation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SpectrumUtility {
	
	public RemoteWebDriver driver;
	public String loannumber,loantype;
	int number = 0;
	
	//@BeforeMethod
	//@Test
	public void spectrumbrowser(){
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
		
		
		List<WebElement> loannum=  driver.findElementsByXPath("//span[contains(@class,'text-underline')]");
		int count = loannum.size();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[contains(@class,'text-underline')])["+count+"]")));
		takesnapshot("loginpage");
		
		WebDriverWait wait2 = new WebDriverWait(driver,240);
		wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//span[@class='nav-text'])[3]")));
		
		//Navigate to loan creation page
		driver.findElementByXPath("//div[@class='mat-button-focus-overlay']/following::div/ul[2]/li[3]/a").click();
		
		WebElement ddlpb = driver.findElementById("LoanProcessorBranch");
		Select  dropdownlpb = new Select(ddlpb);
		dropdownlpb.selectByVisibleText("Corporate");
		
		WebElement loanp = driver.findElementById("LoanProcessor");
		
		Select dropdownlp = new Select(driver.findElementById("LoanProcessor"));
		List<WebElement> loanpro = dropdownlp.getOptions();
		System.out.println(loanpro.size());
		
		for (WebElement lpr : loanpro) {
			System.out.println(lpr.getText());
			
		}
		
		
		
		
		
		
	}
	
	//@AfterMethod
	public void finalrun(){
		System.out.println("Loan created successfully");
	}
		
	public void browserlaunch() {
		// Launching chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Launching Internet Explorer
		/*
		 * System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe"); driver = new InternetExplorerDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */
	}

	public void spectrumlogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("https://uat.impacloans.com/home");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElementByLinkText("Login").click();
		driver.findElementById("UserName").sendKeys("Anand.S");
		driver.findElementById("Password").sendKeys("Demo@1234");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement loginbutton;
		loginbutton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//form[@name='material_login_form']/fieldset/button/span")));
		
		loginbutton.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[contains(@class,'text-underline')])[15]")));
		takesnapshot("loginpage");
	}

	
	public void takesnapshot(String testcase) {
		number++;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File("./reports/images/"+number + " -"+ testcase+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("Webdriver exception occured while taking screenshot");
		} catch (IOException e) {
			System.out.println("File not found exception occured while takign screenshot");
		}

	}	
		
	public void getloantype(){
		
		String lpvalue = driver.findElementByXPath("(//p[contains(@class,'s-subheader')])[2]/following::div/div[2]/div").getText();
		System.out.println(lpvalue);
		if(lpvalue.charAt(0)=='C'){
			loantype ="conventional";
		}
		else if (lpvalue.charAt(0)=='F') {
			loantype ="fha";
		}
		else if (lpvalue.charAt(0)=='V') {
			loantype ="va";

		}else{
			loantype="iQM";
		}
		System.out.println(loantype);
	}
	
	public void getloannumber(){
		loannumber = driver.findElementByXPath("//span[contains(@class,'col-blue')]").getText();
		System.out.println("Loan created successfully: "+ loannumber);
	}
	

}
