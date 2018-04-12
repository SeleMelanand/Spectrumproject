package com.pacakage.javaverification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class verificationClass {
	
	@Test
	public void verify(){
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		driver.switchTo().frame("iframeResult");
		WebElement alertbutton = driver.findElementByXPath("//body[@contenteditable='false']/button");
		alertbutton.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(alertbutton));*/
		
		
		String inputval = "67254"; // 24567
		int inputsize = inputval.length();
		char[] ab; 
		ab = inputval.toCharArray();
		for(int i =0;i<ab.length-1;i++){
			
			int a = ab[i];
			int b = ab[i+1];
			int c;
			if(b<a){
				c=b;
				b=a;
			}else{
				b=b;
			}
			
		}
		System.out.println(ab);
		/*for(int j=0;j<ab.length;j++){
			System.out.print(ab[j]);
		}
		*/
		
	}

}
