package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signup = By.linkText("Sign up");
	By dashboard = By.className("private-page__title");

	@BeforeTest
	@Parameters({"url","browser"})
	public void setup(String url,String browserName) throws Exception {
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
	public void loginPageTitleTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("HubSpot"));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}

	@Test(priority=2)
	public void signUpLinkTest() {
		boolean flag = driver.findElement(By.linkText("Sign up")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginPageTest() {
		driver.findElement(By.id("username")).sendKeys("naveenautomation20@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.id("loginBtn")).click();

		boolean flag = driver.findElement(By.className("privatee-page__title")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@AfterTest
	public void teatDown() {
		driver.quit();
	}

}
