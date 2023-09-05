package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.salesforce.base.BasePage;

public class CreateAccountPage extends BasePage{
	

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@title='Accounts Tab']")
	WebElement accountsTab;
	
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	WebElement closeBtn;
	
	@FindBy(xpath="//a[contains(text(),'Close')]")
	WebElement close;
	
	 @FindBy(name="new")
	 ////form[@id='hotlist']/table/tbody/tr/td[2]/input[@name='new']
	 WebElement newBtn;
	 
	 @FindBy(id="acc2")
	 WebElement accountName;
	 
	 @FindBy(id="acc6")
	 WebElement accountType;
	 
	 @FindBy(id="00NDm000006Mfgb")
	 WebElement customerPriority;
	 
	 @FindBy(name="save")
	 WebElement saveBtn;
	
	 @FindBy(xpath="//a[contains(text(),'Create New View')]")
	 WebElement createNewView;
	 
	 @FindBy(id="fname")
	 WebElement viewName;
	 
	 @FindBy(id="devname")
	 WebElement viewUniqueName;
	 
	 @FindBy(name="save")
	 WebElement saveNewViewBtn;
	 
	 @FindBy(xpath="//select[@title='View:']")
	 WebElement dropDownVisibleText;
	 
	@FindBy(id="fcol1")
	WebElement filterByField;
	
	@FindBy(id="fop1")
	WebElement filterByOperator;
	
	@FindBy(id="fval1")
	WebElement filterByValue;
	
	@FindBy(id="colselector_select_0")
	WebElement fieldToDisplay;
	
	@FindBy(xpath="//img[@alt='Add']")
	WebElement addBtn;
	
	@FindBy(name="save")
	WebElement saveBtnInEditView;
	
	@FindBy(id="fcf")
	WebElement selectView;
	
	@FindBy(xpath="//a[text()='Edit']")
	WebElement clickEditBtn;
	
	@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
	WebElement mergeAccount;
	
	@FindBy(id="srch")
	WebElement enterTextInMergeField;
	
	@FindBy(name="srchbutton")
	WebElement findAccountsBtn;
	
	@FindBy(xpath="//*[@id=\"cid0\"]")
	WebElement firstElement;
	
	
	@FindBy(xpath="//*[@id=\"cid1\"]")
	WebElement secondElement;
	
	@FindBy(xpath="//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[1]")
	WebElement elementNext;
	
	
	@FindBy(xpath="//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]")
	WebElement elementMerge;
	
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement eleemntLastActivity;
	
	@FindBy(xpath = "//*[@id='ext-gen20']")
	WebElement elementDateField;
	
	@FindBy(xpath = "//*[@id='ext-gen152']")
	WebElement elementFromDate;
	
	@FindBy(xpath = "//button[contains(text(),'Today')]")
	WebElement elementToday;
	
	@FindBy(xpath = "//*[@id='ext-gen49']")
	WebElement elementSave;
	
	@FindBy(xpath = "//*[@id='saveReportDlg_reportNameField']")
	WebElement elementReportName;
	
	@FindBy(xpath = "//*[@id='saveReportDlg_DeveloperName']")
	WebElement elementReportUniqueName;
	
	@FindBy(xpath="//button[contains(text(),'Save and Run Report')]")
	WebElement elementSaveAndRun;
	
	@FindBy(id="hotlist_mode")
	WebElement dropDownRecentlyViewed;
	
	@FindBy(xpath="//tr[contains(@class,'dataRow even first')]//a")
	WebElement checkMergeAccountName;
	
	@FindBy(xpath="//div[@class='content']")
	WebElement checkReportName;
	
	public void clickAccountTab() {
		accountsTab.click();
		waitforVisibility(close,20);
		close.click();
	}
	
	public void newAccount() {
		waitforVisibility(newBtn,10);
		newBtn.click();
	}
	
	public void accountDetails(WebDriver driver) {
		waitforVisibility(accountName,10);
		accountName.sendKeys("Testing Technologies");
		
		Select report = new Select(accountType);
		report.selectByVisibleText("Technology Partner");
		
		
		Select select = new Select(customerPriority);
		select.selectByVisibleText("High");
		waitforVisibility(saveBtn,10);
		saveBtn.click();
		
	}
	
	
	public void validateTC11(String sRandomTextForPost) {
		//validate
	    Select select = new Select(dropDownVisibleText);
	    WebElement  VisibleText =  select.getFirstSelectedOption();
		String ActualText = VisibleText.getText();
		System.out.println("Actual Text : "+ ActualText);
		String ExpectedText = sRandomTextForPost; 
		compareText(ActualText,ExpectedText);
	}
	
	public void viewDropDown() {
		
		waitforVisibility(selectView,10);
		
		Select select = new Select(selectView);
		select.selectByVisibleText("Orange");
		waitforVisibility(clickEditBtn,10);
		clickEditBtn.click();
		
	}
	
	
	public void editView() {
		waitforVisibility(viewName,10);
		viewName.clear();
		viewName.sendKeys("Orange");
		
		Select select = new Select(filterByField);
		select.selectByVisibleText("Account Name");
		
		Select select1 = new Select(filterByOperator);
		select1.selectByVisibleText("contains");
		
		filterByValue.sendKeys("a");;
		
		Select select2 = new Select(fieldToDisplay);
		select2.selectByVisibleText("Last Activity");
		addBtn.click();
		
		saveBtnInEditView.click();
	}
	
	public void clickMergeAccount(WebDriver driver) {
		
		waitforVisibility(mergeAccount,10);
		mergeAccount.click();
		
		waitforVisibility(enterTextInMergeField,10);
		enterTextInMergeField.sendKeys("Testing");
		
		findAccountsBtn.click();
		
		firstElement.click();
		secondElement.click();
		
		elementNext.click();
		waitforVisibility(elementMerge,10);
		elementMerge.click();
		driver.switchTo().alert().accept();
		
	}
	
	public void lastActivity() {
		waitforVisibility(eleemntLastActivity,10);
		eleemntLastActivity.click();
		}
	
	public void dateField() {
		waitforVisibility(elementDateField,15);
		elementDateField.click();
		//elementDateField.click();
		waitforVisibility(elementFromDate,15);
		elementFromDate.click();
		waitforVisibility(elementToday,15);
		elementToday.click();
		waitforVisibility(elementSave,5);
		elementSave.click();
	}
	
	public  void saveAndRunReport(WebDriver driver,String sRandomTextUniqueName) {
		waitforVisibility(elementReportName,10);
		elementReportName.sendKeys("New Test Report April");
		waitforVisibility(elementReportUniqueName,10);
		elementReportUniqueName.click();
		elementReportUniqueName.clear();
		elementReportUniqueName.sendKeys(sRandomTextUniqueName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementSaveAndRun.click();
	}
	
	public void createNewView(String sRandomTextForPost) {
		createNewView.click();
		waitforVisibility(viewName,10);
		viewName.sendKeys(sRandomTextForPost);
		saveNewViewBtn.click();	
	}
	public void validateTC10(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActualText = driver.getTitle();
		System.out.println("ActualText : "+ ActualText);
		String ExpectedText = "Account: Testing Technologies ~ Salesforce - Developer Edition";
		System.out.println("ExpectedText : "+ExpectedText);
		compareText(ActualText,ExpectedText);
	}
	
	public void validateTC13() {
		Select select = new Select(dropDownRecentlyViewed);
		select.selectByVisibleText("Recently Viewed");
		dropDownRecentlyViewed.click();
		String ActualText = checkMergeAccountName.getText();
		System.out.println("ActualText : "+ ActualText);
		String ExpectedText = "Testing Technologies";
		compareText(ActualText,ExpectedText);	
	}
	public void validateTC14() {
		String expectedText = "New Test Report April";
		String actualText = checkReportName.getText();
		System.out.println(" Name of report page:"+ actualText);
		compareText(actualText,expectedText);
		
	}
	
}
