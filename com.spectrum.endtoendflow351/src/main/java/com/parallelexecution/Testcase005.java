package com.parallelexecution;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Testcase005 {
	
	/*HashMap-- contians only unique elements
	 * stores values - key & value pair 
	 * may have one or many null value
	 * maintains no order  
	 */
	//@Test
	public void mapdemo(){
		
		HashMap<Integer, String> hm =  new HashMap<Integer, String>();
		hm.put(101, "Anand");
		hm.put(102, "Anbu");
		hm.put(103, "Stephen");
		
		System.out.println(hm.get(102));
		
		System.out.println(hm);
		hm.remove(101);
		System.out.println(hm);
		
		hm.put(104, "Guna");
		System.out.println(hm);
		
	}
	
	/*@Test
	public void alertscreenshot() throws InterruptedException, HeadlessException, AWTException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		WebElement framelement = driver.findElementById("iframeResult");
		driver.switchTo().frame(framelement);
		Thread.sleep(3000);

		String textvalue = driver.findElementByXPath("//body[@contenteditable='false']/p").getText();
		System.out.println(textvalue);
		
		driver.findElementByXPath("//button[text()='Try it']").click();
		Thread.sleep(3000);
		String value = driver.switchTo().alert().getText();
		System.out.println(value);
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		try {
			ImageIO.write(image, "jpeg", new File("./reports/alert.jpeg"));
		} catch (IOException e) {
			System.out.println("Exception occured : "+ e);
		}
		
	}*/
	
	@Test
	public void launchexternalprogram(){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("mspaint.exe");
		} catch (IOException e) {
			System.out.println("Exception occured - "+e);
		}
	}
	

}
