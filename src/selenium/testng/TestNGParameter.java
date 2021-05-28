package selenium.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameter {

	@Parameters({ "browser", "browserVersion" })
	@Test
	public void testParameter(@Optional("chrome")String browser, @Optional("89.02.1524")String browserVersion) {
		System.out.println("Browser: " + browser + "\tbrowserVersion: " + browserVersion);
	}

}
