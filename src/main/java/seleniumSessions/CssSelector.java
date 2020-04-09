package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);

		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		WebElement loginButton = driver.findElement(By.id("loginBtn"));

		
		//id: #{id}
		//    #username
		//    input#username
		// 	input[id='username'][type='email']
		//button#loginBtn
		
		//class: .{classname}
		//	.form-control.private-form__control.login-email
		// input..form-control.private-form__control.login-email
		
		//input.login-email
		
		//button.login-submit
		
		
		//text:
		// input[id^='username']   ---starting text
		// input[id$='username'] --- ending text
		// input[id$='name']
	
		// input[id*='username'] ---contains
		// input[id*='user']
		
		//		div>input[id='username'] ---- parent and child
		
		
		
		
		
		
		
		
	}

}
