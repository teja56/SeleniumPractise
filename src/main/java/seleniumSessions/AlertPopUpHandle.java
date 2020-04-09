package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if (text.equals("Please enter a valid user name")) {
			System.out.println("correct error message..");
		} else {
			System.out.println("in correct error message");
		}
		alert.accept(); //click on ok button.
	//	alert.dismiss(); //Cancel the alert
	
	
	
	
	
	
	
	}

}
