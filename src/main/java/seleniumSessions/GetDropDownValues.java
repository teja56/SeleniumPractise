package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropDownValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");

		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

/*	
		Select select =new Select(day);
		List<WebElement> daylist =select.getOptions();
		System.out.println("total days "+ daylist.size());
		
		for(int i=0; i<daylist.size();i++){
		String value=	daylist.get(i).getText();
			System.out.println(value);
		}
*/
		
		getDropDownValues(day);
		getDropDownValues(month);
		getDropDownValues(year);

	}
	
	/**
	 * This method is used to get all the values from the dropdown
	 * @param element
	 */
	public static void getDropDownValues(WebElement element){
		System.out.println("***********************8");
		Select select =new Select(element);
		List<WebElement> dropList =select.getOptions();
		System.out.println("total days "+ dropList.size());
		
		for(int i=0; i<dropList.size();i++){
		String value=	dropList.get(i).getText();
			System.out.println(value);
		}
	}

}
