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
import com.salesforce.pages.ContactsPage;
import com.salesforce.pages.LoginPage;

public class ContactsTest extends BaseTest {
	
	WebDriver driver;
	LoginPage loginPage;
	ContactsPage contactsPage;
	String sRandomUniqueName = RandomStringUtils.randomAlphabetic(6);
	
	
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String url){
		driver = getDriver();
		driver.get(url);
		loginPage = new LoginPage(driver);
		contactsPage = new ContactsPage(driver);
		DOMConfigurator.configure("log4j.xml");
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC25(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickNew();
		contactsPage.enterLastName();
		contactsPage.enterAccountName();
		contactsPage.clickSave();
		contactsPage.validateTC25(driver);
		
	}

	@Test
	@Parameters({"username","password"})
	public void TC26(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickCreateNewViewLink(sRandomUniqueName);
		contactsPage.validateTC26(driver,sRandomUniqueName);
		
	}
	
	
	
	@Test
	@Parameters({"username","password"})
	public void TC27(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickRcentlyCreated();
		
	}
	
	
	@Test
	@Parameters({"username","password"})
	public void TC28(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickContactsListDropDown(driver);
		}

	@Test
	@Parameters({"username","password"})
	public void TC29(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clcikContact();
		
	}
	@Test
	@Parameters({"username","password"})
	public void TC30(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickNewViewLink();
		contactsPage.validateTC30();
		
	}
	@Test
	@Parameters({"username","password"})
	public void TC31(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickNewViewLinkHyperLink();
		contactsPage.clickContact();
		
	}

	@Test
	@Parameters({"username","password"})
	public void TC32(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		contactsPage.clickContactTab(driver);
		contactsPage.clickNew();
		contactsPage.clickEnterNewContactDetails();
		
	}
	
		
	@AfterMethod
	public void teardown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}
}
