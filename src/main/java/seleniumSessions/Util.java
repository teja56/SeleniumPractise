package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	WebDriver driver;

	public Util(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to create the webElement on the basis of By locator.
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElementMethod(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * This method is used to click on element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try{
		getElementMethod(locator).click();
		} catch(Exception e){
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
		}

	/**
	 * This method is used to pass the values in a WebElement
	 * 
	 * @param locator
	 */
	public void doSendKeys(By locator, String value) {
		try{
			getElementMethod(locator).sendKeys(value);
		}catch(Exception e){
			System.out.println("Some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		
		}
	}
	
	public void waitForElementPresent(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public void waitForElementPresentTimeOut(By locator, int time){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public String waitForTitlePresent(String title, int time){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
}
