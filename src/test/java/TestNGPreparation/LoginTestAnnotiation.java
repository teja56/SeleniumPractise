package TestNGPreparation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestAnnotiation {

	// Before--BS , BT, BC, BM
	// Test-- @Test
	// After--AM AC AT AS

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signup = By.linkText("Sign up");
	By dashboard = By.className("private-page__title");

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test--get the values from the data base");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class--get  the value from DB");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite---prepare the test data");
	}

	// @BeforeTest //it will execute only once
	@BeforeMethod // it will execute for every test
	public void setup() {
		System.out.println("Before Method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void signUpLinkTest() {
		boolean flag = driver.findElement(signup).isDisplayed();
		Assert.assertEquals(true, flag);
	}

	// @Test(priority = 2)
	public void verifyPageTitleTest() {
		String text = driver.getTitle();
		System.out.println("page title is :" + text);
		Assert.assertEquals(text, "HubSpot Login");
	}

	@Test(enabled = false)
	public void loginTest() {
		driver.findElement(username).sendKeys("naveenanimation30@gmail.com");
		driver.findElement(password).sendKeys("Test@1234");
		driver.findElement(login).click();
		String text1 = driver.findElement(dashboard).getText();
		System.out.println(text1);
		Assert.assertEquals(text1, "Sales Dashboard");
	}

	// @AfterTest //it will execute only once
	@AfterMethod // it will execute for every test
	public void tearDown() {
		System.out.println("After method");
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class------");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test-----");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite------");
	}
}
