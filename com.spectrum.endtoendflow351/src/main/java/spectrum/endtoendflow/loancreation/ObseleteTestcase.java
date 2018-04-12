package spectrum.endtoendflow.loancreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ObseleteTestcase {
	public RemoteWebDriver driver;

	
	public void upload() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.impacloans.com/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByLinkText("Login").click();
		driver.findElementById("UserName").sendKeys("Anand.S");
		driver.findElementById("Password").sendKeys("Demo@1234");
		// Wait included for the Login button to get enabled
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement loginbutton;
		loginbutton = wait.until(ExpectedConditions
				.visibilityOf(driver.findElementByXPath("//form[@name='material_login_form']/fieldset/button/span")));
		loginbutton.click();
		Thread.sleep(3000);
		// Navigate to loan creation page
		driver.findElementByXPath("//div[@class='mat-button-focus-overlay']/following::div/ul[2]/li[3]/a").click();

		driver.findElementByXPath("//input[@accept='.fnm']").sendKeys("D:\\Selenium\\Projects\\com.spectrum.endtoendflow351\\fnmfile\\Conventional.fnm");
		//.click();
		Thread.sleep(5000);
		// driver.switchTo().activeElement().sendKeys("D:\Selenium\Projects\com.spectrum.endtoendflow351\fnmfile\Conventional.fnm");
		
		String folderPatH = "D:\\Selenium\\Projects\\com.spectrum.endtoendflow351\\fnmfile\\Conventional.fnm";
		String tempStr = folderPatH.replace('\\', '/');
		System.out.println(tempStr);
		StringSelection fnmpath = new StringSelection(tempStr);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fnmpath, null);
		Thread.sleep(2000);

		Robot uploadactions = new Robot();
		uploadactions.keyPress(KeyEvent.VK_ENTER);
		uploadactions.keyRelease(KeyEvent.VK_ENTER);
		
		uploadactions.keyPress(KeyEvent.VK_CONTROL);
		uploadactions.keyPress(KeyEvent.VK_V);
		uploadactions.keyRelease(KeyEvent.VK_V);
		uploadactions.keyRelease(KeyEvent.VK_CONTROL);

		uploadactions.keyPress(KeyEvent.VK_ENTER);
		uploadactions.keyRelease(KeyEvent.VK_ENTER);
		uploadactions.delay(2000);

	}
}