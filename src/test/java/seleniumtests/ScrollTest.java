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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the
									// browser
		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://demoqa.com/select-menu");// navigation to google page

		WebElement interactionElement = driver.findElement(By.xpath("//div[text()='Interactions']"));

		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);

		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", interactionElement);

		System.out.println("element scrolling done successfully");

	}

}
