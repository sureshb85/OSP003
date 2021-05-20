package selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\cts_workspace\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	}
}
