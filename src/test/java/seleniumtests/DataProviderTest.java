package seleniumtests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest/* extends BaseTest */ {
	@Test(dataProvider = "test1")
	public void test(String searchKey) {
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.name("q")).sendKeys(searchKey);
		driver.findElement(By.name("q")).submit();

	}

	@DataProvider(name = "test1")
	public Object[]/* [] */ createData1() {
		return new Object[]/* [] */ /* { */
		{ "testng.org",
				"google search by" }/*
									 * , { "selenium" }, { "Java" }, { "manual testing" }, { "software testing" }
									 */ /* } */;
	}

	@Test(dataProvider = "test2")
	public void myTestCase(HashMap<String, String> testData) {
		System.out.println(testData.get("UserName") + testData.get("Password") + testData.get("City"));

	}

	public String getStudentName() {
		return "Santosh";
	}

	@DataProvider(name = "test2")
	public Object[] dpTest2() {
		HashMap<String, String> testData = new HashMap<String, String>();

		testData.put("UserName", "Rama");
		testData.put("Password", "Rama123");
		testData.put("State", "Telangana");
		testData.put("City", "Hyderabad");

		HashMap<String, String> testData2 = new HashMap<String, String>();
		testData2.put("UserName", "Krishna");
		testData2.put("Password", "Krishna123");
		testData2.put("City", "Pune");

		HashMap<String, String> testData3 = new HashMap<String, String>();
		testData3.put("UserName", "Krishna");
		testData3.put("Password", "Krishna123");
		testData3.put("City", "Pune");

		Object[] object = new Object[3];
		object[0] = testData;
		object[1] = testData2;
		object[2] = testData3;
		return object;
	}

}
