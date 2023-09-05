import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



import org.openqa.selenium.WebDriver;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FirefoxTest {
	
	@Test
	public void HomePageCheck() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		//cap.setPlatform(Platform.ANY);
//		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.86.250:4444"),cap);
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		
		
	}
	

}
