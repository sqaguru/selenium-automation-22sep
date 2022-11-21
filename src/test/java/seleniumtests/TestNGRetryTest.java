package seleniumtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryTest {
	@Test
	public void myFailingTest() {
		System.out.println("step#1");
		Assert.assertTrue(false);// marking a test case as fail
		System.out.println("step#2");
	}
}
