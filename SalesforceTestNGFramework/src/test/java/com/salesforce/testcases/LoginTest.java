package com.salesforce.testcases;
/*
 * 
 * We are going to write the testcases
 * 
 */

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.salesforce.base.BaseTest;
import com.salesforce.pages.LoginPage;




public class LoginTest extends BaseTest {
	
	WebDriver driver ;
	LoginPage loginPage ;
	String getValue;
	
	
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String url) throws IOException {
		
		driver = getDriver();
		//getValue = getDataFromPropertyFile("url");
		//driver.get(getValue);
		driver.get(url);
		loginPage = new LoginPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	@Parameters("username")
	public void TC01(String username) {
		//getValue = getDataFromPropertyFile("username");
		//loginPage.enterUsername(getValue);
		loginPage.enterUsername(username);
		loginPage.enterNoPassword();
		loginPage.clickLogin();
		loginPage.validateTC01();
		
	}
	
	
	
	@Test
	@Parameters({"username","password"})
	public void TC02(String username,String password) {
		//getValue = getDataFromPropertyFile("username"); //--- getting value using property file
		//loginPage.enterUsername(getValue);
		
		//getValue = getDataFromPropertyFile("password");//--- getting value using property file
		//loginPage.enterPassword(getValue);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.validateTC02(driver);
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC03(String username,String password) {
//		getValue = getDataFromPropertyFile("username");
//		loginPage.enterUsername(getValue);
//		getValue = getDataFromPropertyFile("password");
//		loginPage.enterPassword(getValue);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickRememberMeCheckBox();
		loginPage.clickLogin();
		loginPage.logout();
		loginPage.validateTC03();
		
		
	}

	
	
	@Test
	@Parameters({"username"})
	public void TC4A(String username) {
//		getValue = getDataFromPropertyFile("username");
//		loginPage.enterUsername(getValue);
		
		loginPage.enterUsername(username);
		loginPage.forgotPassword(username);
		loginPage.validateTC4A();
		
	}
	
	
	@Test
	public void TC4B() {
		
		loginPage.enterUsername("123");
		loginPage.enterPassword("22131");
		loginPage.clickLogin();
		loginPage.validateTC4B();
	}
	
	
	@AfterMethod
	public void teardown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}

}
