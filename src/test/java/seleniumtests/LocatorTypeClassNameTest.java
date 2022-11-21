package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTypeClassNameTest {

	public static void main(String[] args) throws InterruptedException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the
												// browser
		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://in.linkedin.com/");// navigation to google page

		Thread.sleep(2000);

		driver.findElement(By.name("session_key")).isDisplayed();// checks element is displayed

		driver.findElement(By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']")).click();

		System.out.println("click performed");

	}

}
