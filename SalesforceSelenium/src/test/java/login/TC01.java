package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 {
	
	 static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		
	}
	
	public static void login() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("deepika@mh.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("");
		
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		//Validate
		WebElement errorMsg = driver.findElement(By.xpath("//div[contains(text(),'Please enter your password')]"));
		String ActualText = errorMsg.getText();
		//System.out.println(ActualText);
		String ExpectedText = "Please enter your password.";
		compareText(ExpectedText,ActualText);
		
	}
	public static void compareText(String ExpectedText,String ActualText) {
		
		Assert.assertEquals(ActualText, ExpectedText);
		driver.close();
 
	}
	
	
	
	
}
