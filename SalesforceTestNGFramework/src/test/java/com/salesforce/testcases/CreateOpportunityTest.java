package com.salesforce.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.CreateOpportunityPage;
import com.salesforce.pages.LoginPage;

public class CreateOpportunityTest extends BaseTest {
	
	WebDriver driver;
	CreateOpportunityPage createOptyPage;
	LoginPage loginPage;
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String url){
		driver = getDriver();
		driver.get(url);
		createOptyPage = new CreateOpportunityPage(driver);
		loginPage = new LoginPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC15(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createOptyPage.clickOpportunities();
		createOptyPage.clickOptyMenu();
		
	}
	
	
	@Test
	@Parameters({"username","password"})
	public void TC16(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createOptyPage.clickOpportunities();
		createOptyPage.clickOnNewOpty();
		createOptyPage.newOptyEdit();
		createOptyPage.validateTC16(driver);
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC17(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createOptyPage.clickOpportunities();
		createOptyPage.clickOptyPipeline();
		createOptyPage.validateTC17(driver);
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC18(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createOptyPage.clickOpportunities();
		createOptyPage.ClickonStuckOpportunitieslink();
		createOptyPage.validateTC18(driver); 
		
		
	}

	@Test
	@Parameters({"username","password"})
	public void TC19(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createOptyPage.clickOpportunities();
		createOptyPage.clickonQuarterlySummarylink();
		createOptyPage.validateTC19(driver);
		
	}
	
	
	@AfterMethod
	public void teardown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}
}
