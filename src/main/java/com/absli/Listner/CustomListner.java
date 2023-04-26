package com.absli.Listner;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.absli.base.Base;
import com.absli.base.ExtentFactory;
import com.absli.base.WebDriverFactoryStaticThreadLocal;



public class CustomListner extends Base implements ITestListener{

	static ExtentReports report;
	  public static ExtentTest test;
	

	
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		ExtentFactory.getInstance().setExtent(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case Successfully Passed");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//WebDriver driver = null;
		ExtentFactory.getInstance().getExtent().fail(result.getThrowable());
//		 Object testObject= result.getInstance();
//		Class cls= result.getTestClass().getRealClass();
//		try {
//		//driver=	(WebDriver)cls.getDeclaredField("WebDriverFactoryStaticThreadLocal.getDriver()").get(testObject);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		System.out.println("FAILED test");
		System.out.println("**************************************");
		System.out.println("******* TEST FAIL: "+result.getMethod().getMethodName()+" - "+result.getMethod().getDescription());
		System.out.println("**************************************");

		try {
			//String screenshotPath = failedWeb(result.getMethod().getMethodName());
			//result.getMethod().getDescription();
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(FailedWeb(result.getMethod().getMethodName(),WebDriverFactoryStaticThreadLocal.getDriver()),result.getMethod().getMethodName());
			ExtentFactory.getInstance().removeExtentObject();


		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			//ExtentFactory.getInstance().removeExtentObject();
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, result.getMethod().getMethodName()+"Test Case Skipped");
		ExtentFactory.getInstance().removeExtentObject();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		try {
			report = ExtentReporterNG.extentReportGenerator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		//ExtentFactory.getInstance().removeExtentObject();
		//report.e
		//report.flush();

	}





	/*public static ExtentReports extent;
	public static ExtentTest test;
	private static ThreadLocal <ExtentTest>extenttest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Extent.html",false);
		extent.addSystemInfo("Host Name", "XE-GGN-IT-04731");
		extent.addSystemInfo("User Name", "NIKHIL.GUPTA");
		extent.addSystemInfo("Environment", "QA");
		test = extent.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		extenttest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}
	public static String parameterName;
	static PropertiesUtils prop;
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("FAILED test");
		System.out.println("**************************************");
		System.out.println("******* TEST FAIL: "+result.getMethod().getMethodName()+" - "+result.getMethod().getDescription());
		System.out.println("**************************************");

		try {
				String screenshotPath = failedWeb(result.getMethod().getMethodName());
				result.getMethod().getDescription();
			extenttest.get().log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("FAILED test");
		System.out.println("**************************************");
		System.out.println("******* TEST FAIL: "+result.getMethod().getMethodName()+" - "+result.getMethod().getDescription());
		System.out.println("**************************************");


	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub


	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.endTest(test);
		extent.flush();
		extent.close();


	}*/



}
