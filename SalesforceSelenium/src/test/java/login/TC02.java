package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TC02 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
			login();
		
			title();
		
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
	
	public static void title() throws InterruptedException {
			Thread.sleep(5000);
			//Validate
			String ActualText = driver.getTitle();
			System.out.println(ActualText);
			String ExpectedText = "Home Page ~ Salesforce - Developer Edition";
			compareText(ActualText ,ExpectedText);
		
	}
	
	
	public static void compareText(String ActualText, String ExpectedText) {
		
		Assert.assertEquals(ActualText, ExpectedText);
		driver.close();
	}
}
