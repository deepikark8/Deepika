package com.salesforce.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.base.BasePage;

public class RandomScenariosPage extends BasePage{
	
	String sLoggedInUserName;
	public RandomScenariosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="userNavLabel")
	WebElement elementUserNameInUseMenu;
	
	@FindBy(id="tabBar")
	WebElement elementTabBar;
	
	@FindBy(xpath="//a[@href='/home/showAllTabs.jsp']")
	WebElement elementAllTab;
	
	@FindBy(id = "userNavLabel")
	WebElement elementUserProfileName;
	
	@FindBy(xpath= "//span[@class='pageDescription']")
	WebElement elementDate;
	
	@FindBy(id="tabBar")
	List<WebElement> elementsInTabBar;
	
	@FindBy(xpath = "//a[@title='Home Tab']")
	WebElement elementHome;
	
	@FindBy(xpath = "//span[@class='pageDescription']/a")
	WebElement elementDateLink;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']/a")
	WebElement elementUserName;
		
	
	@FindBy(xpath = "//a[@id='tryLexDialogX']")
	WebElement close;
	 
	@FindBy(id = "contactInfoContentId")
	 WebElement about;
	
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	WebElement editProfile;
	
	@FindBy(xpath = "//a[contains(text(),'About')]")
	 WebElement aboutTab;
	
	@FindBy(id = "tailBreadcrumbNode")
	WebElement elementUserNameTitle;
	
	@FindBy(xpath = "//input[@class='zen-btn zen-primaryBtn zen-pas']")
	 WebElement saveAll;
	
	@FindBy(xpath = "//input[@title='Save']")
	WebElement elementSave;
	
	 
	@FindBy(xpath = "//input[@title='Customize My Tabs']")
	WebElement elementCustomizeAllTabs;
	
	@FindBy(id="duel_select_0")
	WebElement elementSelectToAddInTab;
	
	@FindBy(id="duel_select_0_right")
	WebElement elementAdd;
	
	@FindBy(id = "duel_select_1")
	WebElement eleemntSelectedTab;
	
	@FindBy(xpath = "//img[@title='Remove']")
	WebElement elementRemoveBtn;
	
	@FindBy(name = "save")
	WebElement elementClickSave;
	
	@FindBy(xpath = "//ul[@class='zen-inlineList zen-tabMenu']")
	WebElement eleementTabBar;
	
	@FindBy(id="username")
	WebElement username;
	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginButton;
	
	@FindBy(xpath = "//ul[@class='zen-inlineList zen-tabMenu']")
	List<WebElement> elementHomeTabNames;
	//WebElement elementHomeTabNames;
	
	@FindBy(xpath = "//a[normalize-space()='8:00 PM']")
	WebElement element8PM;
	
	@FindBy(id="evt5")
	WebElement elementSubject;
	
	@FindBy(xpath = "//img[@title='Subject Combo (New Window)']")
	WebElement elementSubjectComboBoxBtn;
	
	@FindBy(css = "a[href='javascript:pickValue(4);']")
	WebElement elementOtherLink ;
	
	@FindBy(xpath = "//input[@name='EndDateTime_time']")
	WebElement elementEndTime;
	
	@FindBy(xpath = "//td[@class='pbButton']//input[@title='Save']")
	WebElement elementCalenderSave;
	

	@FindBy(xpath = "//div[normalize-space()='9:00 PM']")
	WebElement elementClick9;
	
	@FindBy(xpath = "//a[normalize-space()='8:00 PM']")
	WebElement elementTime8PM;
	
	@FindBy(xpath = "//div[@class='multiLineEventBlock dragContentPointer']/span/a/span")
	WebElement elementOther8PM;
	
	@FindBy(xpath = "//a[normalize-space()='4:00 PM']")
	WebElement element4PM;
	
	@FindBy(xpath = "//input[@name='IsRecurrence']")
	WebElement elementCheckRecurrence;
	
	@FindBy(xpath = "//label[normalize-space()='Frequency']")
	WebElement elementFrequency;
	
	@FindBy(xpath = "//label[@for='RecurrenceStartDateTime']")
	WebElement elementStartDate;
	
	@FindBy(xpath = "//label[@for='RecurrenceEndDateOnly']")
	WebElement elementEndDate;
	
	@FindBy(xpath = "//input[@value='ftw']")
	WebElement elementSelectWeekly;
	
	@FindBy(xpath = "//input[@title='specify interval in weeks']")
	WebElement elementReccurs;
	
	@FindBy(xpath = "//input[@name='RecurrenceEndDateOnly']")
	WebElement elemenetEndDate;
	
	@FindBy(xpath = "//a[normalize-space()='4:00 PM']")
	WebElement elementTime;
	
	@FindBy(xpath = "//div[@class='multiLineEventBlock dragContentPointer']/span/a/span")
	WebElement elementOther4PM;
	
	@FindBy(xpath = "//img[@title='Month View']")
	WebElement elementMonthView;
	
	@FindBy(xpath = "//h1[@class='pageType']")
	WebElement elementMonthViewTitle;
	
	@FindBy(xpath = "//a[@title='Today']")
	WebElement elementToday;
    
	@FindBy(xpath = "//table[@class='calendarMonthView secondaryPalette']/tbody/tr[6]/td[6]/div[2]/a")
	WebElement elementOthersMonthView;
    
	@FindBy(id = "userNavLabel")
	WebElement elementCurrentUserName;
	
	@FindBy(name = "save")
	WebElement elementClickSaveBtn;
	
	public void clickHomeTab() {
		
		sLoggedInUserName = elementCurrentUserName.getText();
		System.out.println("sLoggedInUserName :"+sLoggedInUserName);
		
		waitforVisibility(elementUserNameInUseMenu,10);
		String ActualText = elementUserNameInUseMenu.getText();
		waitforVisibility(elementHome,10);
		elementHome.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		String ExpectedText = elementUserName.getText();
		compareText(ActualText,ExpectedText);
	}
	public void clickClose() {
		close.click();
	}
	
	
	public void clickUserName(WebDriver driver) {
		System.out.println("sLoggedInUserName : "+sLoggedInUserName);
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(elementUserName).perform();
		elementUserName.click();
		String actualText = driver.getTitle();
		String expectedText = "User: "+sLoggedInUserName+" ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);	
	}
	
	public void clickOnUserName() {
		elementUserName.click();
		
	}
	public void clickEditProfile() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitforVisibility(editProfile,10);
		editProfile.click();
	}
	public void validateTC34() {
	
		waitforVisibility(elementUserNameTitle,10);
		String ActualText = elementUserNameTitle.getText();
		String ExpectedText = "Deepika Abcd ";
		compareText(ActualText,ExpectedText);
	}
	
	public void validateAllTab() {
		
		sLoggedInUserName = elementCurrentUserName.getText();
		System.out.println("sLoggedInUserName" + sLoggedInUserName);
		
		
		
		for(WebElement element:elementsInTabBar) {
			System.out.println(element.getText());
			String sTabName = element.getText();
			if(sTabName.equalsIgnoreCase("Opportunities")) {
				System.out.println("Opportunity is present");
			}else {
				System.out.println("Opty is not thr");
//				clickAllTab();
//				clickCustomizeMyTabsButton();
//				addTab();
				
			}
		}
		
		elementAllTab.click();
		
	}
	
	public void clickAllTab() {
		elementAllTab.click();
	}
	
	public void clickCustomizeMyTabsButton() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		elementCustomizeAllTabs.click();
	}
	
	public  void addTab() {
		Select select = new Select(elementSelectToAddInTab);
		select.selectByVisibleText("Opportunities");
		elementAdd.click();
		elementSave.click();
	}
	
	
	
	
	public void clickRemoveSelectedTab(String sText) {
		waitforVisibility(eleemntSelectedTab,10);
		Select select = new Select(eleemntSelectedTab);
		select.selectByVisibleText(sText);
		elementRemoveBtn.click();
	}
	
	public void validateTC35() {
		String expectedText = "Opportunities";
		for(WebElement tabName : elementHomeTabNames) {
			System.out.println(tabName.getText());
			if(tabName.getText().equalsIgnoreCase(expectedText)){
				System.out.println("Element Present");
			}else {
				Assert.assertNotEquals(tabName.getText(), expectedText);
			}
		}
	}
	
	
	public void validateNameDate() {
		
		String sName = elementUserProfileName.getText();
		System.out.println("Name : "+sName);
		String actualText = sName;
		String expectedText = sLoggedInUserName;//"Deepika Abcd";
			
		compareText(actualText,expectedText);
		
		
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
	
	public void clickDateLink() {
		
		waitforVisibility(elementDateLink,10);
		elementDateLink.click();
	}
	public void validateCalanderPage(WebDriver driver) {
		
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
		String expectedText = "Calendar for "+sLoggedInUserName+" ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	public void click8PM() {
		
		element8PM.click();
	}

	
	public void validateClick8PMPage(WebDriver driver) {
		String expectedText = "Calendar: New Event ~ Salesforce - Developer Edition";
		String atualText = driver.getTitle();
		compareText(atualText,expectedText);
			
	}

	public void checkCursorInSubject(WebDriver driver) {
		
		if(elementSubject.equals(driver.switchTo().activeElement())) {
			System.out.println("cursor is in Subject field");
		}	
	}
	
	public void clickSubjectComboBoxBtn() {
		
		elementSubjectComboBoxBtn.click();
		
	}
	
	
	public void clickOthersInComboBoxWindow(WebDriver driver) {
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		String actualText = null;
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				actualText = elementOtherLink.getText();
				elementOtherLink.click();
			}
		}
		driver.switchTo().window(winHandleBefore);
		String expectedText = "Other";
		compareText(actualText,expectedText);
		}
	
	
	public void clickEndTime() {
		
		elementEndTime.click();
		elementClick9.click();	
	}

	public  void clickSaveCalender() {
		elementCalenderSave.click();
	}

	public void validateTC36() {
		
		String actualTime = elementTime8PM.getText();
		String expectedTime = "8:00 PM";
		compareText(actualTime,expectedTime);
		String actualText = elementOther8PM.getText();
		String expectedText = "Other";
		compareText(actualText,expectedText);
		
	}
	public void click4PM() {
		element4PM.click();
	}
	public void validateClick4PMPage(WebDriver driver) {
		String expectedText = "Calendar: New Event ~ Salesforce - Developer Edition";
		String atualText = driver.getTitle();
		compareText(atualText,expectedText);
			
	}
	public void checkRecurrence() {
		elementCheckRecurrence.click();
	}
	public void validateCheckRecurrence() {
		String actualText = elementFrequency.getText();
		String expectedText = "Frequency";
		compareText(actualText,expectedText);
		
		String actualStartDate = elementStartDate.getText();
		String expectedStartDate = "Recurrence Start";
		compareText(actualStartDate,expectedStartDate);
		
		String actualEndDate = elementEndDate.getText();
		String expectedEndDate = "Recurrence End";
		compareText(actualEndDate,expectedEndDate); 
		
	}
	public void selectWeeklyRadioBtn() {
		elementSelectWeekly.click();
	}
	public void validateWeeklyRadioBtn() {
		
		String actualText = elementReccurs.getAttribute("value");
		String expectedText ="1";
		compareText(actualText,expectedText);
		
	}
	
	public void validateCurrentDayOfWeek(WebDriver driver) {
		
		List<WebElement> elementCurrentDay = driver.findElements(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[8]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[2]"));
		for(WebElement elementDay:elementCurrentDay) {
			
			System.out.println(elementDay.getText()+"\t");
	
		}
	}
	public void enterEndDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    //cal.setTime(new Date());
	    cal.add(Calendar.DATE, 14);
	    String newDate = dateFormat.format(cal.getTime());
	    System.out.println("newDate :"+newDate);
		elemenetEndDate.sendKeys(newDate);
		elemenetEndDate.click();		
	}
	public void validateTC37() {
		String actualTime = elementTime.getText();
		String expectedTime = "4:00 PM";
		compareText(actualTime,expectedTime);
		
		String actualText = elementOther4PM.getText();
		String expectedText = "Other";
		compareText(actualText,expectedText);
	}
	public void clickMonthView() {
		elementMonthView.click();
	}
	public void validateMonthView() {
		String actualText = elementMonthViewTitle.getText();
		String expectedText = "Calendar for "+sLoggedInUserName+" - Month View";
		compareText(actualText,expectedText);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    //cal.setTime(new Date());
	    cal.add(Calendar.DATE, 14);
	    String newDate = dateFormat.format(cal.getTime());
	    
	    elementToday.sendKeys(newDate);
	    
	    String actualText1 = elementOthersMonthView.getText();
	    String expectedText1 ="Other";
	    compareText(actualText1,expectedText1);
	    
	    
	}
	
public void clickSave() {
		
		
		elementClickSaveBtn.click();
	}
}
