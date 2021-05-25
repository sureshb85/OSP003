package selenium.basics.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.basics.DriverSetup;

public class WebTables2 {

	public static void main(String[] args) {
		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.nyse.com/ipo-center/recent-ipo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[2]/tbody/tr"));
		System.out.println("Total rows: " + totalRows.size());

		List<WebElement> totalCols = driver.findElements(By.xpath("//table[2]/tbody/tr/td"));
		System.out.println("Total cols: " + totalCols);

		driver.quit();
	}

}