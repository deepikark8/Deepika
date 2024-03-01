package com.practice.steps;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	 public WebDriver driver=null;
	@Given("User is in {string}")
	public void user_is_in(String string) {
		//WebDriverManager.chromedriver().browserVersion("122.0.6261.94").setup();
	//	WebDriverManager.chromedriver().setup();
		WebDriverManager.chromiumdriver().setup();
	     driver = new ChromeDriver();
	     driver.get("https://login.salesforce.com/");
	     driver.manage().window().maximize();
	     //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
      
	}

	@Then("User click on Button {string}")
	public void user_click_on_button(String string) {
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	
}
