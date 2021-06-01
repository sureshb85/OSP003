package selenium.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertionsExample {

		SoftAssert softAssertObject = new SoftAssert();
	@Test(enabled = false)
	public void getTitle() {
		String title = "My title";

		// driver.getTitle()
		// String driverTitle = "My title";

		// driver.getTitle()
		String driverTitle = "Driver title";

		//hard assertion
		Assert.assertEquals(driverTitle, title);
	}

	@Test
	public void getUserDetails() {
		String username = "username";
		String pasword = "pasword";
		String email = "username@gmail.com";
		long pincode = 560103;

		
		//soft assertion
		System.out.println("username validation");
		softAssertObject.assertEquals(username, "username");

		System.out.println("pasword validation");
		softAssertObject.assertEquals(pasword, "password");

		System.out.println("email validation");
		softAssertObject.assertEquals(email, "username@gmail.com");

		System.out.println("pincode validation");
		softAssertObject.assertEquals(pincode, 560103);
		
		softAssertObject.assertAll();
	}
}
