package createopportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC17 {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		login();
		clickOpportunitiesLink();
		clickOptyPipeline();
		driver.close();
	}

	public static void login() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("deepika@mh.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password@123");
		
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
		
		}
	
	public static void clickOpportunitiesLink() {
		
		//waitforVisibility(close,15);
		
		WebElement elementOpty = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		waitforVisibility(elementOpty,15);
		elementOpty.click(); 
		
	}
	
	
	public static void clickOptyPipeline() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		close.click();
		
		WebElement elementOptyPipeline = driver.findElement(By.xpath("//a[normalize-space()='Opportunity Pipeline']"));
		elementOptyPipeline.click();
	}
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}

	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}
}

