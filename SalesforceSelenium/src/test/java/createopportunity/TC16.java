package createopportunity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC16 {

	static WebDriver driver;
	public static void main(String[] args) {
		
		login();
		clickAllTab();
		clickOnNewOpty();
		newOptyEdit();
		clickCloseDate();
		enterStage();
		eneterProbability();
		enterLeadSource();
		enterPrimaryCampaignSource();
		clickSave();
		validationTC16();
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
	
public static void clickAllTab() {
	
		
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
		

	        WebElement elementOpty = driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']"));

	        //This will scroll the page Horizontally till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", elementOpty);
	        elementOpty.click();
	        
	        WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
			close.click();
	}
	
	public static void clickOnNewOpty() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		WebElement elementNew = driver.findElement(By.xpath("//input[@title='New']"));
		elementNew.click();
		
	}
	
	public static void newOptyEdit() {
		
		WebElement optyName = driver.findElement(By.id("opp3"));
		optyName.sendKeys("Automation testing");
		
		WebElement optyAccountNameSelect = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		optyAccountNameSelect.click();
	

		// Store the current window handle
				String winHandleBefore = driver.getWindowHandle();
				
				
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					//driver.switchTo().window(winHandle);
					System.out.println("winHandle :"+winHandle);
					
					if(!winHandle.equals(winHandleBefore)) {
						//System.out.println("!winHandle.equals(winHandleBefore)"+!winHandle.equals(winHandleBefore));
						driver.switchTo().window(winHandle);
						try {
							Thread.sleep(6000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						WebElement iframeSelect = driver.findElement(By.xpath("//frame[@title='Search']"));
						driver.switchTo().frame(iframeSelect);
						
						WebElement elementSearch = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
						elementSearch.sendKeys("Apple");
						
						WebElement elementGo = driver.findElement(By.name("go"));
						elementGo.click();
						driver.switchTo().defaultContent();
						WebElement iframeResult = driver.findElement(By.id("resultsFrame"));
						waitforVisibility(iframeResult,15);
						driver.switchTo().frame(iframeResult);
						
						WebElement elementSelected = driver.findElement(By.xpath("//a[@class=' dataCell ']"));
						elementSelected.click();
						
					}
				}
				driver.switchTo().window(winHandleBefore);
				
	}
	public static void clickCloseDate() {

		WebElement elemenetCloseDate = driver.findElement(By.cssSelector("input[name='opp9']"));
		elemenetCloseDate.click();
		String sDay = "6";
	    driver.findElement(By.xpath("//td[@class='weekday'][normalize-space()='"+sDay+"']")).click();
	}
	public static void enterStage() {
	
		WebElement elementStage = driver.findElement(By.id("opp11"));
		Select select = new Select(elementStage);
		select.selectByVisibleText("Needs Analysis");
		
	}
	public static void eneterProbability() {
		WebElement elementProbability = driver.findElement(By.id("opp12"));
		elementProbability.click();
		elementProbability.clear();
		elementProbability.sendKeys("40");
	}
	public static void enterLeadSource() {
		WebElement elementLeadSource = driver.findElement(By.id("opp6"));
		Select select = new Select(elementLeadSource);
		select.selectByVisibleText("Phone Inquiry");
	}
	public static void enterPrimaryCampaignSource() {
	
		WebElement elementPrimaryCampaign = driver.findElement(By.id("opp17"));
		elementPrimaryCampaign.sendKeys("");
	}
	public static void clickSave() {
		
		WebElement elementSave = driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@title='Save']"));
		elementSave.click();
	}
	public static void validationTC16() {
		String actualText =  driver.getTitle();
		String expectedTxet = "Opportunity: Automation testing ~ Salesforce - Developer Edition";
		compareText(actualText,expectedTxet);
	}
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}

	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}
	
}
