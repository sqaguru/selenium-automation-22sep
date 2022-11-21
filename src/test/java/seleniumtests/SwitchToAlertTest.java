package seleniumtests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchToAlertTest {

	public static void main(String[] args) throws InterruptedException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the
												// browser
		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://www.facebook.com/");// navigation

		Thread.sleep(2000);

		driver.findElement(By.linkText("Meta Pay")).click();

		Thread.sleep(2000);

		String defaultWindowId = driver.getWindowHandle();// OS provides a unique window id

		// set collection stores only unique values/element
		Set<String> windowIds = driver.getWindowHandles();// returns all window id's launched by selenium

		for (String windowId : windowIds) {
			if (!windowId.equals(defaultWindowId)) {
				driver.switchTo().window(windowId);
				break;
			}
		}

		String newWindowTitle = driver.getTitle();

		System.out.println("newWindowTitle: " + newWindowTitle);

		driver.close();//closes the current window only

		driver.switchTo().window(defaultWindowId);//switching back to default window

		String defaultWindowTitle = driver.getTitle();

		System.out.println("default window title after switching back to window: " + defaultWindowTitle);
		
		driver.quit();//closes all the windows opened by selenium

	}

}
