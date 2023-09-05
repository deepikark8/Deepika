package createaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		login();
		//tab();
		account();
		newAccount();
		accountDetails();
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
	public static void tab() {
		
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	}
	
	public static void account() throws InterruptedException {
		Thread.sleep(5000);
		//WebElement elemnet = driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']"));
		
		WebElement elemnet = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		elemnet.click();
		
//		waitforVisibility(elemnet,5);
//		
	driver.findElement(By.id("tryLexDialogX")).click();
		
	}
	
	public static void newAccount() {
		
		driver.findElement(By.name("new")).click();
	}
	
	public static void accountDetails() {
		driver.findElement(By.id("acc2")).sendKeys("California Technologies");
		
		WebElement type = driver.findElement(By.id("acc6"));
		Select report = new Select(type);
		report.selectByVisibleText("Technology Partner");
		
		WebElement customerPriority = driver.findElement(By.id("00NDm000006Mfgb"));
		Select select = new Select(customerPriority);
		select.selectByVisibleText("High");
		
		driver.findElement(By.name("save")).click();
	}
	
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}

	
}
