package createaccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13 {
	static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException {

		login();
		account();
		clickMergeAccount();
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
		
		Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		//waitforVisibility(close,15);
		
		close.click();
	
	}
	public static void clickMergeAccount() {
		
		WebElement mergeAccount = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		waitforVisibility(mergeAccount,10);
		mergeAccount.click();
		
		WebElement enterTextInMergeField = driver.findElement(By.id("srch"));
		waitforVisibility(enterTextInMergeField,10);
		enterTextInMergeField.sendKeys("Testing");
		
		WebElement findAccountsBtn = driver.findElement(By.name("srchbutton"));
		findAccountsBtn.click();
		
		List<WebElement>  list = driver.findElements(By.xpath("//table[@class='list']/tbody/tr"));
		
		for(WebElement element:list) {
			
			
				String strList = element.getText();
				System.out.println(strList);
				
			
		}
		
		driver.findElement(By.xpath("//*[@id=\"cid0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"cid1\"]")).click();
		
		WebElement elementNext = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		elementNext.click();
		
		WebElement elementMerge = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
		waitforVisibility(elementMerge,10);
		elementMerge.click();
		
		driver.switchTo().alert().accept();
		
	}
	
	


	//wait
	
		public static void waitforVisibility(WebElement element, int time) {
			
			
			
			WebDriverWait wait = new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			
			
		}
	
}
