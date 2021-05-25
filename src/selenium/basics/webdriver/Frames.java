package selenium.basics.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.basics.DriverSetup;

public class Frames {
	public static void main(String[] args) {

		WebDriver driver = DriverSetup.getWebDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");

		// by.xpath, by.cssselector, by.linktext, others
		List<WebElement> all_frames = driver.findElements(By.tagName("iframe"));
		for (WebElement frame : all_frames) {
			System.out.println(frame.getAttribute("name"));
		}

		// try home on the page
		WebElement tryHome = driver.findElement(By.id("tryhome"));
		System.out.println("before switching to frame: tryHome displayed: " + tryHome.isDisplayed());

		// submit button within frame
		/*
		 * WebElement submitBtn =
		 * driver.findElement(By.xpath("/html/body/form/input[7]"));
		 * System.out.println("Outside of frame - submit button " +
		 * submitBtn.isDisplayed());
		 */

		// switch to frame using id or name
		driver.switchTo().frame("iframeResult");
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/form/input[7]"));
		System.out.println("within frame - submit button displayed: " + submitBtn.isDisplayed());

		// switch back to main page
		driver.switchTo().parentFrame();
		tryHome = driver.findElement(By.id("tryhome"));
		System.out.println("After switching out of frame: tryHome displayed: " + tryHome.isDisplayed());

		
		String frameName = "iframeResult";
		String genderRadioBtn = "male";
		// dynamic switching of all the frames
		for (int i = 0; i < all_frames.size(); i++) {
			System.out.println((i + 1) + " -- name: " + all_frames.get(i).getAttribute("name") + " id:"
					+ all_frames.get(i).getAttribute("id"));
			String myFrame = all_frames.get(i).getAttribute("name");
			if (myFrame.equals(frameName)) {
				driver.switchTo().frame(frameName);
				try {
					System.out.println("after switching to frame " + tryHome.isDisplayed());
				} catch (Exception e) {
					System.out.println("Element tryHome is not found on the frame");
				}
				List<WebElement> genders = driver.findElements(By.xpath("//input[@type='radio']"));
				for (WebElement gender : genders) {
					System.out.println(gender.getAttribute("value"));
					String gen = gender.getAttribute("value");
					if (gen.equals(genderRadioBtn)) {
						gender.click();
						break;
					}
				}
				break;
			}
		}
		driver.switchTo().parentFrame();
		System.out.println("after coming out of the frame " + tryHome.isDisplayed());

		driver.quit();
	}
}
