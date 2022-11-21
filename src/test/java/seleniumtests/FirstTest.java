package seleniumtests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

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

		captureScreenShot("GoogleLandingPage");

		String browserTitle = driver.getTitle();// returns current browser title

		Thread.sleep(2000);

		Reporter.log("browserTitle: " + browserTitle, true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("test method executed completely");
		//driver.quit();
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("test class executed completely");
		driver.quit();
	}

	@Test // testng Test annotation => verifyGoogleTitle is a Test Case
	public static void verifyGoogleTitle() throws InterruptedException, IOException {

		driver.findElement(By.name("q")).sendKeys("selenium.dev");

		captureScreenShot("GoogleSearchingPage");

		File elementSnapShot = driver.findElement(By.name("q")).getScreenshotAs(OutputType.FILE);

		File targetFile = new File(
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\screenshots\\searchBar.png");

		FileUtils.copyFile(elementSnapShot, targetFile);

		driver.findElement(By.name("q")).submit();

		for (int i = 1; i < 10; i++) {
			boolean hasPageLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
					.equalsIgnoreCase("complete");
			if (hasPageLoaded) {
				break;
			}
			Thread.sleep(1000);
		}
		Reporter.log("page loaded completely", true);

		captureScreenShot("GoogleResultPage");

		captureScreenShot("GoogleResultPage2");

	}

	@Test // testng Test annotation => verifyGoogleTitle is a Test Case
	public static void verifyGoogleTitleForTestNG() throws InterruptedException, IOException {

		driver.findElement(By.name("q")).sendKeys("testng.org");

		captureScreenShot("GoogleSearchingPage");

		File elementSnapShot = driver.findElement(By.name("q")).getScreenshotAs(OutputType.FILE);

		File targetFile = new File(
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\screenshots\\searchBar.png");

		FileUtils.copyFile(elementSnapShot, targetFile);

		driver.findElement(By.name("q")).submit();

		for (int i = 1; i < 10; i++) {
			boolean hasPageLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
					.equalsIgnoreCase("complete");
			if (hasPageLoaded) {
				break;
			}
			Thread.sleep(1000);
		}
		Reporter.log("page loaded completely", true);

		captureScreenShot("GoogleResultPage");

		captureScreenShot("GoogleResultPage2");

	}

	private static void captureScreenShot(String pageName) throws IOException {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File targetFile = new File(
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\screenshots\\"
						+ pageName + ".png");

		FileUtils.copyFile(sourceFile, targetFile);

	}

}
