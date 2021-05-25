package selenium.basics.webdriver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.basics.DriverSetup;

public class MultipleWindows {
	public static void main(String[] args) {
		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.naukri.com");
		System.out.println("mainWindow " + driver.getTitle());
		List<WebElement> bmsTop = driver.findElements(By.xpath("//div[@class='bmsTop']/ul/li/a"));
		System.out.println("Total " + bmsTop.size());
		for (WebElement element : bmsTop) {
			System.out.println(element.getAttribute("href"));
		}

		String mainWin = driver.getWindowHandle();
		Set<String> allWins = driver.getWindowHandles();
		System.out.println("Total windows: " + allWins.size());
		for (String childWin : allWins) {
			// System.out.println(childWin);
			if (!childWin.equals(mainWin)) {
				driver.switchTo().window(childWin);
				System.out.println("switch: " + childWin + "childTitle: " + driver.getTitle() + "childUrl: "
						+ driver.getCurrentUrl());
				WebElement childImg = driver.findElement(By.tagName("img"));
				System.out.println("src: " + childImg.getAttribute("src") + "alt: " + childImg.getAttribute("alt"));
				driver.close();
			}
			driver.switchTo().window(mainWin);
		}

		driver.quit();
	}
}
