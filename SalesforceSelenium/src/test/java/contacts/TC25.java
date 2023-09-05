package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC25 {

	static WebDriver driver;
	public static void main(String[] args) {
		
		login();
		clickContactTab();
		clickNew();
		enterLastName();
		enterAccountName();
		clickSave();
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
	
public static void clickContactTab() {
		
		WebElement elementAllTab = driver.findElement(By.xpath("//a[@href='/home/showAllTabs.jsp']"));
		elementAllTab.click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		

	        WebElement elementContact = driver.findElement(By.cssSelector(".listRelatedObject.contactBlock.title"));

	        //This will scroll the page Horizontally till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", elementContact);
	        elementContact.click();
	        
	        WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
			close.click();
	}
	
	public static void clickNew() {
		WebElement elementNew = driver.findElement(By.xpath("//input[@title='New']"));
		elementNew.click();
		
		
	}
	public static void enterLastName(){
		WebElement elementLastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		elementLastName.sendKeys("Ramkumar");
	}
	public static void enterAccountName() {
//		WebElement elementAccountName = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
//		elementAccountName.click();
		
		WebElement elementAccountName = driver.findElement(By.xpath("//input[@id='con4']"));
		elementAccountName.sendKeys("Harsh");
		
	}
	public static void clickSave() {
		
		WebElement elementSave = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		elementSave.click();
		
	}
	
	
public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}

	
}
