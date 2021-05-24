package selenium.basics.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;

public class OtherLocator_ByIdOrName {
	public static void main(String[] args) {

		// ByAll,
		// ByChained,
		// ByIdOrName

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");

		//using id
		WebElement wikiSearch = driver.findElement(new ByIdOrName("searchInput"));
		//using name
		//WebElement wikiSearch = driver.findElement(new ByIdOrName("search"));
		wikiSearch.sendKeys("selenium java testng");
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		driver.quit();
	}
}
