/*
 * @autor : Naveen Khunteta
 *
 */
package com.absli.Listner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.absli.utils.PropertiesUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporterNG {

	 static ExtentReports extent;
	static PropertiesUtils prop=new PropertiesUtils();


	public static ExtentReports extentReportGenerator() throws IOException{
		SimpleDateFormat formate=new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date=new Date();
		String actualdate=formate.format(date);
		
		String path=System.getProperty("user.dir")+"\\Report\\ExecutionReport"+".html";
	    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("ABSLI-LEAP Report");
        reporter.config().setDocumentTitle("TestResults");
        reporter.config().setTheme(Theme.DARK);
       

		extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("URL",  prop.getProperties("url"));
        extent.setSystemInfo("Tester", "NIKHIL GUPTA");
        extent.setSystemInfo("ENV", prop.getProperties("Environment"));
        extent.setSystemInfo("Executed on OS", System.getProperty("os.name"));
        extent.setSystemInfo("Executed By User", System.getProperty("user.name"));

        
return extent;
}}