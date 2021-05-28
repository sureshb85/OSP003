package selenium.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryExample {
	int i = 0;

	@Test(retryAnalyzer = selenium.testng.MyTestNGRetryer.class)
	public void testA() {
		System.out.println("i: " + i);
		i++;
		if (i == 5) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
}
