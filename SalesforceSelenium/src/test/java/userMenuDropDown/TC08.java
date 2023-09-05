package userMenuDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		login();
		
		userMenu();
		
		developerConsole();
		
		
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
		
		
		
		WebElement userMenuDropDown = driver.findElement(By.id("userNav-menuItems"));
		String user = userMenuDropDown.getAttribute("title");
		System.out.println(user);
		
		}
	
	
	public static void developerConsole() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Developer Console']")).click();
		
		String parentWindowTitle = driver.getTitle();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		System.out.println(parentWindowTitle);
		
		
		for(String handle:driver.getWindowHandles()) {
			
			driver.switchTo().window(handle);	
			
		}
		
		System.out.println(driver.getTitle());
		String childWindow = driver.getWindowHandle();
		System.out.println(childWindow); 
		Thread.sleep(5000);
		driver.close();
		
		
//		String childWindowTitle = driver.getTitle();
//		System.out.println(childWindowTitle);
		
//		WebElement searchElement = driver.findElement(By.name("q"));
//		searchElement.sendKeys("Selenium");
		//waitforVisibility(searchElement,5);
		
		
		
	}
	
	
	//Wait
		public static void waitforVisibility(WebElement element, int time) {
			
			WebDriverWait wait = new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			
			
			
		}

}
