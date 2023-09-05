package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.salesforce.utilities.CommonUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	String sGetValue;
	
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
		
	}
	
	public String getDataFromPropertyFile(String sKey) {
		
		
		try {
			sGetValue = commonUtilities.getPropertyFile(sKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sGetValue;
		
	}
	


	public void takeScreenShot(WebDriver driver,String sTestCaseName) {
		
		//Take screen interface is used to take screenshot by passing the driver
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
	
		//we need convert screenshot object convert into file so we convert it into source file but we don't know where it will store
		//It will be in the memory to bring it into physical file we need another destination file
		
		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(currentDate);
		
		
		String filePath = "/Users/rahade/eclipse-workspace4/SalesforceTestNGFramework/Screenshots/"+sTestCaseName+"-"+timeStamp+".jpeg";
		
		//I'll create destination file to store screenshot object
		File desFile = new File(filePath);
		
		//Then using file utilties copy file ... convert the file object to a physical file
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
