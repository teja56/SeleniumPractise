package TestNGPreparation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	WebDriver driver;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com/login");
		softAssert = new SoftAssert();
		
		
	}

	@Test
	public void loginPageTitleTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("HubSpot"));
		String title = driver.getTitle();
		System.out.println(title);
		softAssert.assertEquals(title, "HubSpot Login");
	}

	@Test
	public void signUpLinkTest() {
		boolean flag = driver.findElement(By.linkText("Sign up")).isDisplayed();
		softAssert.assertTrue(flag);
	}

	@Test
	public void loginPageTest() {
		driver.findElement(By.id("username")).sendKeys("naveenautomation20@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.id("loginBtn")).click();

		boolean flag = driver.findElement(By.className("privatee-page__title")).isDisplayed();
		softAssert.assertTrue(flag);
	}

	@AfterMethod
	public void teatDown() {
		driver.quit();
	}

}
 