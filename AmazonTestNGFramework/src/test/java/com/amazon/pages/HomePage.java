package com.amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.amazon.base.BasePage;

public class HomePage extends BasePage{
	
	BasePage basePage;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement enterTextInSearchBox;
	
	
	@FindBy(xpath="//div[@class='left-pane-results-container']//span[contains(text(),' 14 pro max case')]")
	WebElement clickSearch;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")
	WebElement clickProductBtn;

	
	@FindBy(xpath="(//span[@class='a-button a-spacing-small a-button-primary a-button-icon natc-enabled'])[1]")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement gotoCartBtn;
	
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[3]/div[5]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[3]/div[1]/span[2]/span[1]/input[1]")
	WebElement deleteCart;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement mouseOverAccount;
	
	@FindBy(xpath="//span[contains(text(),'Sign Out')]")
	WebElement signOutBtn;
	
	
	public void clickSearch() {
		
		
		System.out.println("Search");
		//basePage.waitforVisibility(enterTextInSearchBox, 5);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enterTextInSearchBox.sendKeys("iPhone");
		clickSearch.click();
		
		
		
	}
	
	public void clickProduct(WebDriver driver) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("click Product");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		
		System.out.println("scroll up the page");
		
		clickProductBtn.click();
	}
	
	public  void addToCart() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("add to cart");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		addToCartBtn.click();
	}
	
	public void gotoCart() {
		System.out.println("go to cart");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		
		System.out.println("go to cart");
		
		gotoCartBtn.click();
	}
	
	public void deleteItemInCart() {
		
		System.out.println("Delete Cart");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		
		deleteCart.click();
		
	}
	
	public void clickAccountsBtn() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)", "");
		
		Actions action = new Actions(driver);
		action.moveToElement(mouseOverAccount).build().perform();
		
		
	}
	
	public void clickSignOut() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		
		Actions action = new Actions(driver);
		action.moveToElement(signOutBtn).build().perform();
		signOutBtn.click();
	}
	
	
//	
//	
//	
//	
//	
//	
//	public static void clickAccounts() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("click accounts");
//		WebElement element = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
//		element.click();
//	}
//
//	public static void scrollDown() {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("scrollDown");
//		WebElement element = driver.findElement(By.xpath("//div[@id='nav-tools']//a[contains(text(),'Sign Out')]"));
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		//js.executeScript("window.scrollBy(0,450)", element);
//		//Scroll down till the bottom of the page
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//		System.out.println("Done with scroll  Down");
//	}

}
