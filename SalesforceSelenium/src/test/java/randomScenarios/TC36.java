package randomScenarios;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC36 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
	 login();
	 clickHomeTab();
	 validateNameDate();
	 clickDateLink();
	 validateCalanderPage();
	 click8PM();
	 validateClick8PMPage();
	 checkCursorInSubject();
	 clickSubjectComboBoxBtn();
	 clickOthersInComboBoxWindow();
	 clickEndTime();
	 clickSave();
	 validateTC36();
	 
	 
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
		WebElement elementHomeTab = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		elementHomeTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("tryLexDialogX")).click(); 
	}
	public static void validateNameDate() {
		WebElement elementUserName = driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Deepika Abcd']"));
		String sName = elementUserName.getText();
		System.out.println("Name : "+sName);
		String actualText = sName;
		String expectedText = "Deepika Abcd";
			
		compareText(actualText,expectedText);
		
		WebElement elementDate = driver.findElement(By.xpath("//span[@class='pageDescription']"));
		String sDate = elementDate.getText();
		System.out.println("Date : "+ sDate);
		
		//Create Date Format Day Month Date,Year 
		LocalDate localDate = LocalDate.now(); // Create a date object
		DayOfWeek day = localDate.getDayOfWeek();
		Month month = localDate.getMonth();
		int date = localDate.getDayOfMonth();
	    int year = localDate.getYear();
	    String expectedDate = day+" "+month+" "+date+","+" "+year;
	    System.out.println(expectedDate);
	    if(sDate.equalsIgnoreCase(expectedDate)) {
	    	System.out.println("Current date is displayed in Day Month Date,Year format. Ex: Thursday July 18,2019");
	    }
	}
	
	public static void clickDateLink() {
		
		//table[@id='bodyTable']/tbody/tr/td[2]/div[@class='bPageTitle']/div[@id='ptBody']/ div/div[@class='content']/span[@class='pageDescription']/a
		WebElement elementDateLink = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));
		waitforVisibility(elementDateLink,10);
		elementDateLink.click();
	}
	public static void validateCalanderPage() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement elementUserName = driver.findElement(By.xpath("//h1[@class='pageType']"));
		//waitforVisibility(elementUserName,10);
		String actualText = driver.getTitle();
		System.out.println("validateCalanderPage Title :"+ actualText);
		String expectedText = "Calendar for Deepika Abcd ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	public static void click8PM() {
		
		WebElement element8PM = driver.findElement(By.xpath("//a[normalize-space()='8:00 PM']"));
		element8PM.click();
	}

	
	public static void validateClick8PMPage() {
		String expectedText = "Calendar: New Event ~ Salesforce - Developer Edition";
		String atualText = driver.getTitle();
		compareText(atualText,expectedText);
			
	}

	public static void checkCursorInSubject() {
		WebElement elementSubject = driver.findElement(By.id("evt5"));
		if(elementSubject.equals(driver.switchTo().activeElement())) {
			System.out.println("cursor is in Subject field");
		}	
	}
	
	public static void clickSubjectComboBoxBtn() {
		WebElement elementSubjectComboBoxBtn =  driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
		elementSubjectComboBoxBtn.click();
		System.out.println("clickSubjectComboBoxBtn");
		}
	
	
	public static void clickOthersInComboBoxWindow() {
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		String actualText = null;
		
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
				
				WebElement elementOther = driver.findElement(By.cssSelector("a[href='javascript:pickValue(4);']"));
				actualText = elementOther.getText();
				elementOther.click();
			}
		}
		driver.switchTo().window(winHandleBefore);
		String expectedText = "Other";
		compareText(actualText,expectedText);
		}
	
	
	public static void clickEndTime() {
		
		WebElement elementEndTime = driver.findElement(By.xpath("//input[@name='EndDateTime_time']"));
		elementEndTime.click();
		
		WebElement elementClick9 = driver.findElement(By.xpath("//div[normalize-space()='9:00 PM']"));
		elementClick9.click();
		
	}
	
	
	public static void clickSave() {
		
		WebElement elementSave = driver.findElement(By.xpath("//td[@class='pbButton']//input[@title='Save']"));
		elementSave.click();
	}
	public static void compareText(String actualText,String expectedText) {
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	public static void validateTC36() {
		WebElement elementTime = driver.findElement(By.xpath("//a[normalize-space()='8:00 PM']"));
		String actualTime = elementTime.getText();
		String expectedTime = "8:00 PM";
		compareText(actualTime,expectedTime);
		
		WebElement elementOther =driver.findElement(By.xpath("//div[@class='multiLineEventBlock dragContentPointer']/span/a/span"));
		String actualText = elementOther.getText();
		String expectedText = "Other";
		compareText(actualText,expectedText);
	}

	public static void waitforVisibility(WebElement element,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
}
