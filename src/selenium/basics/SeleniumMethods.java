package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class SeleniumMethods {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");

		// title
		String wikiTitle = driver.getTitle();
		System.out.println("Wiki Title " + wikiTitle);

		// current url of the page
		String wikiUrl = driver.getCurrentUrl();
		System.out.println("Wiki URL " + wikiUrl);

		driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong")).click();
		wikiUrl = driver.getCurrentUrl();
		System.out.println("Wiki URL " + wikiUrl);

		String wikiPageSource = driver.getPageSource();
		System.out.println("Wiki Page Source " + wikiPageSource);

		WebElement wikiSearch = driver.findElement(By.cssSelector("#searchInput"));
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected()); // only applicable for radio and checkboxes

	}
}
