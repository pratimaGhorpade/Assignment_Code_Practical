package Utils;

import java.util.ArrayList;

public class ExcelUtils {


	public ArrayList<Object[]> getLoginDataFromExcel(String testExcelSheet, String testName, String loginSheetName) {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		ArrayList<String> myColumnData = new ArrayList<String>();
		Xls_reader reader = null;

		try {
			reader = new Xls_reader(System.getProperty("user.dir") + testExcelSheet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Sign in Sheet row count ---------" + reader.getRowCount(loginSheetName));
		System.out.println(" ******* current test running method  *********" + testName);
		System.out.println("**** column count  ********" + reader.getColumnCount(loginSheetName));

		for (int rowCount = 3; rowCount <= reader.getRowCount(loginSheetName); rowCount++) {
			String currentTestMethod = reader.getCellData(loginSheetName, "testCaseName", rowCount);
			String enableFlag = reader.getCellData(loginSheetName, "flag", rowCount);
			if (currentTestMethod.equalsIgnoreCase(testName)) {
				String username = reader.getCellData(loginSheetName, "username", rowCount);
				String password = reader.getCellData(loginSheetName, "password", rowCount);
				String ErrorMSG = reader.getCellData(loginSheetName, "ErrorMSG", rowCount);
				String ErrorMSGPassword = reader.getCellData(loginSheetName, "ErrorMSGPassword", rowCount);

				Object ob[] = {username.trim(), password.trim(), ErrorMSG.trim(), ErrorMSGPassword.trim()};
				myData.add(ob);
			}
		}
		System.out.println("mydata rows value **********" + myData);
		return myData;
	}


	public static String getURLEnvironment(String testExcelSheet, String sheetName) {

		String environment = null;
		Xls_reader reader = null;
		try {
			reader = new Xls_reader(System.getProperty("user.dir") + testExcelSheet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowCount = 2; rowCount <= reader.getRowCount(sheetName); rowCount++) {
			String enableFlag = reader.getCellData(sheetName, "execute", rowCount);
			if (enableFlag.equalsIgnoreCase("YES")) {
				environment = reader.getCellData(sheetName,"Environment", rowCount);
				break;
			}
		}
		return environment;
	}


	public static String getPlatformNameFromExcel(String testExcelSheet, String sheetName) {
		String platform = null;
		Xls_reader reader = null;
		try {
			reader = new Xls_reader(System.getProperty("user.dir") + testExcelSheet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowCount = 2; rowCount <= reader.getRowCount(sheetName); rowCount++) {
			String enableFlag = reader.getCellData(sheetName, "execute", rowCount);
			if (enableFlag.equalsIgnoreCase("YES")) {
				platform = reader.getCellData(sheetName, "platform", rowCount);
				break;
			}
		}
		return platform;
	}
	

}
