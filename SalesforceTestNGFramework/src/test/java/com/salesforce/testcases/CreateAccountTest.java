package com.salesforce.testcases;

import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.CreateAccountPage;
import com.salesforce.pages.LoginPage;

public class CreateAccountTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	String sRandomTextForPost = RandomStringUtils.randomAlphabetic(6);
	String sRandomTextUniqueName = RandomStringUtils.randomAlphabetic(4);
	
	@BeforeMethod()
	@Parameters({"url"})
	public void beforeMethod(String url){
		driver = getDriver();
		driver.get(url);
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC10(String username, String password) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createAccountPage.clickAccountTab();
		createAccountPage.newAccount();
		createAccountPage.accountDetails(driver);
		createAccountPage.validateTC10(driver);
		}

	@Test
	@Parameters({"username","password"})
	public void TC11(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createAccountPage.clickAccountTab();
		createAccountPage.createNewView(sRandomTextForPost);
		createAccountPage.validateTC11(sRandomTextForPost);
	}
	
	
	@Test
	@Parameters({"username","password"})
	public void TC12(String username, String password) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createAccountPage.clickAccountTab();
		createAccountPage.viewDropDown();
		createAccountPage.editView(); 
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC13(String username,String password) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createAccountPage.clickAccountTab();
		createAccountPage.clickMergeAccount(driver);
		createAccountPage.validateTC13();
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC14(String username,String password) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		createAccountPage.clickAccountTab();
		createAccountPage.lastActivity();
		createAccountPage.dateField();
		createAccountPage.saveAndRunReport(driver,sRandomTextUniqueName);
		createAccountPage.validateTC14();
	}
	
	@AfterMethod()
	public void tearDown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}

}
