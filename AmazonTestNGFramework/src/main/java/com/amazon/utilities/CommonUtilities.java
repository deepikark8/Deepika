package com.amazon.utilities;

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
	
	public String getProperty(String key) throws IOException {
		
		
		
		String path = "/Users/rahade/workspaceInterView/AmazonTestNGFramework/Properties/application.properties";
		FileInputStream file = new FileInputStream(path);
		Properties property = new Properties();
		property.load(file);
		String value = property.getProperty(key);
		return value;
		
	}
	
	public void takeScreenShot(WebDriver driver,String sTestCaseName) {
		
		//Take screenshot interface is used to take screenshot by passing the driver
		TakesScreenshot screenShot = ((TakesScreenshot)driver);
		
		//File is stored as an object from SS
		
		////we need convert screenshot object convert into file so we convert it into source file but we don't know where it will store
		//It will be in the memory to bring it into physical file we need another destination file
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(currentDate);
		
		
		// Create a destination folder/path to store the file
		String filepath = "/Users/rahade/workspaceInterView/AmazonTestNG/Screenshots/"+sTestCaseName+"-"+timeStamp+".jpeg";
		
		
		//I'll create destination file to store screenshot object
		File desFile = new File(filepath);
		
		//Then using file utilities copy file ... convert the file object to a physical file
				try {
					FileUtils.copyFile(srcFile, desFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		
	} 
	
	

}
