package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import selenium.basics.DriverSetup;

public class TestRoyalCaribbean {
	public static void main(String[] args) {
		Duration d = Duration.ofSeconds(45);
		Duration p = Duration.ofSeconds(4);
		WebDriver driver = DriverSetup.getWebDriver();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(d).pollingEvery(p)
				.withMessage("Timeout occured!")
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		// project/base url
		String projectUrl = "https://www.royalcaribbean.com";

		// launch url
		driver.get(projectUrl);

		// wait for popup to appear and close
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='email-capture__content']")));
		WebElement signUpPopup = driver.findElement(By.xpath("//*[name()='svg']"));
		wait.until(ExpectedConditions.elementToBeClickable(signUpPopup));
		signUpPopup.click();
		
		// scroll into holiday cruises
		////a[text()='Holiday Cruises']
		WebElement holidyCruisesLink = driver.findElement(By.xpath("//a[text()='Holiday Cruises']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", holidyCruisesLink);
		holidyCruisesLink.click();
		
		//Check the presence of search option. 
		WebElement searchIconBtn = driver.findElement(By.id("rciSearchHeaderIcon"));
		boolean isSeachIconDisplayed = searchIconBtn.isDisplayed(); 
		System.out.println("Search icon displayed: " + isSeachIconDisplayed);
		
		//Search for "Rhapsody of the Seas". 
		wait.until(ExpectedConditions.elementToBeClickable(searchIconBtn));
		searchIconBtn.click();
		
		WebElement searchInputTxt = driver.findElement(By.id("rciSearchInput"));
		searchInputTxt.sendKeys("Rhapsody of the Seas");
		searchInputTxt.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.titleContains("Site Search | Royal Caribbean Cruises"));
		
		//Get the number of search results displayed and Compare it with 300000. 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='searchResultsNumber__total']")));
		WebElement searchResults = driver.findElement(By.xpath("//div[@class='searchResultsNumber__total']"));
		System.out.println(searchResults.getText());
		String[] noOfSearchResults = searchResults.getText().split(" ");
		System.out.println("Total search results: " + noOfSearchResults[1].replace(",", ""));
		
		int totalSearchResults = Integer.parseInt(noOfSearchResults[1].replace(",", ""));
		if(totalSearchResults > 300000)
			System.out.println("search results: " + totalSearchResults + " > 300000 ");
		else
			System.out.println("search results: " + totalSearchResults + " < 300000 ");
		
		//Find and click on "Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises" in the search result
		////a[text()='Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises']
		driver.findElement(By.linkText("Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises")).click();
		
		//Check for the Deck plan image. If the image displays, print status as Pass otherwise Fail.
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='deck-image']")));
		WebElement deckPlanImg =  driver.findElement(By.xpath("//img[@class='deck-image']"));
		if(deckPlanImg.isDisplayed())
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		
		//Select View as Deck Eight. 
		Select selectDeck = new Select(driver.findElement(By.id("deckDropdown")));
		selectDeck.selectByValue("BR");
		
		//Check the presence of Royal Suite, if it presents print the status as Pass otherwise Fail. 
		WebElement royalSuiteTxt = driver.findElement(By.xpath("//h4[contains(text(), 'Royal Suite')]"));
		if(royalSuiteTxt.isDisplayed())
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		//Close the browser. 
		driver.quit();
	}
}
