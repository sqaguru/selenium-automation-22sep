package seleniumtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownElementTest {

	public static void main(String[] args) throws InterruptedException {

		// setting the configuration for chrome driver browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\webdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// RBI rBI=new ICICI();// creating object of chrome browser, launches the
												// browser
		Thread.sleep(2000);// milli-seconds, 2 Seconds

		driver.get("https://demoqa.com/select-menu");// navigation to google page

		Thread.sleep(2000);

		/*
		 * Select selectColor = new Select(driver.findElement(By.id("oldSelectMenu")));
		 * 
		 * selectColor.selectByVisibleText("Red");
		 * 
		 * Thread.sleep(1000);
		 * 
		 * selectColor.selectByValue("red");
		 * 
		 * Thread.sleep(1000);
		 * 
		 * selectColor.selectByIndex(0);
		 * 
		 * Thread.sleep(1000);
		 * 
		 * Select selectCars = new Select(driver.findElement(By.name("cars")));
		 * 
		 * boolean hasMultiple = selectCars.isMultiple();
		 * 
		 * System.out.println("car hasMultiple: " + hasMultiple);
		 * 
		 * selectCars.selectByVisibleText("Volvo"); Thread.sleep(1000);
		 * 
		 * if (hasMultiple) selectCars.selectByVisibleText("Audi");
		 * 
		 * Thread.sleep(1000);
		 * 
		 * List<WebElement> carOptions = selectCars.getOptions();
		 * 
		 * List<String> stringCount;
		 * 
		 * System.out.println("total car options: " + carOptions.size());
		 * 
		 * for (WebElement carOption : carOptions) { System.out.println("car option: " +
		 * carOption.getText()); }
		 * 
		 * for (int carCounter = 0; carCounter < carOptions.size(); carCounter++) {
		 * System.out.println("car option: " + carOptions.get(carCounter).getText()); }
		 */

		driver.findElement(By.xpath("//*[@id='selectMenuContainer']/div[7]/div/div")).click();

		Thread.sleep(1000);

		int totalBlueColoredElements = driver.findElements(By.xpath("//*[.='Blue']")).size();

		System.out.println("totalBlueColoredElements: " + totalBlueColoredElements);

		List<WebElement> blueColorOptions = driver.findElements(By.xpath("//*[.='Blue']"));

		blueColorOptions.get(1).click();

		Thread.sleep(1000);

	}

}
