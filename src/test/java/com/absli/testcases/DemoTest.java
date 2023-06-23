package com.absli.testcases;

import com.absli.Listner.CustomListner;
import com.absli.base.*;
import com.absli.utils.WaitUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.internal.http.URIBuilder;
import util.TestUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.absli.dataproviders.DataProviders;
import com.absli.pageObjects.*;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import util.TestUtil;
import com.absli.utils.WaitUtils;


public class DemoTest extends TestBase {

	 LoginPage loginPage;
		WaitUtils wait;
		
		//public static final String TEST_ENVIRONMENT = "qa-task.backbasecloud.com/register";
		public static WebDriver driver;
		public DemoTest(){
			super();

		}


		@BeforeMethod
		public void setUp() {
				loginPage = new LoginPage(WebDriverFactoryStaticThreadLocal.getDriver());

		}
		
		@Test (groups= {"web"},dataProvider = "", dataProviderClass = DataProviders.class,
				description="")

				public void automationdemo() {
			   System.out.println("login case starting ");
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			   loginPage.enterUserNameweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   loginPage.enterpasswordweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   loginPage.clickOnLoginButtonweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   loginPage.clickOnAddToCartButtonweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   loginPage.clickOn2AddToCartButtonweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
			   loginPage.clickOnRemoveButtonweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   loginPage.clickOnDropdownweb();
			   WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
				}
		

		
}
