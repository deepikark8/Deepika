package leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC23 {
	static WebDriver driver;
	
	public static void main(String[] args) {
	
		 login();
		 clickLeadTab();
		 clickViewDropDown();
		 driver.close();
		 validateTC23(driver);
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
		
		//Validate Leads home page title
		String ExpectedText ="Leads: Home ~ Salesforce - Developer Edition";
		String ActualText = driver.getTitle();
		compareText(ActualText,ExpectedText);
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		close.click();
	}
	
	
	public static void clickViewDropDown() {
		WebElement elementListDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		
		Select select = new Select(elementListDropDown);
		select.selectByVisibleText("Today's Leads");
		
		WebElement elementGo = driver.findElement(By.xpath("//input[@title='Go!']"));
		waitforVisibility(elementGo,10);
		elementGo.click();
		
	}
	
	public static void validateTC23(WebDriver driver) {
		String actualText = driver.getTitle();
		String expectedText ="Leads ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
		
	}
	
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}

	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}
	
	
}
