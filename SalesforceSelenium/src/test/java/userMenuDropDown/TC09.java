package userMenuDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC09 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		login();
		
		userMenu();
		
		logout();
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
	
	public static void userMenu() throws InterruptedException {
		Thread.sleep(5000);
	
		WebElement  userMenu= driver.findElement(By.id("userNavLabel"));
		waitforVisibility(userMenu,10);

		
	}
	
	public static void logout() throws InterruptedException {
	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		
	}
	
	
	//Wait
			public static void waitforVisibility(WebElement element, int time) {
				
				WebDriverWait wait = new WebDriverWait(driver,time);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				
				
				
			}


}
