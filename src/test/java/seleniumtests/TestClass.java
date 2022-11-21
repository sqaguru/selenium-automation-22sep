package seleniumtests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass /* extends BaseTest */ {
	@Parameters("configtype")
	@Test

	public void myTest(String configType) {
		System.out.println("test message" + configType);
	}
}
