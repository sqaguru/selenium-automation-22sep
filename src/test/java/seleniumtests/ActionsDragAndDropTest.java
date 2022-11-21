package seleniumtests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDragAndDropTest {

	public static void main(String[] args) throws InterruptedException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// browser
		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://demoqa.com/droppable");// navigation

		Thread.sleep(2000);

		WebElement weDraggable = driver.findElement(By.id("draggable"));

		WebElement weDroppable = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);

		action.dragAndDrop(weDraggable, weDroppable);

		action.build().perform();

	}

}
