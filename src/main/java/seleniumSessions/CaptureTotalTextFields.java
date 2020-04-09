package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTotalTextFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php");

//		List<WebElement> listInputs =driver.findElements(By.tagName("input"));
	
		List<WebElement> listInputs =driver.findElements(By.xpath("//input[@type='text']"));

		System.out.println(listInputs.size());
		
	
	}

}
