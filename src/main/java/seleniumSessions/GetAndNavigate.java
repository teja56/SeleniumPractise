package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAndNavigate {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

//		driver.get("https://amazon.in");
	
		driver.navigate().to("https://amazon.in");
		System.out.println(driver.getTitle());
	
	
	
	}

}
