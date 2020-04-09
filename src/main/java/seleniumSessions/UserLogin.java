package seleniumSessions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		doLogin(driver, getUserMap(), "admin");
	}

	public static Map<String, String> getUserMap() {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("admin", "admin_admin");
		userMap.put("patient", "tom@gmail.com_test123");
		userMap.put("doctor", "peter@gmail.com_test12345");

		return userMap;
	}

	public static void doLogin(WebDriver driver, Map<String, String> userMap, String userKey) {
		driver.findElement(By.id("username")).sendKeys(userMap.get(userKey).split("_")[0]);
		driver.findElement(By.id("password")).sendKeys(userMap.get(userKey).split("_")[1]);

	}
}
