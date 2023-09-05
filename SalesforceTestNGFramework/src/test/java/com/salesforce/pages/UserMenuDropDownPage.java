package com.salesforce.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import com.salesforce.base.BasePage;

public class UserMenuDropDownPage extends BasePage{

	public UserMenuDropDownPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	
	}
	
	@FindBy(id="userNavLabel")
	WebElement userMenuElement;
	
	@FindBy(id="userNav-menuItems")
	List<WebElement> userMenuDropDown; 
	
	
	//@FindBy(xpath="//table[@class='detailList tabs']/tbody/tr/td[@class='dataCol reportBlock col02']/a/img")
	//WebElement userMenuList;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement userProfile;
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']")
	WebElement editProfile;
	
	@FindBy(id="contactInfoContentId")
	WebElement editProfileWindowFrame;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement aboutTab;
	
	@FindBy(id="uploadLink")
	WebElement elementUploadPhoto;
	
	@FindBy(xpath="//div[@class='imgCrop_handle imgCrop_handleSE']")
	WebElement cropper1;
	
	@FindBy(xpath="//div[@class='imgCrop_handle imgCrop_handleNE']")
	WebElement cropper2;
	
	@FindBy(xpath="//iframe[@allowtransparency='true']")
	WebElement iframe ;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='zen-btn zen-primaryBtn zen-pas']")
	WebElement saveAll;
	
	@FindBy(xpath="//a[@title='Post']")
	WebElement post;
	
	@FindBy(id="uploadPhotoContentId")
	WebElement iframePhoto;
	
	@FindBy(id="j_id0:uploadFileForm:uploadInputFile")
	WebElement choosePhoto;
	
	@FindBy(xpath = "//body[contains(text(),'Share')]")
	WebElement postMsg;
	
	@FindBy(id="publishersharebutton")
	WebElement share;
	
	@FindBy(xpath="//span[text()='File']")
	WebElement file;
	
	//WebElement upload = driver.findElement(By.xpath("//a[contains(text(),'Upload')]"));
	
	
	@FindBy(xpath="//a[@title='Upload a file from your computer']")
	WebElement upload;
	
	
	
	@FindBy(id="chatterFile")
	WebElement chooseFile;
	
	@FindBy(id="publishersharebutton")
	WebElement publishShareBtn;
	
	@FindBy(id="j_id0:uploadFileForm:uploadBtn")
	WebElement clickSavePhoto;
	
	@FindBy(id="j_id0:j_id7:save")
	WebElement saveCroppedImg;
	
	@FindBy(xpath="//a[contains(text(),'My Settings')]")
	WebElement mySetting;
	
	@FindBy(xpath="//span[text()='Personal']")
	WebElement personalBtn;
	
	@FindBy(xpath="//span[text()='Login History']")
	WebElement loginHistory;
	
	@FindBy(xpath="//a[contains(text(),'Download login history')]")
	WebElement downloadLoginHistory;
	
	@FindBy(xpath="//span[text()='Display & Layout']")
	WebElement displayLayout;
	
	@FindBy(xpath="(//a[@id='CustomizeTabs_font'])[1]")
	WebElement customizeMyTab;
	
	@FindBy(xpath="//select[@id='p4']")
	WebElement dropDown;
	
	@FindBy(xpath="//select[@name='duel_select_0']")
	WebElement selectReports;
	
	@FindBy(id="duel_select_0_right")
	WebElement addReport;
	
	@FindBy(xpath="//input[@value=' Save ']")
	WebElement saveReport;
	
	@FindBy(id="AllTab_Tab")
	WebElement allTab;
	
	@FindBy(xpath="//table[@class='detailList tabs']/tbody/tr/td[@class='dataCol reportBlock col02']/a/img")
	WebElement checkTab;
	
	@FindBy(xpath="//span[text()='Email']")
	WebElement email;
	
	@FindBy(id="EmailSettings_font")
	WebElement myEmailSettings;
	
	@FindBy(id="sender_name")
	WebElement emailName;
	
	@FindBy(id="sender_email")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement AutomaticBcc;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	@FindBy(id="CalendarAndReminders_font")
	WebElement calender;
	
	@FindBy(id="Reminders_font")
	WebElement ActivityReminders;
	
	@FindBy(id="testbtn")
	WebElement OpenaTestReminder;
	
	@FindBy(xpath="//a[text()='Developer Console']")
	WebElement developerConsole;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath = "//a[@href='/home/showAllTabs.jsp']")
	WebElement elementAllTab;
	
	public void userMenu() {
		waitforVisibility(userMenuElement, 15);
		userMenuElement.click();	
	}
	
	public void myProfile(){
		waitforVisibility(userProfile, 10);
		userProfile.click();
	}
	
	public void editMyProfile(WebDriver driver) {
		waitforVisibility(editProfile,10);
		editProfile.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}
	public void clickAboutTab(WebDriver driver) {
		driver.switchTo().frame(editProfileWindowFrame);	
		waitforVisibility(aboutTab,15);
		 aboutTab.click();
	}
	
	public void enterAboutTabLastName(String sLastName) {
		 waitforVisibility(lastName,15);
		 lastName.click();
		 lastName.clear();
		 lastName.sendKeys(sLastName);
		
	}
	public void clickSaveAll() {
		 waitforVisibility(saveAll,10);
		 saveAll.click();
	}
	
	//--------- Post ---------
	public void post() {
		waitforVisibility(post,10);
		post.click();
	}
	
	public void typePost(WebDriver driver,String sRandomTextForPost) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(iframe);
		waitforVisibility(postMsg,5);
		postMsg.sendKeys(sRandomTextForPost);
		driver.switchTo().defaultContent();
		
	}
	
	public void clickSharePost() {
		waitforVisibility(share,5);
		share.click();
	}
	
	//--------- File ---------
	public void file() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitforVisibility(file,5);
		file.click();
		}
	public void uploadFile() {
		upload.click();
	}
	public void clickChooseFile() {
		waitforVisibility(chooseFile,15);
		chooseFile.sendKeys("/Users/rahade/Documents/Personal/Tekarch/PointsToRemember/NotesToRem.rtf");
	}
	public void clickShareFile() {
		publishShareBtn.click();
	}
	
	//----- Photo ------
	public void addPhotoMouseOver(WebDriver driver){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUploadPhoto).perform();
		
		
	}
	
	public void clickUploadPhoto() {
		waitforVisibility(elementUploadPhoto,15);
		elementUploadPhoto.click();
	}
	public void choosePicToUpload(WebDriver driver) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(iframePhoto);
		choosePhoto.sendKeys("/Users/rahade/Documents/Personal/Tekarch/Pics/1.jpg");
		
	}
	public void clickSavePhoto() {
		
		clickSavePhoto.click();
	}
	public void cropPhoto(WebDriver driver) {
		waitforVisibility(cropper1,10);
		Actions action = new Actions(driver);
		action.clickAndHold(cropper1).moveByOffset(30, 50).build().perform();
		
		waitforVisibility(cropper2,10);
		Actions action2 = new Actions(driver);
		action2.clickAndHold(cropper2).moveByOffset(30, 50).build().perform();
	}
	public void  saveCroppedImg() {
		waitforVisibility(saveCroppedImg,10);
		saveCroppedImg.click();
	}
	
	
	public void mySettings() {
		mySetting.click();		
	}
	public  void clickMyPersonallink(){
		waitforVisibility(personalBtn,10);
		personalBtn.click();	
	}
	public void clickLoginHistory() {
		waitforVisibility(loginHistory,10);
		loginHistory.click();
	}
	public void downloadLoginHistory() {
		waitforVisibility(downloadLoginHistory,10);
		downloadLoginHistory.click();
	}
	
	
	
	public void displayLayout() {
		waitforVisibility(displayLayout,10);
		displayLayout.click();
	}
	
	
	public void customizeTab() {
		
		//waitforVisibility(customizeMyTab,20);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customizeMyTab.click();
		}
	public void clickDropDown() {
		waitforVisibility(dropDown,10);
		dropDown.click();
		Select select = new Select(dropDown);
		select.selectByVisibleText("Salesforce Chatter");
		waitforVisibility(selectReports,10);
		
		Select report = new Select(selectReports);
		report.selectByVisibleText("Reports");
	}
	public void  clickAddReports() {
		waitforVisibility(addReport,10);
		addReport.click(); //---> add
	}
	public void clickSaveReport() {
		waitforVisibility(saveReport,10);
		saveReport.click();//---> Save
	}
	
	
	
	public void checkTab()  {
		waitforVisibility(allTab,10);
		allTab.click();
		
		/*List<WebElement> elementsList = 
				driver.findElements(By.xpath("//table[@class='detailList tabs']/tbody/tr/td[@class='dataCol reportBlock col02']/a/img"));
		
		for(WebElement element: elementsList) {
			
			System.out.println(element);
			String actualText =  element.getAttribute("title");
			String expectedText = "Reports";
			
			if(actualText.equalsIgnoreCase(expectedText)) {
				
				
				System.out.println("Textcase Passed");
			}
			
			
		}
		*/
	}
		
	public void clickEmail(WebDriver driver) {
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email.click();
		myEmailSettings.click();
		}
	public void enterEmailName() {
		emailName.clear();
		emailName.sendKeys("Deepika Ram");
	}public void enterEmailAddress() {
		emailAddress.clear();
		emailAddress.sendKeys("deepikark8@gmail.com");
	}
	public void clickSaveBtn() {
		//Radio Button
				AutomaticBcc.click();
				saveBtn.click();
	}
	
	
	public void calender() {
		waitforVisibility(calender,15);
		calender.click();
	}
	public void clickActivityReminders() {
		ActivityReminders.click();
	}
	public void clickOpenaTestReminder() {
		waitforVisibility(OpenaTestReminder,10);
		OpenaTestReminder.click();
	}
	
	
	public void developerConsole() {
		
		developerConsole.click();
		}
	public void popWindowOpens(WebDriver driver) {
		String parentWindowTitle = driver.getTitle();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		System.out.println(parentWindowTitle);
		
		for(String handle:driver.getWindowHandles()) {
			
			driver.switchTo().window(handle);	
			
		}
		
		String childWindowTitle = driver.getTitle();
		System.out.println(childWindowTitle);
//		driver.close();
//		driver.switchTo().window(parentWindow);
		
//		System.out.println(driver.getTitle());
//		String childWindow = driver.getWindowHandle();
//		System.out.println(childWindow); 
		
	}
	public void validateTC08(WebDriver driver,String expectedText) {
		/*
		 * Force.com Developer Console window is closed
		 */
		System.out.println(expectedText);
		String actualText = driver.getTitle();
		System.out.println("actualTExt : "+ actualText);
		compareText(actualText,expectedText);	
	}
	public void closePopUpWindow(WebDriver driver) {
		//String parentWindowTitle = driver.getTitle();
		String parentWindow = driver.getWindowHandle();
		
		for(String handle:driver.getWindowHandles()) {
			
			driver.switchTo().window(handle);	
			
		}
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	
	public void clickAllTab() {
	
		elementAllTab.click();
	}
	
	public void logout() {
		logout.click();
		}
	
	
	public void validateTC05() {
		/*
		 * Drop down with(“My profile", "My Settings", 
		 * "Developer Console","Logout" , "Switching to lightning Experience" is displayed as per classic) .
		 * Drop down with (“Settings”,”Log out”,”comfy”,”Compact”,”Switch to Salesforce Classic”,
		 * ”Add Username” is dipalyed for lightning)
		 * 
		 */
		
		String expectedList[] = {"My profile","My Settings","Developer Console","Logout","Switching to lightning Experience"};
		List<WebElement> elementsList = userMenuDropDown;
		
		for(WebElement element:elementsList){
			
			for(int i=0; i<expectedList.length;i++) {
				if(element.getText().equalsIgnoreCase(expectedList[i])){
					String actualText = element.getText();
					String expectedText = expectedList[i];
					compareText(actualText,expectedText);
				}
			}
		}
	    
	}
	
	
	
	public void validateTC06() {
		
		/*
		 * Uploaded photo should appear on the image.
		 */
		
		
		
		
	}
	
	public void validateTC07(WebDriver driver) {
		/*
		 * Sample event pop window is displayed.
		 */
		String actualText = driver.getTitle();
		String expectedText = "Activity Reminders ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
		
	}
	
	public void validateTC09() {
		/*
		 *Logout  of current sales force application  and https://login.salesforce.com/ page is displayed. 
		 */	
	}
	
	
}
