package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest {
	WebDriver driver;
	By termsServicesLink = By.linkText("HubSpot Customer Terms of Service.");
	By accountName = By.xpath("//h4[text()='Create your free account']");
	By singup = By.linkText("Sign up");

	@BeforeTest
	@Parameters({"url","browser"})
	public void setup(String url, String browserName) throws Exception {
		System.out.println("Before Method");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else{
			System.out.println("please pass the correct browser name");
			throw new Exception("NoSuchBrowserException");
		}
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void verifyCreateAccountTest() {
		driver.findElement(singup).click();
		Assert.assertTrue(driver.findElement(termsServicesLink).isDisplayed());
	}
	@Test(priority=2)
	public void verifyAccountNameTest() {
		Assert.assertTrue(driver.findElement(accountName).isDisplayed());
	}
	@AfterTest
	public void teatDown() {
		driver.quit();
	}

}
