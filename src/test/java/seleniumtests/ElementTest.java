package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class ElementTest {

	public static void main(String[] args) throws InterruptedException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		TestListener listener = new TestListener();

		WebDriver driver1 = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the

		// browser

		WebDriver driver = new EventFiringDecorator(listener).decorate(driver1);

		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://demoqa.com/text-box");// navigation to google page

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("sqa guru");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("guru@sqaguru.co.in");

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Pune, India");

		Thread.sleep(1000);

		String expectedPermanentAddress = "Hyderabad, India";

		driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(expectedPermanentAddress);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@id='submit']")).click();

		String actualName = driver.findElement(By.xpath("//p[@id='name']")).getText();

		System.out.println("actualName: " + actualName);

		if (actualName.equals("Name:sqa guru")) {
			System.out.println("verify name printed? PASSED");
		} else {
			System.out.println("verify name printed? FAILED");
		}

		String actualEmailId = driver.findElement(By.id("email")).getText();

		if (actualEmailId.equals("Email:guru@sqaguru.co.in")) {
			System.out.println("Verify email id? Passed");
		} else {
			System.out.println("Verify email id? Failed");
		}

		String actualCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();

		System.out.println("actualCurrentAddress: " + actualCurrentAddress);

		if (actualCurrentAddress.equals("Current Address :Pune, India")) {
			System.out.println("Verify address ? Passed");
		} else {
			System.out.println("Verify address ? Failed");
		}

		String actualPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

		System.out.println("actualPermanentAddress: " + actualPermanentAddress);
		if (actualPermanentAddress.contains(expectedPermanentAddress)) {
			System.out.println("Verify permanentAddress ? Passed");
		} else {
			System.out.println("Verify permanentAddress ? Failed");
		}

	}

}
