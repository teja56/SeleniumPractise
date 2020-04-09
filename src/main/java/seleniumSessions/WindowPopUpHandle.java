package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopUpHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://popuptest.com/goodpopups.html");

		driver.findElement(By.linkText("Good PopUp #3")).click();

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> itr = handles.iterator();
		String parentWindowID = itr.next();
		System.out.println(parentWindowID);
		String childWindowId = itr.next();
		System.out.println(childWindowId);

		driver.switchTo().window(childWindowId);
		System.out.println("child window title is " + driver.getTitle());
		driver.close(); // close the child window

		driver.switchTo().window(parentWindowID);

		System.out.println("Parent window title is " + driver.getTitle());

		driver.quit();

	}

}
