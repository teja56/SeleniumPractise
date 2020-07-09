package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");

		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		Select select = new Select(day); // we have to pass the webelement
	//	select.selectByIndex(10);
		System.out.println(select.isMultiple());
		
		/*
		Select select = new Select(day); // we have to pass the webelement
		select.selectByVisibleText("5");

		Select select1 = new Select(month); // we have to pass the webelement
		select1.selectByVisibleText("May");

		Select select2 = new Select(year); // we have to pass the webelement
		select2.selectByVisibleText("1993");
*/
	//	selectValueFromDropDown(day, "5");	
	//	selectValueFromDropDown(month, "May");
	//	selectValueFromDropDown(year, "1994");
	
	
	}
	
	
	/**
	 * this Method is used to select the value from a drop down on the basis of given text
	 * @param element
	 * @param value
	 */
	public static void selectValueFromDropDownByText(WebElement element, String value){
		Select select =new Select(element);
		select.selectByVisibleText(value);	
	}
	public static void selectValueFromDropDownByIndex(WebElement element, int index){
		Select select =new Select(element);
		select.selectByIndex(index);	
	}
	/**
	 * This method is used to select the values from the dropdown without select class
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public static void selectDropDownValueWithOutSelect(WebDriver driver, String locator, String value){
		List<WebElement> dropList = driver.findElements(By.xpath(locator));
		System.out.println(dropList.size());

		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			System.out.println(text);
			if (text.equals(value)) {
				dropList.get(i).click();
				break;
			}
		}
	}
}
