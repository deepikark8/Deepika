package createaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		login();
		account();
		lastActivity();
		dateField();
		saveReport();
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
	public static void account() throws InterruptedException {
		Thread.sleep(5000);
		//WebElement elemnet = driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']"));
		
		WebElement element = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		
		waitforVisibility(element,5);
		element.click();
		
		Thread.sleep(10000);
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		//waitforVisibility(close,15);
		close.click();
	}
	
	public static void lastActivity() {
		WebElement eleemntLastActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		waitforVisibility(eleemntLastActivity,10);
		eleemntLastActivity.click();
		
		
	}
	public static void dateField() {
		
		WebElement elementDateField = driver.findElement(By.xpath("//*[@id=\"ext-gen20\"]"));
		waitforVisibility(elementDateField,15);
		elementDateField.click();
		
		//elementDateField.click();
		WebElement elementFromDate = driver.findElement(By.xpath("//*[@id=\"ext-gen152\"]"));
		waitforVisibility(elementFromDate,15);
		elementFromDate.click();
		
		WebElement elementToday = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		waitforVisibility(elementToday,15);
		elementToday.click();
		
		WebElement elementSave = driver.findElement(By.xpath("//*[@id=\"ext-gen49\"]"));
		waitforVisibility(elementSave,5);
		elementSave.click();
		
	}
	
	public static void saveReport() {
		
		WebElement elementReportName = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_reportNameField\"]"));
		waitforVisibility(elementReportName,10);
		elementReportName.sendKeys("New Test Report March20");
		
		WebElement elementReportUniqueName = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_DeveloperName\"]"));
		waitforVisibility(elementReportUniqueName,10);
		elementReportUniqueName.click();
		
		
		WebElement elementSaveAndRun = driver.findElement(By.xpath("//*[@id=\"ext-gen297\"]"));
		waitforVisibility(elementSaveAndRun,10);
		Actions actions = new Actions(driver);
		actions.moveToElement(elementSaveAndRun).click().build().perform();
		//elementSaveAndRun.click();
		
		
		
			
	}
	
	
	
	//wait
	
	public static void waitforVisibility(WebElement element, int time) {
			
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
}
