import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GoogleTest {
	
	@Test
	public void HomePageCheck() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.86.250:4444"),cap);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("deepika ramkumar");
		System.out.println(driver.getTitle());
		
		
	}
	

}
