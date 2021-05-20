package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {

		// chromedriver
		System.setProperty("webdriver.chrome.driver", "D:\\cts_workspace\\DRIVERS\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver(); // ddriver //chromedriver //chrome
		chrome.get("https://www.google.com");
		//link text
		//chrome.findElement(By.linkText("Gmail")).click();
		
		//partial link text
		//chrome.findElement(By.partialLinkText("mail")).click();
		
		//name
		chrome.findElement(By.name("q")).sendKeys("google search");

	}
}