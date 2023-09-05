package randomScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC33 {
	
	static WebDriver driver;
	static WebElement elementUserName;
	
	public static void main(String[] args) {
		
		login();
		clickHomeTab();
		clickUserName();
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
		
		WebElement elementUserNameInUseMenu = driver.findElement(By.id("userNavLabel"));
		waitforVisibility(elementUserNameInUseMenu,10);
		String ActualText = elementUserNameInUseMenu.getText();
		
		
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
		 //WebElement elementUserName;
		 elementUserName = driver.findElement(By.cssSelector("h1[class='currentStatusUserName'] a"));
		String ExpectedText = elementUserName.getText();
		
		compareText(ActualText,ExpectedText);
		
		
	}
	
	public static void clickUserName() {
		
		elementUserName.click();
		
		String title = driver.getTitle();
		System.out.println("title : "+title);
		
	}
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}

}
