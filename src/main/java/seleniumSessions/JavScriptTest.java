package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavScriptTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		System.out.println(getTitleByJS(driver));
		// generateAlertJS(driver, "Hi Hello saiteja");
		// refreshBrowserBytJS(driver);
		// System.out.println(getBrowserInfo(driver));
		// sendKeysUsingJSwithID(driver,"username","teja@gmail.com");
		// sendKeysUsingJSwithID(driver,"password","teja112345");
		// Thread.sleep(3000);
		// WebElement login=driver.findElement(By.id("loginBtn"));
		// clickElementByJS(login, driver);

		WebElement signUpLink = driver.findElement(By.linkText("Sign up"));

		drawBorder(signUpLink, driver);

	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title").toString();
		return title;
	}

	public static void generateAlertJS(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public static void refreshBrowserBytJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getBrowserInfo(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent").toString();
		return uAgent;
	}

	public static void sendKeysUsingJSwithID(WebDriver driver, String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	
	
}
