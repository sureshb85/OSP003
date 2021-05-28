package selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	static final String PROJECT_DIR = System.getProperty("user.dir");

	public static WebDriver createDriver(String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", PROJECT_DIR + "\\drivers\\msedgedriver.exe");
			return new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", PROJECT_DIR + "\\drivers\\geckodriver.exe");
			return new FirefoxDriver();
		} else {
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(false);
			options.addArguments("start-maximized");
			options.addArguments("--incognito");
			System.setProperty("webdriver.chrome.driver", PROJECT_DIR + "\\drivers\\chromedriver.exe");
			return new ChromeDriver(options);

		}
	}
}
