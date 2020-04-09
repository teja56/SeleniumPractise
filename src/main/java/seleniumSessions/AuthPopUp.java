package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String username ="admin";
		String password ="admin";
	
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");

		
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		
	}

}
