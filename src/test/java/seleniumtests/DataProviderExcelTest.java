package seleniumtests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcelTest/* extends BaseTest */ {

	@Test(dataProvider = "excelData")
	public void myTestCase(HashMap<String, String> testData) {
		System.out.println(testData.get("FirstName") + " " + testData.get("LastName") + " " + testData.get("Address")
				+ "" + testData.get("Email"));

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

	@DataProvider(name = "excelData")
	public Object[] getDataxFromExcel() throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
				"D:\\sqa-guru\\batch-7am-8am-14-sep-2022\\automation-testing-sep20227pm-ws\\sqaguru-automation\\resources\\testdata\\TestData.xls"));
		HSSFSheet sheet = workbook.getSheet("testdata");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("rowCount: " + rowCount);
		System.out.println("columnCount: " + columnCount);
		Object[] object = new Object[rowCount - 1];
		for (int rowCounter = 1; rowCounter < rowCount; rowCounter++) {
			HashMap<String, String> testData = new HashMap<String, String>();
			HSSFRow rowHeader = sheet.getRow(0);
			HSSFRow row = sheet.getRow(rowCounter);
			for (int columnCounter = 0; columnCounter < columnCount; columnCounter++) {
				HSSFCell cellHeader = rowHeader.getCell(columnCounter);
				String header = cellHeader.getStringCellValue();
				HSSFCell cell = row.getCell(columnCounter);
				String data = cell.getStringCellValue();
				System.out.println("data: " + data);
				testData.put(header, data);
			}
			object[rowCounter - 1] = testData;
		}
		return object;
	}

}
