package com.salesforce.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.base.BasePage;

/*
 * 
 * I will store my elements and its actions
 * 
 * Every page need a driver... When we need to pass any information to parent class we use the keyword super.
 * 
 * 
 */

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver) {
		
		//When we need to pass any information to parent class we use the keyword super.
		//Parent class is BasePage
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="username")
	WebElement username;
	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginButton;
	
	@FindBy(xpath="//div[contains(text(),'Please enter your password')]")
	WebElement errorMsg;
	
	@FindBy(id="rememberUn")
	WebElement checkboxRememberMe;
	
	@FindBy(xpath="//*[@id=\"idcard-identity\"]")
	WebElement elementUserNameVerification;
	
	@FindBy(id="userNavButton")
	WebElement userNavBtn;
	
	@FindBy(id="userNavLabel")
	WebElement  userMenuDropDown;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement selectLogOutfromDropDown;
	
	@FindBy(xpath="//span[@id='idcard-identity']")
	WebElement userNameRememberMe;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Your Password?')]")
	WebElement forgotPasswordBtn;
	
	@FindBy(xpath="//input[@name='un']")
	WebElement userNameInForgotPassword;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//p[contains(text(),'We’ve sent you an email with a link to finish resetting your password.')]")
	WebElement chekEmailPage;
	
	@FindBy(id="error")
	WebElement errorElement;
	
	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/div/p[1]")
	WebElement forgotPasswordMessage;
	
	public void enterUsername(String strUsername) {
		waitforVisibility(username,15);
		username.sendKeys(strUsername);
		
	}
	
	public void enterNoPassword() {
		password.clear();
		
	}

	
	public void clickLogin() {
		waitforVisibility(loginButton,10);
		loginButton.click();
	}

	
	public void enterPassword(String strPassword) {
		password.sendKeys(strPassword);
		
	}
	
	
	public void clickRememberMeCheckBox() {
		checkboxRememberMe.click();
		
	}

	
	public void logout() {
		
		userNavBtn.click();
		waitforVisibility(userMenuDropDown,10);
		
		selectLogOutfromDropDown.click();
	}
	
	public void validateDisplayOfUserName(){
		
		username.sendKeys("Hello");
		
//		System.out.println("testing 1 ... 5....");
//		waitforVisibility(username,25);
//		
//		String actualText = userNameRememberMe.getText();
//		System.out.println(actualText);
//		String expectedText = "deepika@mh.com";
//		compareText(actualText,expectedText);
//		
	}
	
	public void forgotPassword(String strUsername) {
		forgotPasswordBtn.click();
		
		userNameInForgotPassword.sendKeys(strUsername);
		continueBtn.click();
		waitforVisibility(chekEmailPage,5);
		String ActualText = chekEmailPage.getText();
		System.out.println(ActualText);
		String expectedText = "We’ve sent you an email with a link to finish resetting your password.";
		compareText(ActualText,expectedText);
	}
	
	public void validateTC01() {
		//error message 'Please enter your password.'should be displayed
		String ActualText = errorMsg.getText();
		String ExpectedText = "Please enter your password.";
		compareText(ExpectedText,ActualText);
	}
	
	public void validateTC02(WebDriver driver) {
		
		//Home page should be displayed
		for(String handle:driver.getWindowHandles()) {
			
			driver.switchTo().window(handle);	
			
		}
		String ExpedtedText = "Home Page ~ Salesforce - Developer Edition";
		String ActualText = driver.getTitle();
		compareText(ActualText,ExpedtedText);
		
	}
	
	public void validateTC03() {
		//Validate the user name displayed in user name field
		waitforVisibility(elementUserNameVerification,15);
		String ActualText = elementUserNameVerification.getText()  ;
		//System.out.println("ActualText : "+ActualText);
		String ExpectedText = "deepika@mh.com";
		compareText(ExpectedText,ActualText);
		
	}
	public void validateTC4A() {
		//Password reset message page is displayed. An email associated with the <username> account is sent.
		String ActualText = forgotPasswordMessage.getText();
		//System.out.println("ActualText : "+ActualText);
		String ExpectedText = "We’ve sent you an email with a link to finish resetting your password.";
		compareText(ExpectedText,ActualText);
		
	}
	public void validateTC4B() {
		
		waitforVisibility(errorElement,5);
		String actualtext = errorElement.getText();
		String expectedtext = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		compareText(actualtext,expectedtext);
		
	}


}
