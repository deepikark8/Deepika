package leads;

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

public class TC21 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		login();
		clickLeadTab();
		clickListDropDown();
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
	public static void clickListDropDown() {
		
		WebElement elementListDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		
		Select select = new Select(elementListDropDown);
		String[] expectedList = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};
		elementListDropDown.click();
		
		List<WebElement> options = select. getOptions();
		for(WebElement strText : options) {
			//System.out.println(strText.getText());
			for(int i=0;i<expectedList.length;i++) {
				
				if(strText.getText().equalsIgnoreCase(expectedList[i])){
					String actualText = strText.getText();
					String expectedText = expectedList[i];
					compareText(actualText,expectedText);
				}
			}
		}
	}
	
	public static void clickViewDropDown() {
		WebElement elementListDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		
		Select select = new Select(elementListDropDown);
		select.selectByVisibleText("Today's Leads");
		
	}
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}

	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}

}
