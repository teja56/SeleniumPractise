package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		// Top Casting

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // 1. Open the browser
		driver.get("https://www.google.com"); // 2. enter the url

		String title = driver.getTitle();// 3. get the title
		System.out.println(title);
		
		//4. Validation point
		if (title.equals("Google")) {
			System.out.println("correct tile");
		} else{
			System.out.println("in correct title");
		}
	
	
		System.out.println(driver.getCurrentUrl());
	//	System.out.println(driver.getPageSource());
		
		
		
	//	driver.quit();//5. close the browser
	//	System.out.println(driver.getTitle()); //NoSuchSessionException
	//	Session ID is null. Using WebDriver after calling quit()?
		
		
		driver.close(); //close the browser
	//	System.out.println(driver.getTitle()); //invalid session id
	}
	

}
