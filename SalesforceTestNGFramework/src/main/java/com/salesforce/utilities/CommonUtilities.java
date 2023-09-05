package com.salesforce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtilities {
	
	
	public String getPropertyFile(String key) throws IOException {
		
		String sPath = "/Users/rahade/eclipse-workspace/SalesforceTestNGFramework/Properties/application.properties";
		
			FileInputStream fileInput = new FileInputStream(sPath);
		
		
		Properties property = new Properties();
		property.load(fileInput);
		String value = property.getProperty(key);
		
		
		return value;
		
		
	}
	
	

}
