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
import com.salesforce.pages.RandomScenariosPage;
import com.salesforce.pages.UserMenuDropDownPage;
import com.training.log.Log;

public class RandomScenariosTest extends BaseTest{
	


	WebDriver driver;
	CreateOpportunityPage createOptyPage;
	LoginPage loginPage;
	RandomScenariosPage randomScenariosPage;
	UserMenuDropDownPage userDropDownPage;
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String url){
		driver = getDriver();
		driver.get(url);
		createOptyPage = new CreateOpportunityPage(driver);
		loginPage = new LoginPage(driver);
		randomScenariosPage = new RandomScenariosPage(driver);
		userDropDownPage = new  UserMenuDropDownPage(driver);
		DOMConfigurator.configure("log4j.xml");
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC33(String username,String password) {
		Log.startTestCase("TC33");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		randomScenariosPage.clickHomeTab();
		randomScenariosPage.clickClose();
		randomScenariosPage.clickUserName(driver);
		
		
	}

	@Test
	@Parameters({"username","password"})
	public void TC34(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		randomScenariosPage.clickHomeTab();
		randomScenariosPage.clickClose();
		randomScenariosPage.clickOnUserName();
		randomScenariosPage.clickEditProfile();
		
		userDropDownPage.clickAboutTab(driver);
		userDropDownPage.enterAboutTabLastName("Abcd");
		userDropDownPage.clickSaveAll();
		
		randomScenariosPage.validateTC34();
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC35(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		//Validate to check Opportunities is there in Tab
		Log.info("validateAllTab");
		//randomScenariosPage.validateAllTab();
		//randomScenariosPage.clickAllTab();
		//If Opportunities there then remove the tab
		Log.info("clickAllTab");
		userDropDownPage.clickAllTab();
		Log.info("clickCustomizeMyTabsButton");
		randomScenariosPage.clickCustomizeMyTabsButton();
		randomScenariosPage.clickRemoveSelectedTab("Opportunities");
		randomScenariosPage.clickSave();
		//Logout
		userDropDownPage.userMenu();
		userDropDownPage.logout();
		//Check Opportunities tab removed
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		randomScenariosPage.validateTC35();
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC36(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		randomScenariosPage.clickHomeTab();
		randomScenariosPage.clickClose();
		randomScenariosPage.validateNameDate();
		randomScenariosPage.clickDateLink();
		randomScenariosPage.validateCalanderPage(driver);
		randomScenariosPage.click8PM();
		randomScenariosPage.validateClick8PMPage(driver);
		randomScenariosPage.checkCursorInSubject(driver);
		randomScenariosPage.clickSubjectComboBoxBtn();
		randomScenariosPage.clickOthersInComboBoxWindow(driver);
		randomScenariosPage.clickEndTime();
		randomScenariosPage.clickSaveCalender();
		randomScenariosPage.validateTC36();
	}

	@Test
	@Parameters({"username","password"})
	public void TC37(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		randomScenariosPage.clickHomeTab();
		randomScenariosPage.clickClose();
		randomScenariosPage.validateNameDate();
		randomScenariosPage.clickDateLink();
		randomScenariosPage.validateCalanderPage(driver);
		randomScenariosPage.click4PM();
		randomScenariosPage.validateClick4PMPage(driver);
		randomScenariosPage.checkCursorInSubject(driver);
		randomScenariosPage.clickSubjectComboBoxBtn();
		randomScenariosPage.clickOthersInComboBoxWindow(driver);
		randomScenariosPage.clickEndTime();
		randomScenariosPage.checkRecurrence();
		randomScenariosPage.validateCheckRecurrence();
		randomScenariosPage.selectWeeklyRadioBtn();
		randomScenariosPage.validateWeeklyRadioBtn();
		randomScenariosPage.validateCurrentDayOfWeek(driver);
		randomScenariosPage.enterEndDate();
		randomScenariosPage.clickSaveCalender();
		randomScenariosPage.validateTC37();
		randomScenariosPage.clickMonthView();
		randomScenariosPage.validateMonthView();
		
		
	}
	
	@AfterMethod
	public void teardown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}

}
