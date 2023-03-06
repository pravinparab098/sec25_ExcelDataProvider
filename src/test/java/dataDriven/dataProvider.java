package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	/*
	 * 		with the help of data provider we can send a multiple sets of data to our
	 * test we need to give each set of data as an Array You were actually test
	 * reads that array from data provider and execute the tests.
	 * 
	 * 		Now if you send five sets of data. As five areas from data provider to user
	 * test, then your test will run five times with five separate sets of data,
	 * which are nothing but five different arrays.
	 * 
	 */

	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String designation, String name, String id) {
		System.out.println("Designation : " + designation + ", Name : " + name + ", ID : " + id);
	}

	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {
		// First nedd to tell where is your excel file is located
		FileInputStream file = new FileInputStream("D:\\SeleniumWebDriver\\dataProvider.xlsx");
		// asking permission to read that Excel file
		XSSFWorkbook wb = new XSSFWorkbook(file);
		// read the data from particular sheet
		XSSFSheet sheet = wb.getSheetAt(1); // now this sheet variable have all the information which is stored in the data sheet
		// get the physical numbers of rows presented in the sheet
		int rowCount = sheet.getPhysicalNumberOfRows();
		// counting the number of rows presented in the sheet for calculating the number of columns
		XSSFRow row = sheet.getRow(0);
		// get the physical numbers of column presented in the sheet
		int columnCount = row.getLastCellNum();	
		/*
		 * 		Now. our purpose here is to iterate through each and every row and take the cell value of each and every row and store it into one array like that.
		 * Here creating three Arrays is our requirement
		 * it ultimately look like [Object[][] data = { { "Admin", "Pravin", "43" }, { "Manager", "Prashant", "57" }, { "Customer", "Prakash", "48" } };]
		 */
		//so first we declare the multidimensional array in Object format which contains how many row you need to create with number of column
		//neglecting the heading of row 
	
		Object data[][] = new Object[rowCount - 1][columnCount];
		for (int r=0; r<rowCount - 1; r++)		//loop for number of rows without considering heading of row
		{	
			row = sheet.getRow(r+1);			//go to 2nd row of excel file -- whole data from 2nd row get store into "row" 
			for (int c=0; c<columnCount; c++)	//loop for number of columns 
			{	
				XSSFCell cell = row.getCell(c);	//now form that 2nd row go to each cell and capture the data into "cell" 
				formatter.formatCellValue(cell);
				data[r][c] = formatter.formatCellValue(cell);
			}
		} return data;
	}
}
