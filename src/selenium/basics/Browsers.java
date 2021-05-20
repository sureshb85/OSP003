package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsers {

	public static void main(String[] args) {

		// chromedriver
		System.setProperty("webdriver.chrome.driver", "D:\\cts_workspace\\DRIVERS\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver(); // ddriver //chromedriver //chrome
		chrome.get("https://www.wikipedia.org");
		//xpath
		//chrome.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium");
		//id
		chrome.findElement(By.id("searchInput")).sendKeys("Selenium");
		chrome.findElement(By.xpath("//i[text()='Search']")).click();

		// chrome is an opbject of chromedriver class
		// findelement() method will identify the element on the page using the By class
		// By class different methods
		// By.ByClassName
		// By.ByCssSelector
		// By.ById
		// By.ByLinkText
		// By.ByName
		// By.ByPartialLinkText
		// By.ByTagName
		// By.ByXPath

		/*
		 * // firefoxdriver System.setProperty("webdriver.gecko.driver",
		 * "D:\\cts_workspace\\DRIVERS\\geckodriver.exe"); WebDriver firefox = new
		 * FirefoxDriver();
		 * 
		 * // Edgedriver System.setProperty("webdriver.edge.driver",
		 * "D:\\cts_workspace\\DRIVERS\\msedgedriver.exe"); WebDriver edge = new
		 * EdgeDriver();
		 */
	}
}