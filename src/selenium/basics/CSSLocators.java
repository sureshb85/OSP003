package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\cts_workspace\\DRIVERS\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver(); 
		chrome.get("https://www.wikipedia.org");
		
	// css selectors id's are identified using #
	// css selectors class's are identified using . (dot)
		chrome.findElement(By.cssSelector("#searchInput")).sendKeys("using css selector");
		//chrome.findElement(By.cssSelector(".search-input > input")).sendKeys("using css selector");
		
		
		// using xpath ------------ //input[@id='searchInput']
		// using css selector -------- input#searchInput
	}
}
