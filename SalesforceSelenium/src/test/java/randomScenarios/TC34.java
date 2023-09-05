package randomScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC34 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		clickHomeTab();
		clickOnUserName();
		about();
		validate();
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
	
	public static void clickHomeTab() {
				
		WebElement elementHome = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		waitforVisibility(elementHome,10);
		elementHome.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		 close.click();
	}
	
	public static void clickOnUserName() {
		
		WebElement elementUserName = driver.findElement(By.cssSelector("h1[class='currentStatusUserName'] a"));
		elementUserName.click();
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement editProfile = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		waitforVisibility(editProfile,10);
		editProfile.click();
	}
	
	public static void about() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 WebElement about = driver.findElement(By.id("contactInfoContentId"));
		 driver.switchTo().frame(about);
		 
		 WebElement aboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		 
		 aboutTab.click();
		 
		 WebElement lastName = driver.findElement(By.id("lastName"));
		 lastName.clear();
		 lastName.sendKeys("Abcd");
		 
		 WebElement saveAll = driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		 saveAll.click();
		 
		 
	
	}
	
	public static void validate() {
		
		
		WebElement elementUserNameTitle = driver.findElement(By.id("tailBreadcrumbNode"));
		waitforVisibility(elementUserNameTitle,10);
		String ActualText = elementUserNameTitle.getText();
		String ExpectedText = "Deepika Abcd ";
		compareText(ActualText,ExpectedText);
	}
	
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}

}
