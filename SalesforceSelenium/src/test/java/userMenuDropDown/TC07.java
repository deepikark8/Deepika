package userMenuDropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07 {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		login();
		userMenu();
		mySettings();
		personal();
		displayLayout();
		//customizeTab();
		//checkTab();
		email();
		calender();
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


	public static void userMenu() {
	
	
	WebElement  userMenu= driver.findElement(By.id("userNavLabel"));
	waitforVisibility(userMenu,10);
	
	
	
	WebElement userMenuDropDown = driver.findElement(By.id("userNav-menuItems"));
	String user = userMenuDropDown.getAttribute("title");
	System.out.println(user);
	
	}
	
	public static void mySettings() {
	
		
		WebElement mySettings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		mySettings.click();		
		
	}
	
	public static void personal() throws InterruptedException {
		Thread.sleep(5000);
		
		WebElement personalBtn = driver.findElement(By.xpath("//span[text()='Personal']"));
		personalBtn.click();
		
		driver.findElement(By.xpath("//span[text()='Login History']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Download login history')]")).click();
	}
	
	public static void displayLayout() {
		
		
		driver.findElement(By.xpath("//span[text()='Display & Layout']")).click();
		
		
	
	}
	
	public static void customizeTab() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Customize My Tabs']")).click();
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='p4']"));
		dropDown.click();
		Thread.sleep(5000);
		Select select = new Select(dropDown);
		select.selectByVisibleText("Salesforce Chatter");
		
		
		WebElement selectReports = driver.findElement(By.xpath("//select[@name='duel_select_0']"));
		Select report = new Select(selectReports);
		report.selectByVisibleText("Reports");
		
		System.out.println("testing-----");
		
		driver.findElement(By.id("duel_select_0_right")).click(); //---> add
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();//---> Save
	}
	
	public static void checkTab()  {
		
		driver.findElement(By.id("AllTab_Tab")).click();
		
		List<WebElement> elementsList = driver.findElements(By.xpath("//table[@class='detailList tabs']/tbody/tr/td[@class='dataCol reportBlock col02']/a/img"));
		
		for(WebElement element: elementsList) {
			
			System.out.println(element);
			String actualText =  element.getAttribute("title");
			String expectedText = "Reports";
			
			if(actualText.equalsIgnoreCase(expectedText)) {
				
				
				System.out.println("Textcase Passed");
			}
			
			
		}
		
	}
	
	
	public static void email() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.id("EmailSettings_font")).click();
		
		WebElement username = driver.findElement(By.id("sender_name"));
		username.clear();
		username.sendKeys("Deepika Ram");
		
		
		
		WebElement element = driver.findElement(By.id("sender_email"));
		element.clear();
		element.sendKeys("deepikark8@gmail.com");
		
		
		//Radio Button
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.name("save")).click();
				
		 
	}
	
	public static void calender() throws InterruptedException {
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//span[text()='Calendar & Reminders']")).click();
		
		WebElement calender = driver.findElement(By.id("CalendarAndReminders_font"));
		calender.click();
		
		driver.findElement(By.id("Reminders_font")).click();
		
		driver.findElement(By.id("testbtn")).click();
		
		
		
	}
	
	
	//Wait
	public static void waitforVisibility(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		
		
	}
	
}
