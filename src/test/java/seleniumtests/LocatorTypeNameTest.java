package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorTypeNameTest {

	public static void main(String[] args) throws InterruptedException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the

		// browser

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://in.linkedin.com/");// navigation to google page

		// Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));

		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("session_key")));

		//wait.until(ExpectedConditions.(By.name("session_key")));

		driver.findElement(By.name("session_key")).isDisplayed();// checks element is displayed

		System.out.println("linked in login page loaded successfully");

		Thread.sleep(2000);

		driver.findElement(By.name("session_key")).sendKeys("guru@sqaguru.co.in");

		System.out.println("entered user name successfully");

		Thread.sleep(2000);

		driver.findElement(By.name("session_password")).sendKeys("Password@123");// type my password on the field

		int totalInputElements = driver.findElements(By.className("input__input")).size();

		System.out.println("total input elements are : " + totalInputElements);
		if (totalInputElements == 3) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		int totalButton = driver.findElements(By.tagName("button")).size();

		System.out.println("totalButton: " + totalButton);

		int totalLabels = driver.findElements(By.tagName("label")).size();

		System.out.println("totalLabels: " + totalLabels);

		driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"))
				.sendKeys("username");

		driver.findElement(By.cssSelector("div.sign-in-form__form-input-container > div > input#session_key"))
				.sendKeys("TypedUsingCSSSelector");

	}

}
