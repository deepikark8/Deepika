package createopportunity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC15 {
	
	static WebDriver driver;
	public static void main(String[] args) {
		login();
		//clickTab();
		clickOpportunities();
		clickOptyMenu();
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
	
	public static void clickTab() {
		
		WebElement elementTab = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		elementTab.click();
		
//		System.out.println("clickOpportunities is clicked");
//		WebElement elementOpty = driver.findElement(By.cssSelector(".listRelatedObject.opportunityBlock.title"));
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		elementOpty.click();
		
	}
	
	public static void clickOpportunities() {
		
		//waitforVisibility(close,15);
		
		WebElement elementOpty = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		waitforVisibility(elementOpty,10);
		elementOpty.click(); 
	
		
	}
	
	public static void clickOptyMenu() {
		/*
		 * Drop down with "All Oppotunities", "Closing Next Month", "Closing This Month", "My Opportunities",
		 *  "New This Week", "Recently Viewed Opportunities","Won"  should be available
		 * 
		 */
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		close.click();
		
		WebElement elementOptyMenuList = driver.findElement(By.id("fcf"));
		waitforVisibility(elementOptyMenuList,10);
		
		Select select = new Select(elementOptyMenuList);
		String[] expectedList = {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		elementOptyMenuList.click();
		
		List<WebElement> options = select. getOptions();
		for(WebElement strText : options) {
			for(int i=0;i<expectedList.length;i++) {
				
				if(strText.getText().equalsIgnoreCase(expectedList[i])){
					String actualText = strText.getText();
					String expectedText = expectedList[i];
					compareText(actualText,expectedText);
				}
			}
		}
		
		
	}
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}

	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}
}
