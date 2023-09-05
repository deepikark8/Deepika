package com.salesforce.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.salesforce.base.BaseTest;
import com.salesforce.pages.LeadsPage;
import com.salesforce.pages.LoginPage;
import com.salesforce.pages.UserMenuDropDownPage;

public class LeadsTest extends BaseTest{
	
	WebDriver driver;
	LeadsPage leadPage;
	LoginPage loginPage;
	UserMenuDropDownPage userMenuDropDownPage;
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String url){
		driver = getDriver();
		driver.get(url);
		leadPage = new LeadsPage(driver);
		loginPage = new LoginPage(driver);
		userMenuDropDownPage = new UserMenuDropDownPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC20(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		leadPage.clickLeadTab();
		leadPage.validateTC20(driver);
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC21(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		leadPage.clickLeadTab();
		leadPage.clickListDropDown();
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC22(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		leadPage.clickLeadTab();
		leadPage.clickViewDropDown();
		leadPage.clickGo();
		
		userMenuDropDownPage.userMenu();
		userMenuDropDownPage.logout();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		leadPage.validateTC22();
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC23(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		leadPage.clickLeadTab();
		leadPage.clickViewDropDownGo();
		leadPage.validateTC23(driver);
	}

	@Test
	@Parameters({"username","password"})
	public void TC24(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		leadPage.clickLeadTab();
		leadPage.clickNew();
		leadPage.validateTC24(driver);
	}

	@AfterMethod
	public void teardown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}
}
