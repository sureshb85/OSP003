package selenium.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataparameters {

	String user = "A";
	String pass = "P";
	String id = "I";

	String user1 = "A1";
	String pass1 = "P1";
	String id1 = "I1";

	String user2 = "A2";
	String pass2 = "P2";
	String id2 = "I2";

	@Test(enabled = false)
	public void testData1() {
		System.out.println("Username " + user + " - " + " Password " + pass + " - " + " Id " + id);
	}

	@Test(enabled = false)
	public void testData2() {
		System.out.println("Username " + user1 + " - " + " Password " + pass1 + " - " + " Id " + id1);
	}

	@Test(enabled = true)
	public void testData3() {
		System.out.println("Username " + user2 + " - " + " Password " + pass2 + " - " + " Id " + id2);
	}

	@Test(dataProvider = "fetchData", description = "my data provider")
	public void testData(String user, String pass) {
		System.out.println("Username " + user + " - " + " Password " + pass);
	}

	@DataProvider
	public Object[][] fetchData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "username1";
		data[0][1] = "password1";

		data[1][0] = "username2";
		data[1][1] = "password2";

		data[2][0] = "username3";
		data[2][1] = "password3";

		return data;

	}
}
