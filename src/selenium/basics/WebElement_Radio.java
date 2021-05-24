package selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElement_Radio {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = DriverSetup.getWebDriver();

		// select radio box using if else condition
		// selectGender();
		// closeBrowser();

		// select radio box value using for loop
		clickGender();
		// closeBrowser();
	}

	private static void clickGender() {
		String clickGender = "Male";
		driver.get(
				"https://en-gb.facebook.com/r.php?locale=en_GB&campaign_id=973072061&extra_1=s%7Cc%7C256741341326%7Ce%7Cfacebook%7C&placement&creative=256741341326&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D973072061%26adgroupid%3D54006406691%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-297690534863%26loc_physical_ms%3D9061994%26loc_interest_ms%3D%26feeditemid%3D19894516786%26param1%3D%26param2%3D&gclid=EAIaIQobChMIvfGDgJfa8AIVhraWCh2ulQrfEAAYASABEgLSZvD_BwE");
		List<WebElement> genders = driver.findElements(By.xpath("//*[@data-name='gender_wrapper']//label"));
		for (WebElement gender : genders) {
			System.out.println(gender.getText());
			if (gender.getText().equals(clickGender)) {
				// System.out.println("clicking on gender:" + clickGender + "with xpath-->
				// //*[@data-name='gender_wrapper']//label[text()='" + clickGender +
				// "']/preceding-sibling::input");
				driver.findElement(By.xpath("//*[@data-name='gender_wrapper']//label[text()='" + clickGender
						+ "']/preceding-sibling::input")).click();
				break;
			} /*
				 * else { System.out.println("Skip gender " + gender.getText() + "\twe need " +
				 * clickGender ); }
				 */
		}
	}

	private static void selectGender() {
		String selectGender = "Custom";
		driver.get(
				"https://en-gb.facebook.com/r.php?locale=en_GB&campaign_id=973072061&extra_1=s%7Cc%7C256741341326%7Ce%7Cfacebook%7C&placement&creative=256741341326&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D973072061%26adgroupid%3D54006406691%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-297690534863%26loc_physical_ms%3D9061994%26loc_interest_ms%3D%26feeditemid%3D19894516786%26param1%3D%26param2%3D&gclid=EAIaIQobChMIvfGDgJfa8AIVhraWCh2ulQrfEAAYASABEgLSZvD_BwE");
		if (selectGender.equals("Female")) {
			driver.findElement(By.xpath("//*[@data-name='gender_wrapper']//input[@value='1']")).click();
		} else if (selectGender.equals("Male")) {
			driver.findElement(By.xpath("//*[@data-name='gender_wrapper']//input[@value='2']")).click();
		} else if (selectGender.equals("Custom")) {
			driver.findElement(By.xpath("//*[@data-name='gender_wrapper']//input[@value='-1']")).click();
		}
	}

	private static void closeBrowser() {
		driver.quit();
	}
}
