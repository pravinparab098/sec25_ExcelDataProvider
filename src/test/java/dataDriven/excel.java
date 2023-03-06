package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excel {

	@Test
	public void getExcel() throws IOException {
		FileInputStream file = new FileInputStream("D:\\SeleniumWebDriver\\dataProvider.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(1); // now this sheet variable have all the information which is stored in the
											// data sheet

		int rowCount = sheet.getPhysicalNumberOfRows();

		XSSFRow row = sheet.getRow(0);

		int columnCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount - 1][columnCount];
		for (int r = 0; r < rowCount - 1; r++) // loop for number of rows without considering heading of row
		{
			row = sheet.getRow(r + 1); // go to 2nd row of excel file -- whole data from 2nd row get store into "row"
			for (int c = 0; c < columnCount; c++) // loop for number of columns
			{
				System.out.println(row.getCell(c));
			}
		}

	}
}
