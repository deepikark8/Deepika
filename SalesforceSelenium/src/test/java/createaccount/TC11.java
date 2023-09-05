package createaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class TC11 {
	
		static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		login();
		account();
		createNewView();
		
		
		
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
	
	
	public static void account() throws InterruptedException {
		Thread.sleep(5000);
		
		WebElement elemnet = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		
		waitforVisibility(elemnet,5);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("tryLexDialogX")).click();
		
		
		
	}
	
	public static void createNewView() throws InterruptedException {
		
		
		WebElement createNew = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"))
				;
		waitforVisibility(createNew,5);
		
		
		driver.findElement(By.id("fname")).sendKeys("MG");
		
		driver.findElement(By.id("devname"));
		
		driver.findElement(By.name("save")).click();
	}

	public static void waitforVisibility(WebElement element, int time) {
	
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	
	}


}
