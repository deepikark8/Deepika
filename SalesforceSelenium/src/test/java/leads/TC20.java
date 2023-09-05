package leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC20 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		clickLeadTab();
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
	
	public static void clickLeadTab() {
		
		WebElement elementLead = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		elementLead.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		close.click();
	}

}
