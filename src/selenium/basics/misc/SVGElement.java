package selenium.basics.misc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.basics.DriverSetup;

public class SVGElement {

	public static void main(String[] args) {
		pinterest();
		// flipkart();
	}

	private static void flipkart() {
		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.flipkart.com");

		driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		WebElement flipkartSearchTxt = driver.findElement(By.name("q"));
		flipkartSearchTxt.sendKeys("Levis");

		WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']/*[name()='svg']"));
		System.out.println("displayed? " + searchBtn.isDisplayed());
		System.out.println("enabled? " + searchBtn.isEnabled());
		System.out.println("selected? " + searchBtn.isSelected());

		searchBtn.click();
		System.out.println(driver.getTitle());

		driver.quit();
	}

	private static void pinterest() {
		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.pinterest.com/zoomifier/royalty-free-illustrations-for-your-presentations/");

		WebElement pinterestSearchTxt = driver.findElement(By.name("q"));
		pinterestSearchTxt.sendKeys("dinner ideas easy healthy quick");

		WebElement pinterestSearchBtn = driver.findElement(By.xpath("//form[@name='search']//*[local-name()='svg'"));
		System.out.println("displayed? " + pinterestSearchBtn.isDisplayed());
		System.out.println("enabled? " + pinterestSearchBtn.isEnabled());
		System.out.println("selected? " + pinterestSearchBtn.isSelected());

		if (pinterestSearchBtn.isEnabled()) {
			System.out.println("clicking search");
			pinterestSearchBtn.click();

			List<WebElement> dinnerIdeaLists = driver
					.findElements(By.xpath("//div[@class='GrowthUnauthPinImage']/following::div//figcaption/h3"));
			for (WebElement dinnerIdea : dinnerIdeaLists)
				System.out.println(dinnerIdea.getText());
		} else {
			System.out.println("Not enabled ");
		}
		// driver.quit();
	}
}
