package selenium.basics;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotExample {


	public static void main(String[] args) {
		WebDriver driver = ScreenShotExample.getWebDriver();
		String wikiHeader = "//*[@id='www-wikipedia-org']/div/h1/span";
		String wikicaption = "//*[@id='www-wikipedia-org']/div/h1/strong";

		WebElement header = driver.findElement(By.xpath(wikiHeader));
		System.out.println("Header-->" + header.getText());

		WebElement caption = driver.findElement(By.xpath(wikicaption));
		System.out.println("Caption-->" + caption.getText());

		// screen shot using takeScreenShot interface
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenshotFile = screenShot.getScreenshotAs(OutputType.FILE);
		// dynamic file name

		String filename = new Date().toString().replace(" ", "_").replace(":", "_") + ".jpg";
		File filePath = new File("C:\\Users\\Chaitu\\Desktop\\screenshot\\" + filename);
		try {
			FileUtils.copyFile(screenshotFile, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

	static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\cts_workspace\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		return driver;
	}
}
