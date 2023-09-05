package com.salesforce.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import com.salesforce.base.BasePage;

public class CreateOpportunityPage extends BasePage{

	public CreateOpportunityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[@title='Opportunities Tab']")
	WebElement elementOpty;
	
	@FindBy(xpath = "//a[@id='tryLexDialogX']")
	WebElement close;
	
	@FindBy(id="fcf")
	WebElement elementOptyMenuList;
	
	@FindBy(xpath = "//input[@title='New']")
	WebElement elementNew;
	
	@FindBy(id = "opp3")
	WebElement optyName;
	
	@FindBy(xpath = "//img[@title='Account Name Lookup (New Window)']")
	WebElement optyAccountNameSelect;
	
	@FindBy(id="opp4")
	WebElement optyAccountName;
	
	@FindBy(id="opp9")
	WebElement optyDate;
	
	@FindBy(xpath="//a[@class='calToday']")
	WebElement optyToday;
	
	@FindBy(id="opp11")
	WebElement optyStage;
	
	@FindBy(id="opp12")
	WebElement optyProbability;
	
	@FindBy(id="opp6")
	WebElement optyLeadSource;
	
	@FindBy(id="opp17")
	WebElement optyPrimaryCampaignSource;
	
	@FindBy(xpath="//td[@class='pbButtonb']//input[@title='Save']")
	WebElement optySave;
	
	@FindBy(xpath = "//a[normalize-space()='Opportunity Pipeline']")
	WebElement elementOptyPipeline;
	
	@FindBy(xpath = "//a[normalize-space()='Stuck Opportunities']")
	WebElement elementStuckOpty;
	
	@FindBy(xpath = "//select[@id='quarter_q']")
	WebElement elementIntervalDropDown;
	
	@FindBy(xpath = "//select[@id='open']")
	WebElement elementInclude;
	
	@FindBy(xpath = "//input[@title='Run Report']")
	WebElement clickQuarterlySummaryLink;
	
	@FindBy(xpath = "//a[normalize-space()='Opportunities']")
	WebElement clickOpty;
	
	
	public void clickOpportunities() {
		
		//waitforVisibility(close,15);
		waitforVisibility(elementOpty,10);
		elementOpty.click(); 
	}
	
	public void clickOptyMenu() {
		/*
		 * Drop down with "All Oppotunities", "Closing Next Month", "Closing This Month", "My Opportunities",
		 *  "New This Week", "Recently Viewed Opportunities","Won"  should be available
		 * 
		 */
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close.click();
		waitforVisibility(elementOptyMenuList,10);
		Select select = new Select(elementOptyMenuList);
		String[] expectedList = {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		elementOptyMenuList.click();
		List<WebElement> options = select. getOptions();
		for(WebElement strText : options) {
			for(int i=0;i<expectedList.length;i++) {
				
				if(strText.getText().equalsIgnoreCase(expectedList[i])){
					String actualText = strText.getText();
					String expectedText = expectedList[i];
					//Validate TC15
					compareText(actualText,expectedText);
				}
			}
		}
		
		
	}
	
	public void clickOnNewOpty() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.click();
		elementNew.click();
		
		
	}
	
	public void newOptyEdit() {
		
		
		optyName.sendKeys("Automation testing");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//optyAccountNameSelect.click();
		optyAccountName.sendKeys("Airplane");
		optyDate.click();
		optyToday.click();
		Select selectStage = new Select(optyStage);
		selectStage.selectByVisibleText("Needs Analysis");
		optyProbability.click();
		optyProbability.clear();
		optyProbability.sendKeys("20");
		Select selectLeadSource = new Select(optyLeadSource);
		selectLeadSource.selectByVisibleText("Phone Inquiry");
		optyPrimaryCampaignSource.sendKeys("");
		optySave.click();
		
		
	}
	
	public void validateTC16(WebDriver driver) {
		String actualText = driver.getTitle();
		String expectedText = "Opportunity: Automation testing ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	
	public void clickOptyPipeline() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.click();
		elementOptyPipeline.click();
	}
	
	public void validateTC17(WebDriver driver) {
		
		String actualText = driver.getTitle();
		String expectedText = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
		
	}
	
	public void ClickonStuckOpportunitieslink() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.click();
		elementStuckOpty.click();
	}
	
	public void validateTC18(WebDriver driver) {
		String actualText=driver.getTitle();
		String expectedText="Stuck Opportunities ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
	
	public void clickonQuarterlySummarylink() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.click();
		Select select = new Select(elementIntervalDropDown);
		select.selectByVisibleText("Current FQ");
		Select select2 = new Select(elementInclude);
		select2.selectByVisibleText("All Opportunities");
		clickQuarterlySummaryLink.click();
		
		
	}
	
	public void validateTC19(WebDriver driver) {
		String actualText = driver.getTitle();
		String expectedText = "Opportunity Report ~ Salesforce - Developer Edition";
		compareText(actualText,expectedText);
	}
}
