package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC32 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		clickContactTab();
		clickNew();
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
		waitforVisibility(elementAllTab,10);
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
		
		WebElement elementNew = driver.findElement(By.name("new"));
		elementNew.click();
		
		WebElement elementLastName = driver.findElement(By.id("name_lastcon2"));
		elementLastName.sendKeys("Indian");
		
		WebElement elementAccountName = driver.findElement(By.id("con4"));
		elementAccountName.sendKeys("Global Media");
		
		WebElement elementSaveNew = driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@title='Save & New']"));
		elementSaveNew.click();
		
	}
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
