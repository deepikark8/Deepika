package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4A {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		forgotPassword();
		
	}

public static void login() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("deepika@mh.com");
		
		WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot Your Password?')]"));
		forgotPassword.click();
		
		
	}

	public static void forgotPassword() {
		WebElement username = driver.findElement(By.xpath("//input[@name='un']"));
		waitforVisibility(username,5);
		username.sendKeys("deepika@mh.com");
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		
		//Validate
		WebElement chekEmailPage = driver.findElement(By.xpath("//p[contains(text(),'We’ve sent you an email with a link to finish resetting your password.')]"));
		waitforVisibility(chekEmailPage,5);
		String actualText = chekEmailPage.getText();
		System.out.println(actualText);
		String expectedText = "We’ve sent you an email with a link to finish resetting your password.";
		compareText(actualText,expectedText);
	}
	
	public static void compareText(String ActualText,String ExpectedText) {
		
		Assert.assertEquals(ActualText, ExpectedText);
		driver.close();
		
		
	}


	public static void waitforVisibility(WebElement element,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		
	}
	
}
