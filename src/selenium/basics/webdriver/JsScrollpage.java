package selenium.basics.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.basics.DriverSetup;

public class JsScrollpage {
	public static void main(String[] args) {

		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.w3schools.com/jsref/met_win_scrollby.asp");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600);");
		WebElement reportErrorBtn = driver.findElement(By.xpath("//a[text()='REPORT ERROR']"));
		js.executeScript("arguments[0].scrollIntoView(true);", reportErrorBtn);
	}
}
