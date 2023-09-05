package com.amazon.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.log.Log;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;


public class HomeTest extends BaseTest{
	
	WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;
	String url;
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		driver = getDriver("chrome"); 
		url = getUrl();
		driver.get(url);
		signInPage = new SignInPage(driver);
		homePage = new HomePage(driver);
		DOMConfigurator.configure("log4j.xml");
		
	}
	
	@Test
	public void enterTextInSearch() {
		
		signInPage.clickAccountsLists();
		Log.info("enter username");
		signInPage.enterUsername("ramkumara83@gmail.com");
		signInPage.clickContinue();
		Log.info("enter password");
		signInPage.enterPassword("harsha4Vardhan");
		Log.info("click sign in");
		signInPage.clickSign();
		Log.info("click search");
//		homePage.clickSearch();
//		Log.info("click product");
//		homePage.clickProduct(driver);
//		Log.info("Add to cart");
//		homePage.addToCart();
//		Log.info("Goto cart");
//		homePage.gotoCart();
//		Log.info("Delete Item in cart");
//		homePage.deleteItemInCart();
//		Log.info("click Account button");
//		homePage.clickAccountsBtn();
//		Log.info("Sign Out");
//		homePage.clickSignOut();
	}
	
	@AfterMethod
	public void tearDown(Method method) {
		
		String sTestCase = method.getName();
		takeScreenShot(sTestCase);
		driver.quit();
		
	}

}
