package randomScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC35 {
	
	static WebDriver driver;
	public static void main(String[] args) {
		login();
		validateAllTab();
		clickAllTab();
		clickCustomizeMyTabsButton();
		clickRemoveSelectedTab("Opportunities");
		clickSave();
		
		logout();
		login();
		validateTC35();
		
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
	
	public static void validateAllTab() {
		System.out.println("allTab");
		
		WebElement element = driver.findElement(By.id("tabBar"));
		String sText = element.getText();
		System.out.println("sText :"+sText);
		
		List<WebElement> elementsTab =driver.findElements(By.id("tabBar"));
		for(WebElement ele:elementsTab) {
			System.out.println(ele.getText());
			String sTabName = ele.getText();
			if(sTabName.equalsIgnoreCase("Opportunities")) {
				System.out.println("Opportunity is present");
			}else {
				System.out.println("Opty is not thr");
				clickAllTab();
				clickCustomizeMyTabsButton();
				addTab();
				
			}
		}
		
		WebElement elementAllTab = driver.findElement(By.xpath("//a[@href='/home/showAllTabs.jsp']"));
		elementAllTab.click();
		
	}
	public static void clickAllTab() {
		WebElement elementAllTab = driver.findElement(By.xpath("//a[@href='/home/showAllTabs.jsp']"));
		elementAllTab.click();
	}
	
	public static void clickCustomizeMyTabsButton() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement elementCustomizeAllTabs = driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		elementCustomizeAllTabs.click();
	}
	
	public static void addTab() {
		WebElement element = driver.findElement(By.id("duel_select_0"));
		Select select = new Select(element);
		select.selectByVisibleText("Opportunities");
		
		WebElement eleAdd = driver.findElement(By.id("duel_select_0_right"));
		eleAdd.click();
		
		WebElement eleSave = driver.findElement(By.xpath("//input[@title='Save']"));
		eleSave.click();
	}
	
	
	public static void clickRemoveSelectedTab(String sText) {
		
		WebElement eleemntSelectedTab =  driver.findElement(By.id("duel_select_1"));
		Select select = new Select(eleemntSelectedTab);
		select.selectByVisibleText(sText);
		
		WebElement elementRemoveBtn = driver.findElement(By.xpath("//img[@title='Remove']"));
		elementRemoveBtn.click();
	}
	
	public static void clickSave() {
		
		WebElement elementClickSave = driver.findElement(By.name("save"));
		elementClickSave.click();
	}
	
	public static void logout() {
		WebElement  userMenuDropDown = driver.findElement(By.id("userNavLabel"));
		waitforVisibility(userMenuDropDown,10);
		userMenuDropDown.click();
		WebElement selectfromDropDown = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		selectfromDropDown.click();
	}
	
	public static void validateTC35() {
//		WebElement eleementTabBar = driver.findElement(By.xpath("//ul[@class='zen-inlineList zen-tabMenu']"));
//		String Text = eleementTabBar.getAttribute("title");
//		System.out.println("Text : "+Text);
	}
	
	public static void waitforVisibility(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
