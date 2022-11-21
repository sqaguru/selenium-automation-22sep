package seleniumtests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	static WebDriver driver;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the
									// browser
		Thread.sleep(2000);// milli-seconds, 2 Seconds
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {

		driver.get("https://www.google.com/");// navigation to google page

		Thread.sleep(2000);
		String browserTitle = driver.getTitle();// returns current browser title

		Thread.sleep(2000);

		Reporter.log("browserTitle: " + browserTitle, true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("afterMethod", true);
	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("beforeSuite", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("afterSuite", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("beforeTest", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("afterTest", true);
	}

	@BeforeGroups("SMOKE")
	public void beforeGrups() {
		System.out.println("before groups");
	}

	@AfterGroups("SMOKE")
	public void afterGrups() {
		System.out.println("after groups");
	}

}
