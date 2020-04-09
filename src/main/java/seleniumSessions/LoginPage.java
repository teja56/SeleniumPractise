package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		//page objects
		By emailId = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginBtn");

		Util util =new Util(driver);
		
		String text =util.waitForTitlePresent("HubSpot Login", 10);
		System.out.println(text);
		util.waitForElementPresentTimeOut(emailId, 15);
		util.doSendKeys(emailId, "test@test.com");
		util.doSendKeys(password, "test@123");
		util.doClick(loginButton);
		
		
	}

}
