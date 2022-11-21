package seleniumtests;

import org.testng.annotations.BeforeMethod;

public class Base {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
}
