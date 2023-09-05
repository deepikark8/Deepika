package com.amazon.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utilities.CommonUtilities;

public class BasePage {

	protected WebDriver driver;
	CommonUtilities utilities = new CommonUtilities();
	
	//Constructor
	public BasePage (WebDriver driver) {
		
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this); // Initialise all the elements
		
	}
	
	public void waitforVisibility(WebElement element, Duration time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	public String getValue(String Key) throws IOException {
		String strKey = utilities.getProperty(Key);
		return strKey;
		
	}
	
	
	
}
