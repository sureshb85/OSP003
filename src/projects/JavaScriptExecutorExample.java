package projects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.basics.DriverSetup;

public class JavaScriptExecutorExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverSetup.getWebDriver();
		String baseUrl = "https://webapps.tekstac.com/Agent_Registration/";
		driver.get(baseUrl);

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("document.getElementsByName('firstname')[0].value=arguments[2]", "firstnameA", "firstnameB", "firstnameC");
		jse.executeScript("document.getElementsByName('lastname')[0].value=arguments[0]", "lastname");
		jse.executeScript("document.getElementsByName('username')[0].value=arguments[0]", "username");
		jse.executeScript("document.getElementsByName('password')[0].value=arguments[0]", "password");
		jse.executeScript("document.getElementsByName('phonenumber')[0].value=arguments[0]", "0123456789");
		jse.executeScript("document.getElementsByName('email')[0].value=arguments[0]", "email@email.com");
		WebElement submitBtn = (WebElement) jse.executeScript("return document.getElementById('submit')");
		jse.executeScript("arguments[0].click();", submitBtn);
		Thread.sleep(3000);
		String successText = (String) jse.executeScript("return document.querySelector('h2').innerHTML");
		System.out.println("message: " + successText);
		driver.quit();
	}
}
