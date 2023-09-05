package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4B {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		errorMsg();
		
	}
	
	
public static void login() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("123");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("22131");
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
		
		
	}
public static void errorMsg() {
	
	//Validate
	WebElement element = driver.findElement(By.id("error"));
	waitforVisibility(element,5);
	String expectedtext = element.getText();
	System.out.println(expectedtext);
	String actualtext = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	compareText(actualtext,expectedtext);
}

public static void compareText(String actualText,String expectedText) {
	Assert.assertEquals(actualText, expectedText);
	
}

public static void waitforVisibility(WebElement element,int time) {
	
	WebDriverWait wait = new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(element));
	element.click();
}
	

}







