package projects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import selenium.basics.DriverSetup;

public class HandleAlertPromptandConfirmBox {

	public static void main(String[] args) {
		Duration timeoutSeconds = Duration.ofSeconds(30);
		Duration pollingSeconds = Duration.ofSeconds(2);
		WebDriver driver = DriverSetup.getWebDriver();
		Alert alert = null;

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds)
				.pollingEvery(pollingSeconds).withMessage("Timeout occured!")
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		// project/base url
		String projectUrl = "http://demo.automationtesting.in/Alerts.html";

		// launch url
		driver.get(projectUrl);

		// Mouse hover over Switch To
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		
		// Click on Alerts
		WebElement alertMenu = driver.findElement(By.xpath("//ul/li/a[text()='Alerts']"));
		action.moveToElement(alertMenu);
		alertMenu.click();

		
		// Right Side Click the link "click the button to display an alert box.
		driver.findElement(
				By.xpath("//div[@id='OKTab']/button[//text()[normalize-space()='click the button to display an alert box:']]"))
		.click();
		
		// Check whether alert pop up appears or not.
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		
		// Click the Link "Alert with OK & Cancel".
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='active']//a[//text()[normalize-space()='Alert with OK & Cancel']]")));
		driver.findElement(
				By.xpath("//li[@class='active']//a[//text()[normalize-space()='Alert with OK & Cancel']]")).click();
		
		// Right Side Click the link "click the button to display a confirm box.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='OKTab']/button[//text()[normalize-space()='click the button to display a confirm box:']]")));
		driver.findElement(By.xpath("//div[@id='OKTab']/button[//text()[normalize-space()='click the button to display a confirm box:']]")).click();
		
		// Check whether confirm box pop up appears or not.
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.dismiss();
		
		// Click the Link "Alert with Textbox".
		driver.findElement(
				By.xpath("//li[@class='active']//a[//text()[normalize-space()='Alert with Textbox']]"))
		.click();
		// Right Side Click the link "click the button to display an prompt box.
		driver.findElement(
				By.xpath("//div[@id='OKTab']/button[//text()[normalize-space()='click the button to display an prompt box:']]"))
		.click();
		// Check whether prompt box pop up appears or not.
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		
		// Enter Value inside the text
		alert.sendKeys("Java Selenium");
		
		// Click on Ok
		alert.accept();
		
		// Close the browser
		driver.quit();

	}

}
