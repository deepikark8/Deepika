package com.salesforce.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.salesforce.base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[@href='/home/showAllTabs.jsp']")
	WebElement elementAllTab;
	
	@FindBy (xpath = "//a[@class='listRelatedObject contactBlock title']")
	WebElement elementContact;
	
	@FindBy(xpath = "//a[@id='tryLexDialogX']")
	 WebElement close;

	@FindBy(xpath = "//input[@title='New']")
	WebElement elementNew ;
	
	@FindBy(xpath = "//input[@id='name_lastcon2']")
	WebElement elementLastName;
	
	@FindBy(xpath = "//input[@id='con4']")
	WebElement elementAccountName;
	
	
	@FindBy(xpath = "//td[@class='pbButtonb']//input[@title='Save']")
	WebElement elementSave;
	
	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement elementCreateNewViewLink;
	
	@FindBy(id="fname")
	WebElement elementViewName;
	
	@FindBy(name = "devname")
	WebElement elementUniqueName ;
	
//	@FindBy(xpath = "(//input[@title='Save'])[2]")
//	WebElement elementSave;
	
	@FindBy(xpath="//select[@title='View:']")
	WebElement elementContactsDropDown;
	
	@FindBy(name="hotlist_mode")
	WebElement elementDropDownRecentlyCreated;
	
	@FindBy(xpath = "//input[@title='Go!']")
	WebElement elemenetGo;
	
	@FindBy(xpath = "//table[@class='list']/tbody/tr/th[1]/a")
	WebElement elementContactListName;
	
	@FindBy(xpath="//h2[@class='topName']")
	WebElement eleemntContactListNameDetails;
	
	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement elementNewViewLink;
	
//	@FindBy(xpath = "(//input[@title='Save'])[2]")
//	WebElement elementSave;
	
	@FindBy(xpath = "//div[@class='requiredInput']//div[@class='errorMsg']")
	WebElement elementErrorMsg;
	
	@FindBy(xpath = "//table[@class='list']/tbody/tr/th[1]/a")
	WebElement elementContacts;
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[2]")
	WebElement elementCancel;
	
	@FindBy(xpath = "//td[@class='pbButtonb']//input[@title='Save & New']")
	WebElement elementSaveNew;
	
	@FindBy(xpath = "//h1[@class='pageType']")
	WebElement title;
	
	
	
	public void clickContactTab(WebDriver driver) {
		
		elementAllTab.click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
	        //This will scroll the page Horizontally till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", elementContact);
	        elementContact.click();
	        
	        close.click();
	}
	
	public void clickNew() {
		elementNew.click();
	}
	public void enterLastName(){
		elementLastName.sendKeys("Ramkumar");
	}
	public void enterAccountName() {
		elementAccountName.sendKeys("Harsh");
	}
	public void clickSave() {
		elementSave.click();
	}
	
	public void clickCreateNewViewLink(String sRandomUniqueName) {
		elementCreateNewViewLink.click();
		elementViewName.sendKeys(sRandomUniqueName);
		elementUniqueName.click();
		elementUniqueName.clear();
		elementUniqueName.sendKeys(sRandomUniqueName);
		elementSave.click();
		
	}
	
	public void clickRcentlyCreated() {
		
		Select select = new Select(elementDropDownRecentlyCreated);
		select.selectByVisibleText("Recently Created");
	}
	
	public void clickContactsListDropDown(WebDriver driver) {
		
		
		Select select = new Select(elementContactsDropDown);
		select.selectByVisibleText("My Contacts");
		
		
		//elementContactsDropDown.click();
		//waitforVisibility(elemenetGo,10);
		//elemenetGo.click();
		
		String ActualText = driver.getTitle();
		//System.out.println("ActualText :"+ActualText);
		String ExpectedText = "Contacts: Home ~ Salesforce - Developer Edition";
		
//		//Validate
		compareText(ActualText,ExpectedText);
		
	}
	
	public void clcikContact() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//validate
		String actualText = elementContactListName.getText();
		elementContactListName.click();
		String expectedText = eleemntContactListNameDetails.getText();
		compareText(actualText,expectedText);
		
		
	}
	
	public void clickNewViewLink() {
		
		elementNewViewLink.click();
		
		
		elementUniqueName.sendKeys("EFGH");
		
		elementSave.click();
	}
	
	public void clickNewViewLinkHyperLink() {
		
		elementNewViewLink.click();
		elementViewName.sendKeys("ABCD");
		elementUniqueName.sendKeys("EFGH");
		elementCancel.click();	
	}
	

	public void clickContact() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String ActualText =  elementContacts.getText();
		String ExpectedText = "ABCD";
		System.out.println("ActualText : "+ActualText +"  \n "+"ExpectedText :"+ExpectedText);
		//Validate
		//ActualText : Ramkumar  
		 //ExpectedText :ABCD
		compareTextNotEqual(ActualText,ExpectedText);
	}
	
	public void compareTextNotEqual(String ActualText,String ExpectedText) {
		Assert.assertNotEquals(ActualText,ExpectedText);
	}
	
	
	public void clickEnterNewContactDetails() {
		elementLastName.sendKeys("Indian");
		elementAccountName.sendKeys("Global Media");
		elementSaveNew.click();
		System.out.println();
		String actualText = title.getText();
		String expectedText = "Contact Edit";
		
		//Validate
		compareText(actualText,expectedText);
		
	}
	
	public void validateTC30() {
		
		//validate
				String ActualText = elementErrorMsg.getText();
				String expectedText = "Error: You must enter a value";
				compareText(ActualText,expectedText);
	}
	
	public void validateTC26(WebDriver driver,String sRandomUniqueName) {	
		Select select = new Select(elementContactsDropDown);
	
		WebElement o = select.getFirstSelectedOption();
	      String actualText = o.getText();
	      
		String expectedText = sRandomUniqueName; 
		compareText(actualText,expectedText);
		
	}
	
	
	public void validateTC25(WebDriver driver) {
		
		String actualText = driver.getTitle();
		String expectedText = "Contact: Ramkumar ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	
}
