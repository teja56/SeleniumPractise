package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSpotLoginPageImplictlyWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		// implicitlywait
		// it is dynamic wait
		// it will be applied for all the elements
		// global wait
		//if element is not found it will through no such element exception
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// e1 20 sec
		// e2 20
		// e3 20
		System.out.println(driver.getTitle());
		// Static wait
		// Thread.sleep(5000);

		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));

		emailId.sendKeys("test@gmail.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// e4 10 sec
		// e5 10
		// e6 10
		// e6 10
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// nullify
	}

}
