package seleniumtests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchToWindowsTest {

	public static void main(String[] args) throws InterruptedException {

		String browserName = "edge";

		WebDriver driver;

		if (browserName.equals("chrome")) {
			// setting the configuration for chrome driver browser
			System.setProperty("webdriver.chrome.driver",
					"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

			driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches
										// the
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\msedgedriver.exe");

			driver = new EdgeDriver();

		} else

		{ // browser

			System.setProperty("webdriver.gecko.driver",
					"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");// navigation

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Click for Popup']")).click();

		Thread.sleep(2000);

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();// escape
			System.out.println("alert popup is closed");
		} catch (NoAlertPresentException noAlertPresentException) {
			System.out.println("alert not found " + noAlertPresentException.getMessage());
		} finally {// finally block always runs
			System.out.println("alert block executed");
		}

		System.out.println("test completed successfully");

	}

}
