package com.absli.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.absli.utils.PropertiesUtils;
import util.WebEventListener;

public class TestBase extends WebDriverFactoryStaticThreadLocal {
    static AppiumDriverLocalService service;
    public static WebDriver driver;

    //public static Properties prop;
    public static String parameterName;
    static PropertiesUtils prop;
    public  ExtentReports extent;

    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new PropertiesUtils();
            prop.getProperties("testExcelSheet");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
    @BeforeTest
    public void setExtent() {

        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/index.html");

        reporter.config().setReportName("ABSLI-LEAP Report");
        reporter.config().setDocumentTitle("TestResults");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA", "SHUBHAM MISHRA");

    }
*/

    public static void initialization() throws IOException, InterruptedException {

        WebDriverFactoryStaticThreadLocal.setDriver();
        eventListener = new WebEventListener();
        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + WebDriverFactoryStaticThreadLocal.getDriver());
        WebDriverFactoryStaticThreadLocal.getDriver().get(prop.getProperties("url"));
        Thread.sleep(1500);
        System.out.println("Title printed by Thread " + Thread.currentThread().getId() + " - " + WebDriverFactoryStaticThreadLocal.getDriver().getTitle() + " on driver reference " + WebDriverFactoryStaticThreadLocal.getDriver());
        WebDriverFactoryStaticThreadLocal.getDriver().manage().deleteAllCookies();
        WebDriverFactoryStaticThreadLocal.getDriver().manage().window().maximize();
        Thread.sleep(3000);

    }


    @BeforeClass
    public void preSetup() throws IOException, InterruptedException {
        initialization();
    }


    @AfterMethod(alwaysRun=true)
    public void endReport(ITestResult result) throws InterruptedException {
        Thread.sleep(2000);
       // extent.flush();
        ExtentFactory.getInstance().removeExtentObject();
        Thread.sleep(2000);

/*

        try
        {
            if(result.getStatus()== ITestResult.FAILURE)
            {
                String res = captureScreenshot(Driver, result.getName());
                String image= logger.addScreenCapture(res);
                System.out.println(image);
                String TestCaseName = this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed";
                logger.log(LogStatus.FAIL, TestCaseName  + logger.addScreenCapture(res));
                //  logger.log(LogStatus.FAIL, image, this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed");
            }
            else if(result.getStatus()==ITestResult.SUCCESS)
            {
                logger.log(LogStatus.PASS, this.getClass().getSimpleName() + " Test Case Success and Title Verified");
            }
            else if(result.getStatus()==ITestResult.SKIP)
            {
                logger.log(LogStatus.SKIP, this.getClass().getSimpleName() + " Test Case Skipped");
            }
            report.endTest(logger);
            report.flush();

        }
        catch(Throwable t)
        {
            logger.log(LogStatus.ERROR,t.fillInStackTrace());
        }
*/

    }


    @AfterTest
    public void tearDown() {
            WebDriverFactoryStaticThreadLocal.getDriver().quit();
        }

    }







