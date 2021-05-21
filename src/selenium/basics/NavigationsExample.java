package selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationsExample {
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		System.out.println("my project location" + projectLocation);
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}
}
