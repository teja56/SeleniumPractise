package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// id
		// WebElement email = driver.findElement(By.id("username"));
		// email.sendKeys("naveenanimation20@gmail.com");

		// WebElement pwd = driver.findElement(By.id("password"));
		// pwd.sendKeys("Test@12345");

		// driver.findElement(By.id("username")).sendKeys("test@gmail.com");
		// driver.findElement(By.id("password")).sendKeys("test@1234");
		// driver.findElement(By.id("loginBtn")).click();

		// 2.name

		// driver.findElement(By.name("email")).sendKeys("test@abc.com");

		// 3. xpath:
		// driver.findElement(By.xpath("//*[@id='username']")).sendKeys("teja@gmail.com");
		// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("kolla");

		// 4.css selector
		// driver.findElement(By.cssSelector("#username")).sendKeys("abc@gmil.mm");
		// driver.findElement(By.cssSelector("#password")).sendKeys("abc");

		// 5.class name
		// driver.findElement(By.className("login-email")).sendKeys("abc@abc.com");
		// driver.findElement(By.className("login-password")).sendKeys("abc@abc.com");

		// 6.link text:only for links
		//	driver.findElement(By.linkText("Sign up")).click();
			
		//7. partial link text	
			driver.findElement(By.partialLinkText("Sign")).click();
	
		//8. tag name	
	
	
	
	}

}
