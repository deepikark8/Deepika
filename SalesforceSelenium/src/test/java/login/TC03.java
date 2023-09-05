package login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		login();
		logout();
		validateDisplayOfUserName();
		
	}
	
	public static void login() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("deepika@mh.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password@123");
		
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		checkbox.click();
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
		
	}
	
	public static void logout() {
		
		
		WebElement  userMenuDropDown = driver.findElement(By.id("userNavLabel"));
		waitforVisibility(userMenuDropDown,10);
		
		
		WebElement selectfromDropDown = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		selectfromDropDown.click();
		
	}
	public static void validateDisplayOfUserName() throws InterruptedException {
		//Validate
		Thread.sleep(10000);
		WebElement userName = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
		waitforVisibility(userName,5);
		String actualText = userName.getText();
		System.out.println(actualText);
		String expectedText = "deepika@mh.com";
		compareText(actualText,expectedText);
		
	}
	
	public static void compareText(String ActualText, String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
		
		driver.close();
	}
	
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	

}
