package com.absli.dataproviders;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.absli.utils.PropertiesUtils;

import Utils.ExcelUtils;

public class DataProviders {
	
	//Properties prop = new Properties();
	PropertiesUtils prop = new PropertiesUtils();
	
	@DataProvider(name = "dataSignInProvider")
	public Iterator<Object[]> getSignInTestData(Method method) throws IOException {
		ArrayList<Object[]> testData = new ExcelUtils().getLoginDataFromExcel(prop.getProperties("testExcelSheet"),
				method.getName(), prop.getProperties("loginSheetName"));
		return testData.iterator();
	}


	
}
