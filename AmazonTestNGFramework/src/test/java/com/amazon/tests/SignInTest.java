package com.amazon.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.amazon.base.BaseTest;
import com.amazon.log.Log;
import com.amazon.pages.SignInPage;


public class SignInTest extends BaseTest {
	
	WebDriver driver;
	SignInPage signInPage;
	String url;
	
	
	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(String browser) throws IOException {
		
		
		
		/*To add Chrome driver
		 * System.out.println ("Printing user dir----" +
		 * System.getProperty("user.dir"));
		 * 
		 * String userdir = System.getProperty("user.dir")+"//resources//chromedriver";
		 * userdir = userdir.replace ("//", "////"); System.out.println (" user dir--_"
		 * + userdir); System. setProperty("webdriver.chrome.driver", (userdir)); driver
		 * = new ChromeDriver(); driver.get("https://www.google.com/");
		 */
		
		
		//driver = getDriver("chrome");
		System.out.println("Browser : "+browser);
		driver = getDriver(browser); 
		
		url = getUrl();
		System.out.println("Url : "+ url);
		driver.get(url);
		DOMConfigurator.configure("log4j.xml");
				
		signInPage = new SignInPage(driver); // Parameterized constructor
		
		
	}
	
	
	@Test
	public void SignIn() {
		//Test case should contain steps and data
		/* Data can be from 
		 * - Property file
		 * - Parameters from TestNG.xml
		 * - get it form excel sheet
		 */
//		Log.info("click on Account List");
//		signInPage.clickAccountsLists();
//		Log.info("enter the username");
//		signInPage.enterUsername("ramkumara83@gmail.com");
//		signInPage.clickContinue();
//		Log.info("enterPassword");
//		signInPage.enterPassword("harsha4Vardhan");
//		signInPage.clickSign();
	}
	
	@AfterMethod
	public void teardown(Method method) {
		String sTestCase = method.getName();
		takeScreenShot(sTestCase);
		driver.quit();
	}
	

}
