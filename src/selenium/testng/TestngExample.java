package selenium.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngExample {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am before method annotation");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before test annotation");
	}

	@Test(priority = 2, enabled = false)
	private void hello() {
		System.out.println("hello");
	}

	@Test(priority = 0)
	private void hi() {
		System.out.println("hi");
	}

	@Test(priority = 3, enabled = false)
	private void helloWorld() {
		System.out.println("hello world");
	}

	@Test(priority = 1, dependsOnMethods = "hi")
	private void hiWorld() {
		System.out.println("hi world");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am after test annotation");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am after method annotation");
	}

}
