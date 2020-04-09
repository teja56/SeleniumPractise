package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
/*
		List<WebElement> daysList = driver.findElements(By.xpath("//select[@id='day']/option"));
		System.out.println(daysList.size());

		for (int i = 0; i < daysList.size(); i++) {
			String text = daysList.get(i).getText();
			System.out.println(text);
			if (text.equals("10")) {
				daysList.get(i).click();
				break;
			}
		}
*/
		String day ="//select[@id='day']/option";
		String month ="//select[@id='month']/option";
		String year ="//select[@id='year']/option";

		DropDownUtil.selectDropDownValueWithOutSelect(driver, day, "1");
		DropDownUtil.selectDropDownValueWithOutSelect(driver, month, "Aug");
		DropDownUtil.selectDropDownValueWithOutSelect(driver, year, "1993");

	}

}
