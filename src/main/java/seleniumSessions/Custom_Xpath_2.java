package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//absoulte xpath: //html//div//div[2]/div[1]//span
		//relative xpath: //span[@id='test']
		
		// Xpath Axes:

		// div[@class='input-group']//following::input[@name='username']
		// (//div[@class='input-group']//following::input)[1]
		// //input[@name='username']//parent::div
		// input[@name='username']//preceding::div
		// div[@class='input-group']//child::input[@name='username']

		// span[text()='naveen k']//ancestor::td//preceding-sibling::td//input

		// span[text()='naveen k']//ancestor::td//preceding-sibling::td//child::input

		//a[contains(text,'XXXX')]//parent::td//preceding-sibling::td//input[@name=''contact_id and @type='checkbox'];
		
		//a[contains(text(),'RG Sharma')]//parent::div//following-sibling::div[@class='cell runs']
		
		
		//Reversing xpath: travering from child to parent -> grand parent -> super parent -> top parent in DOM
		
		//input[@id='username']/../../../../../../..
		
		
		
		
		
		
		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		WebElement loginButton = driver.findElement(By.id("loginBtn"));

		Actions action = new Actions(driver);
		action.sendKeys(emailId, "naveenanimation20@gmail.com").build().perform();
		action.sendKeys(password, "Test@12345").build().perform();

		action.click(loginButton).build().perform();

		
		driver.navigate().to("");
		
		driver.findElement(By.xpath("")).click();
	}

}
