package seleniumtests;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTests extends BaseTest {

	@Test(priority = 1, groups = "SMOKE")
	public void test1() {
		Reporter.log("test1() executed ", true);
	}

	@Test(priority = 3, enabled = true, groups = "SMOKE")
	public void test2() {
		Reporter.log("test2() executed ", true);
	}

	@Test(priority = 2, enabled = false)
	public void test3() {
		Reporter.log("test3() executed ", true);
	}

	@Test(priority = 4)
	public void test4() {
		Reporter.log("test4() executed ", true);
	}

}
