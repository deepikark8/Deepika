package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC31 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		login();
		clickContactTab();
		clickNewViewLink();
		clcikContact();
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
	
	public static void clickNewViewLink() {
		
		WebElement elementNewViewLink = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		elementNewViewLink.click();
		
		WebElement elementViewName = driver.findElement(By.id("fname"));
		elementViewName.sendKeys("ABCD");
		
		WebElement elementUniqueName = driver.findElement(By.id("devname"));
		elementUniqueName.sendKeys("EFGH");
		
		WebElement elementCancel = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
		elementCancel.click();
		
		
	}
	public static void clcikContact() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement elementContact = driver.findElement(By.xpath("//table[@class='list']/tbody/tr/th[1]/a"));
		String ActualText =  elementContact.getText();
		String ExpectedText = "ABCD";
		System.out.println("ActualText : "+ActualText +"  \n "+"ExpectedText :"+ExpectedText);
		//ABCD
	}
	
	public static void compareText(String ActualText,String ExpectedText) {
		Assert.assertNotEquals(ActualText,ExpectedText);
	}
	
}
