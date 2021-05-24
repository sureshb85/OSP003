package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationsExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.navigate().to("https:/www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.close(); // will only close the tabs, child windows
		// driver.quit(); // used to close all the selenium browsers like child windows,
		// tabs, etc
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
	}
}
