package com.amazon.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.amazon.base.BasePage;




public class SignInPage extends BasePage {
	
	//static WebDriver driver;
	String enterKey;
		public SignInPage(WebDriver driver) {
			
			
			super (driver); // Super keyword when we want to pass something to parent class from child class
			
			
		}
	
	
	@FindBy(xpath="//div[@id='nav-tools']//span[contains(text(),'Account & Lists')]")
	WebElement clickAccountsLists;
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement elementUsername;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement clickContinueBtn;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement elementPassword;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement clickSignIn;
	
	
	
	
	
	
		
		
//		login();
//		mouseOverToAccounts();
//		enterUsername();
//		clickContinue();
//		enterPassword();
//		clickSign();
//		clickSearch();
//		clickProduct();
//		addToCart();
//		gotoCart();
		
		//clickAccounts();
		//scrollDown();
		
	
	
	
	
	public void clickAccountsLists() {
		Actions actions = new Actions(driver);
		actions.moveToElement(clickAccountsLists).doubleClick().build().perform();
		
	}
	
	
	
	public void enterUsername(String strUsername)  {
		
		 
//		try {
//			enterKey = getValue("username");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 System.out.println("Username : "+ enterKey);
		
		System.out.println("Username : "+ strUsername);
		 elementUsername.sendKeys(strUsername);
		
		
	}
	
	public void clickContinue() {
		
		clickContinueBtn.click();
		
	}
	
	public void enterPassword(String strPassword) {
		
//		try {
//			enterKey = getValue("password");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Password : "+ strPassword);
		elementPassword.sendKeys(strPassword);
	}
	
	public void clickSign() {
		
		clickSignIn.click();
		
	}

	
}
