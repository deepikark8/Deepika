package userMenuDropDown;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

//Pass

public class TC05 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		login();
		userMenu();
	}

	public static void login() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("deepika@mh.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password@123");
		
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		
		
		}
	
	public static void userMenu() {
		
		
		WebElement  userMenu= driver.findElement(By.id("userNavLabel"));
		waitforVisibility(userMenu,10);
		userMenu.click();
		String[] arr = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		List<WebElement> userMenuDropDown = driver.findElements(By.id("userNav-menuItems"));	
		for(WebElement element:userMenuDropDown) {
			System.out.println(element.getText());
			for(int i=0; i<arr.length;i++) {
				if(element.getText().contains(arr[i])) {
			         System.out.println("Testcase passed all elements are found");		
				}
			}
		}
		
		
	
		
		
	}
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
		
		
	}
	
}
