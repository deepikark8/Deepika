package userMenuDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC06 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		login();
		userMenu();
		myProfile();
		editMyProfile();
		about();
		post();
		typePost();
		file();
		addPhoto();
		driver.close();
		
		
		
	}

	public static void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://teka-dev-ed.develop.my.salesforce.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		username.sendKeys("deepika@mh.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("password@123");
		
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
		
	}
	
	public static void userMenu() {
		
		
		WebElement  userMenu= driver.findElement(By.id("userNavLabel"));
		waitforVisibility(userMenu,10);
		userMenu.click();
		
		
		
		}
	
	
	public static void myProfile() throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement userProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		waitforVisibility(userProfile,5);
		userProfile.click();
			
		
	}
	
	public static void editMyProfile() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebElement editProfile = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		waitforVisibility(editProfile,10);
		editProfile.click();
			
	}
	
	public static void about() throws InterruptedException {
		
		Thread.sleep(5000);
		
		 
		 
		 
		 WebElement about = driver.findElement(By.id("contactInfoContentId"));
		 driver.switchTo().frame(about);
		 
		 WebElement aboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		 
		 aboutTab.click();
		 
		 WebElement lastName = driver.findElement(By.id("lastName"));
		 lastName.clear();
		 lastName.sendKeys("Ram");
		 
		 WebElement saveAll = driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		 saveAll.click();
	
		
		
	}
	
	
	public static void post() throws InterruptedException {
		Thread.sleep(5000);
		
		WebElement post = driver.findElement(By.xpath("//a[@title='Post']"));
		//waitforVisibility(post,5);
		post.click();
		
		
	}
	
	
	public static void typePost() throws InterruptedException {
		Thread.sleep(5000);
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
		driver.switchTo().frame(iframe);
		
		
		
		WebElement postMsg = driver.findElement(By.xpath("//body[contains(text(),'Share')]"));
		waitforVisibility(postMsg,5);
		postMsg.sendKeys("Hi Have a nice day");
	//	postMsg.click();
		
		driver.switchTo().defaultContent();
		
		
		WebElement share = driver.findElement(By.id("publishersharebutton"));
		share.click();
		
		
		
	}
	

	public static void file() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebElement file = driver.findElement(By.xpath("//span[text()='File']"));
		waitforVisibility(file,5);
		file.click();
		
		WebElement upload = driver.findElement(By.xpath("//a[contains(text(),'Upload')]"));
		upload.click();
		
		
		WebElement chooseFile = driver.findElement(By.id("chatterFile"));
		waitforVisibility(chooseFile,15);
		chooseFile.sendKeys("/Users/rahade/Documents/Personal/Tekarch/PointsToRemember/NotesToRem.rtf");
		driver.findElement(By.id("publishersharebutton")).click();
		
		
	}
	
	public static void addPhoto() throws InterruptedException {
	
		WebElement elementPhoto = driver.findElement(By.id("uploadLink"));
		waitforVisibility(elementPhoto,10);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(elementPhoto).build().perform();
		
		waitforVisibility(elementPhoto,10);
		elementPhoto.click();

		WebElement iframe = driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(iframe);
	
		WebElement choosePhoto = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		choosePhoto.sendKeys("/Users/rahade/Documents/Personal/Tekarch/Pics/1.jpg");
		
		WebElement clickSave = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		clickSave.click();
		Thread.sleep(10000);
		
		WebElement cropper1 = driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleSE']"));
		waitforVisibility(cropper1,10);
		Actions action = new Actions(driver);
		action.clickAndHold(cropper1).moveByOffset(30, 50).build().perform();
		
		WebElement cropper2 = driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleNE']"));
		waitforVisibility(cropper2,10);
		Actions action2 = new Actions(driver);
		action2.clickAndHold(cropper2).moveByOffset(30, 50).build().perform();
		
		WebElement saveCroppedImg = driver.findElement(By.id("j_id0:j_id7:save"));
		waitforVisibility(saveCroppedImg,10);
		saveCroppedImg.click();
		
		
	}
	
	
	public static void waitforVisibility(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
}
