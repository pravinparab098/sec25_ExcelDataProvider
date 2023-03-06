package dataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvideFromExcel {

	/*
	 * with the help of data provider we can send a multiple sets of data to our
	 * test we need to give each set of data as an Array You were actually test
	 * reads that array from data provider and execute the tests.
	 * 
	 * Now if you send five sets of data. As five areas from data provider to user
	 * test, then your test will run five times with five separate sets of data,
	 * which are nothing but five different arrays.
	 * 
	 */

	@Test(dataProvider = "driveTest")
	public void testCaseData(String designation, String name, String id) {
		System.out.println("Designation : "+designation + ", Name : "+ name + ", ID : "+ id);
	}

	@DataProvider(name = "driveTest")
	public Object[][] getData() {
		Object[][] data = { { "Admin", "Pravin", "43" }, { "Manager", "Prashant", "57" }, { "Customer", "Prakash", "48" } };
		return data;
	}
}
