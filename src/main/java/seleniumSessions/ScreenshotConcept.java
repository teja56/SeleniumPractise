package seleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotConcept {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		takePageScreenshot(driver, "loginpage");
		// get screenshot method and takescreentshot interface
		// type cast takescreenshot interface to driver

		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		WebElement loginButton = driver.findElement(By.id("loginBtn"));

		emailId.sendKeys("test@gmail.com");
		password.sendKeys("test@123");
		// loginButton.click();
		takeElementScreenshot(emailId, "emailId");
		takeElementScreenshot(password, "password");
		takeElementScreenshot(loginButton, "loginPageError");

		takePageScreenshot(driver, "loginpage");

		driver.quit();

	}

	public static void takeElementScreenshot(WebElement element, String fileName) {
		File srcFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void takePageScreenshot(WebDriver driver, String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}