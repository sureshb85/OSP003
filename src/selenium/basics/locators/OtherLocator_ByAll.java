package selenium.basics.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class OtherLocator_ByAll {
	public static void main(String[] args) {

		// ByAll,
		// ByChained,
		// ByIdOrName

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		// ByAll
		//new ByAll(By.xpath(""), By.cssSelector(""), By.name(""));
		
		WebElement wikiSearch = driver.findElement(new ByAll(By.xpath("//input[@id='searchInputttttt']"),
				By.id("searchInputtttttt"), By.cssSelector("#searchInput")));
		wikiSearch.sendKeys("selenium java testng");
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		driver.quit();
	}
}
