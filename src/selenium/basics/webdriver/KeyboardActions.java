package selenium.basics.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.basics.DriverSetup;

public class KeyboardActions {
	public static void main(String[] args) throws InterruptedException {
		Actions action = null;

		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.facebook.com/");
		action = new Actions(driver);

		// captial letters
		driver.findElement(By.id("email")).sendKeys(Keys.SHIFT, "java selenium");

		// selecting all elements on the page
		// action.sendKeys(Keys.chord(Keys.CONTROL, "a")).perform();
		// down arrow
		 action.sendKeys(Keys.ARROW_DOWN).perform();

		// tab step1
		driver.findElement(By.id("email")).sendKeys(Keys.TAB);

		// password field inputtting text step2
		action.sendKeys("suresh").perform();

		// refresh the page
		action.sendKeys(Keys.F5).perform();

		// enter button
		action.sendKeys(Keys.ENTER).perform();

		// refresh the page
		// driver.get(driver.getCurrentUrl());
		// driver.findElement(By.id("pass")).sendKeys("suresh");
		// driver.quit();
	}
}
