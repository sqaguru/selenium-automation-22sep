package seleniumtests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGDependenchyTests extends BaseTest {
	@Test(groups = "SMOKE")
	public void test1() {
		Reporter.log("test1() executed ", true);
	}

	@Test(dependsOnMethods = "test1", groups = "SMOKE")
	public void test2() {
		Reporter.log("test2() executed ", true);
	}

	@Test(dependsOnMethods = "test4") /* hard dependency */
	public void test3() {
		Reporter.log("test3() executed ", true);
	}

	@Test(dependsOnMethods = "test2")
	public void test4() {
		Reporter.log("test4() executed ", true);
		String expectedTitle = "google";
		String actualTitle = "Google";
		Assert.assertEquals(actualTitle, expectedTitle, "verifying google page title");
	}

	@Test(dependsOnMethods = "test4", alwaysRun = true) /* soft dependency */
	public void test5() {
		Reporter.log("test5() executed ", true);
	}

}
