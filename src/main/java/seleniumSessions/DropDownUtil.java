package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {

	/**
	 * This method is used to get all the values from the dropdown
	 * @param element
	 * @return 
	 */
	public static ArrayList<String> getDropDownValues(WebElement element){
		System.out.println("***********************8");
		Select select =new Select(element);
		List<WebElement> dropList =select.getOptions();
		System.out.println("total days "+ dropList.size());
		ArrayList<String> ar =new ArrayList<String>();
		for(int i=0; i<dropList.size();i++){
		String value=	dropList.get(i).getText();
			ar.add(value);
		}
		return ar;
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
	/**
	 * this Method is used to select the value from a drop down on the basis of given text
	 * @param element
	 * @param value
	 */
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
