package selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\cts_workspace\\DRIVERS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// launch facebook application
		driver.get("https://www.facebook.com");

		// click on create new account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// org.openqa.selenium.NoSuchElementException
		// or incorrect xpath ------------------
		// //a[@data-testid='open-regiion-form-button']
		// occurs when element is not found on the page ------------------
		// //a[text()='Create Account']
		// or dynamically changing xpaths ------------ //a[@id='u_0_2_n0']

		// enter text in email textbox
		driver.findElement(By.name("email")).sendKeys("9740204455");
		// enter text in password textbox
		driver.findElement(By.id("pass")).sendKeys("abc123455");

		// iframes -- popups
		// windows -- multiple windows
		// alert - popups
		// waits -- implicit wait / explicit / fluent

		driver.quit();
	}

}
