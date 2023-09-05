package com.amazon.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utilities.CommonUtilities;

public class BaseTest {
	WebDriver driver;
	CommonUtilities utilities = new CommonUtilities();
	
	public  WebDriver getDriver(String browser) {
		System.out.println("test browser : "+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		return driver;
	}
	
	
	public String getUrl() throws IOException {
		
		String url = utilities.getProperty("url");
		return url;
		
	}
	
	public void takeScreenShot(String testcaseName) {
		utilities.takeScreenShot(driver, testcaseName);
	}

}
