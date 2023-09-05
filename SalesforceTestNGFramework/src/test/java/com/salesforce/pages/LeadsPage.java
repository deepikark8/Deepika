package com.salesforce.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.BasePage;

public class LeadsPage extends BasePage {
	
	String actualLeadViewPageTitle;
	
	public LeadsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String sDropDownText;
	
	@FindBy(xpath = "//a[@title='Leads Tab']")
	WebElement elementLead;
	
	@FindBy(xpath = "//a[@id='tryLexDialogX']")
	WebElement close;
	
	@FindBy(xpath = "//select[@id='fcf']")
	WebElement elementListDropDown;
	
	@FindBy(id = "fcf")
	WebElement elementListViewDropDown;
	
	@FindBy(xpath="//input[@title='Go!']")
	WebElement elementGo;
	
	@FindBy(id = "userNavLabel")
	WebElement  userMenuDropDown;
	
	@FindBy(xpath="//input[@title='New']")
	WebElement elementLeadNew;
	
	@FindBy(id="name_lastlea2")
	WebElement elementLastName;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//td[@class='pbButtonb']//input[@title='Save']")
	WebElement elementSave;
	
	
	@FindBy(id="lea3")
	WebElement elementCompanyName;
	
	
	
	public  void clickLeadTab() {
		elementLead.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.click();
	}
	
	public  void clickListDropDown() {
	Select select = new Select(elementListDropDown);
	String[] expectedList = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};
	elementListDropDown.click();
	
	//Validtae TC21
	List<WebElement> options = select. getOptions();
	for(WebElement strText : options) {
		//System.out.println(strText.getText());
		for(int i=0;i<expectedList.length;i++) {
			
			if(strText.getText().equalsIgnoreCase(expectedList[i])){
				String actualText = strText.getText();
				String expectedText = expectedList[i];
				compareText(actualText,expectedText);
				}
			}
		}
	}
	
	public void clickViewDropDown() {
		Select select = new Select(elementListDropDown);
		//select.selectByVisibleText("My Unread Leads");
		WebElement selectedOption = select.getFirstSelectedOption();
		sDropDownText = selectedOption.getText();
		
		//System.out.println("text :"+ stExt);
		
	}
	
	
	
	public void clickViewDropDownGo() {
		
		Select select = new Select(elementListViewDropDown);
		select.selectByVisibleText("Today's Leads");
		waitforVisibility(elementGo,10);
		elementGo.click();		
	}
	
	
	public void clickNew() {
		elementLeadNew.click();
		elementLastName.sendKeys("ABCD");
		actualLeadViewPageTitle = "ABCD";
		elementCompanyName.sendKeys("ABCD");
		elementSave.click();	
		
	}
	
	public void validateTC20(WebDriver driver) {
		String actualText = driver.getTitle();
		String expectedText = "Leads: Home ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	
	
	public void validateTC22() {
		elementLead.click();
		Select select = new Select(elementListDropDown);
		WebElement selectedOption = select.getFirstSelectedOption(); 
		String actualText = selectedOption.getText();
		String expectedText = sDropDownText;
		compareText(actualText,expectedText);
		
	}
	public void validateTC23(WebDriver driver) {
		String actualText = driver.getTitle();
		String expectedText ="Leads ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
		
	}
	
	public void validateTC24(WebDriver driver) {
		String actualText = driver.getTitle();
		String expectedText = "Lead: "+ actualLeadViewPageTitle +" ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	
//	public void logout() {
//		waitforVisibility(userMenuDropDown,10);
//		userMenuDropDown.click();
//		logout.click();
//	}
	
	@FindBy(xpath = "//input[@title='Go!']")
	WebElement selectfromDropDown;
	
	public void clickGo() {
		selectfromDropDown.click();
		
	}
}
