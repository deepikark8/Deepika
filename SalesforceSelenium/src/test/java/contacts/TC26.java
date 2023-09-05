package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC26 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		clickContactTab();
		clickCreateNewViewLink();
		login();
		clickContactTab();
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
	public static void clickCreateNewViewLink() {
		WebElement elementCreateNewViewLink = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		elementCreateNewViewLink.click();
		
		WebElement elementViewName = driver.findElement(By.id("fname"));
		elementViewName.sendKeys("Automation Testing");
		
		WebElement elementUniqueName = driver.findElement(By.name("devname"));
		elementUniqueName.click();
		
		WebElement elementSave = driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		elementSave.click();
		
	}
	
	
	
	/*public static void validateTC26() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement elementContactsDropDown = driver.findElement(By.id("fcf"));
		Select select = new Select(elementContactsDropDown);
	
		WebElement o = select.getFirstSelectedOption();
	      String strText = o.getText();
		
		System.out.println("strText : "+ strText);
		
	}*/
	
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertEquals(ActualText, ExpectedText);
	}
	
}
