package selenium.basics.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class IFrameExample {

	public static void main(String[] args) {
		// Radio button
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title " + driver.getTitle());
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total Frames: " + totalFrames.size());
		for (int i = 0; i < totalFrames.size(); i++) {
			System.out.println(i + " - " + totalFrames.get(i).getAttribute("name"));
		}
		
		//switch frame using index
//		driver.switchTo().frame(0);
//		WebElement headerTitle = driver.findElement(By.xpath("/html/body/h1"));
//		System.out.println(headerTitle.getText());
//		driver.switchTo().parentFrame();

		// switch to frame using webelement
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/form/input[4]"));
		System.out.println("within frame - submit button displayed: " + submitBtn.isDisplayed());
	}

}
