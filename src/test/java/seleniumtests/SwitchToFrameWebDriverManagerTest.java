package seleniumtests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToFrameWebDriverManagerTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		String browserName = "edge";

		if (browserName.equals("chrome")) {
			// setting the configuration for chrome driver browser
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe"
			 * );
			 */
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches
										// the
		} else if (browserName.equals("edge")) {
			/*
			 * System.setProperty("webdriver.edge.driver",
			 * "D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\msedgedriver.exe"
			 * );
			 */
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\geckodriver.exe"
			 * );
			 */

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		/* implicit wait */
		/* applicable for all the steps */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);// milli-seconds, 2 Seconds, java wait

		driver.get(
				"https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/edge/package-summary.html");// navigation
		driver.switchTo().frame("packageListFrame");// switch the selenium control to frame packageListFrame

		int totalLinksOnFramePackageList = driver.findElements(By.tagName("a")).size();

		List<WebElement> packageList = driver.findElements(By.tagName("a"));

		for (WebElement element : packageList) {
			System.out.println("link text(): " + element.getText());
		}

		System.out.println("totalLinksOnFramePackageList: " + totalLinksOnFramePackageList);

		driver.switchTo().defaultContent();// Selenium control coming out of any frame

		driver.switchTo().frame("packageFrame");// switching control to package frame

		int totalLinksOnFramePackage = driver.findElements(By.tagName("a")).size();

		System.out.println("totalLinksOnFramePackage: " + totalLinksOnFramePackage);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("classFrame");

		int totalLinksOnClasses = driver.findElements(By.tagName("a")).size();

		System.out.println("totalLinksOnClasses: " + totalLinksOnClasses);

		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		int index = 0;
		for (WebElement frame : frames) {
			driver.switchTo().frame(frame);// switching by element

			if (driver.findElement(By.xpath("//h1")).getText().contains("classes")) {
				break;
			}
			driver.switchTo().defaultContent();
			index++;
		}

		driver.findElement(By.tagName("a")).click();
	}

}
