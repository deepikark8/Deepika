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
import com.salesforce.pages.LoginPage;
import com.salesforce.pages.UserMenuDropDownPage;
//import com.salesforce.log.Log;
import com.training.log.Log;


public class UserMenuDropDownTest  extends BaseTest{
	
	WebDriver driver;
	UserMenuDropDownPage userDropDownPage;
	LoginPage loginPage ;
	String sRandomTextForPost = RandomStringUtils.randomAlphabetic(8);
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String url) {
		 driver = getDriver();
		 driver.get(url);
		 loginPage = new LoginPage(driver);
		 userDropDownPage = new  UserMenuDropDownPage(driver);
		 DOMConfigurator.configure("log4j.xml");
		 Log.startTestCase("UserMenuDropDown");
	}
	
/*
	@Test
	@Parameters({"username","password"})
	public void TC05(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		userDropDownPage.userMenu();
		userDropDownPage.validateTC05();
	}
	*/
	
	@Test
	@Parameters({"username","password"})
	public void TC06(String username,String password) {
		
		Log.info("enterUsername passed");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		Log.info("userMenu passed");
		userDropDownPage.userMenu();
		Log.info("myProfile passed");
		
		userDropDownPage.myProfile();
		
		//AboutTab
		userDropDownPage.editMyProfile(driver);
		userDropDownPage.clickAboutTab(driver);
		userDropDownPage.enterAboutTabLastName("Ram");
		userDropDownPage.clickSaveAll();
		Log.info("About Tab passed");
		
		//Post
		userDropDownPage.post();
		userDropDownPage.typePost(driver,sRandomTextForPost);
		userDropDownPage.clickSharePost();
		Log.info("Share Post passed");
		
		//File
		userDropDownPage.file();
		userDropDownPage.uploadFile();
		userDropDownPage.clickChooseFile();
		userDropDownPage.clickShareFile();
		Log.info("Share file passed");
		
		//Photo
		Log.info("To Upload Photo");
		userDropDownPage.addPhotoMouseOver(driver);
		userDropDownPage.clickUploadPhoto();
		userDropDownPage.choosePicToUpload(driver);
		userDropDownPage.clickSavePhoto();
		userDropDownPage.cropPhoto(driver);
		userDropDownPage.saveCroppedImg();
		userDropDownPage.validateTC06();
	
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC07(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		userDropDownPage.userMenu();
		userDropDownPage.mySettings();
		userDropDownPage.clickMyPersonallink();
		userDropDownPage.clickLoginHistory();
		userDropDownPage.downloadLoginHistory();
		userDropDownPage.displayLayout();
		userDropDownPage.customizeTab();
		userDropDownPage.clickDropDown();
		userDropDownPage.clickAddReports();
		userDropDownPage.clickSaveReport();
		userDropDownPage.clickEmail(driver);
		userDropDownPage.enterEmailName();
		userDropDownPage.enterEmailAddress();
		userDropDownPage.clickSaveBtn();
		userDropDownPage.calender();
		userDropDownPage.clickActivityReminders();
		userDropDownPage.clickOpenaTestReminder();
		userDropDownPage.validateTC07(driver);
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC08(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		userDropDownPage.userMenu();
		userDropDownPage.developerConsole();
		userDropDownPage.popWindowOpens(driver);
		userDropDownPage.validateTC08(driver,"Developer Console");
		//userDropDownPage.closePopUpWindow(driver);
	}
	
	@Test
	@Parameters({"username","password"})
	public void TC09(String username, String password) {
	
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		userDropDownPage.userMenu();
		userDropDownPage.logout();
		userDropDownPage.validateTC09();		
	}
	

	@AfterMethod
	public void teardown(Method method) {
		System.out.println("Test name: " + method.getName());
		String sTestCase = method.getName();
		takeScreenShot(driver,sTestCase);
		driver.close();
	}
	

}
