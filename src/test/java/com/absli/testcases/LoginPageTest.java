//package com.absli.testcases;
//
//import com.absli.Listner.CustomListner;
//import com.absli.base.*;
//import com.absli.utils.WaitUtils;
//import com.aventstack.extentreports.Status;
//import io.appium.java_client.android.AndroidDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.restassured.internal.http.URIBuilder;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.context.annotation.Description;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.absli.dataproviders.DataProviders;
//import com.absli.pageObjects.*;
//
//
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URISyntaxException;
//import java.util.concurrent.TimeUnit;
//
//
//
//
//public class LoginPageTest  {
//	 LoginPage loginPage;
//	WaitUtils wait;
//	
//	public static final String TEST_ENVIRONMENT = "qa-task.backbasecloud.com/register";
//	public static WebDriver driver;
//	public LoginPageTest(){
//		super();
//
//	}
//
//
//	@BeforeMethod
//	public void setUp() {
//			loginPage = new LoginPage(WebDriverFactoryStaticThreadLocal.getDriver());
//
//	}
//	
//	@Test (groups= {"web"},dataProvider = "dataSignInProvider", dataProviderClass = DataProviders.class,
//			description="Click on Sign in Button"
//					+ "Enter Email"
//					+ "Enter Password"
//					+ "Click on Sign submit Button")
//
//			public void demo(String userName, String passWord,String ErrorMSG,String ErrorMSGPassword) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//
//			WebElement btn=driver.findElement(By.xpath("//a[text()=' Sign in ']"));
//			btn.click();
//			System.out.println("Click on Sign in Button");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Sign in Button");
//
//			WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
//			email.sendKeys("pratima.ghorpade123@gmail.com");
//			System.out.println("Entered Email");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Enter Emai id");
//
//			WebElement PassNM=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//			PassNM.sendKeys("Swami@123");
//			System.out.println("Entered Password");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Enter password");
//
//			WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
//			submit.click();
//			System.out.println("Click on submit Button");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Submit Button");
//
//			driver.close();
//			
//			}
//	
//	@Test (groups= {"web"},dataProvider = "dataSignInProvider", dataProviderClass = DataProviders.class,
//			description="Click on Home Button")
//
//			public void demo1(String userName, String passWord,String ErrorMSG,String ErrorMSGPassword) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//
//			WebElement homebtn=driver.findElement(By.xpath("//a[text()=' Home ']"));
//			homebtn.click();
//			System.out.println("Click on Home Button");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Home Button");
//			
//			driver.close();
//			
//			}
//	
//	@Test (groups= {"web"},dataProvider = "dataSignInProvider", dataProviderClass = DataProviders.class,
//			description="Click on Global Feed Tab")
//
//			public void demo2(String userName, String passWord,String ErrorMSG,String ErrorMSGPassword) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//
//			WebElement homebtn=driver.findElement(By.xpath("//a[text()=' Home ']"));
//			homebtn.click();
//			System.out.println("Click on Home Button");
//			//ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Home Button");
//			
//			WebElement yourFeedTab=driver.findElement(By.xpath("//a[text()=' Your Feed ']"));
//			yourFeedTab.click();
//			System.out.println("Click on Your Feed Tab");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Your Feed Tab");
//			
//			WebElement globalFeedTab=driver.findElement(By.xpath("//a[text()=' Global Feed ']"));
//			globalFeedTab.click();
//			System.out.println("Click on Global Feed Tab");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Globle Feed Tab");
//
//			driver.close();
//			
//			}
//	
//	@Test (groups= {"web"},dataProvider = "dataSignInProvider", dataProviderClass = DataProviders.class,
//			description="Click on Matrix Tag Option from popular tag list")
//
//			public void demo3(String userName, String passWord,String ErrorMSG,String ErrorMSGPassword) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//
//			WebElement matrixTagOption=driver.findElement(By.xpath("//a[text()=' matrix ']"));
//			matrixTagOption.click();
//			System.out.println("Click on Matrix Tag Option");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Matrix Tag Option");
//			
//			driver.close();
//			
//			}
//	
//	@Test (groups= {"web"},dataProvider = "dataSignInProvider", dataProviderClass = DataProviders.class,
//			description="Click on Bus Tag Option from popular tag list")
//
//			public void demo4(String userName, String passWord,String ErrorMSG,String ErrorMSGPassword) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//			
//			WebElement busTagOption=driver.findElement(By.xpath("//a[text()=' bus ']"));
//			busTagOption.click();
//			System.out.println("Click on Bus Tag Option");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Bus tag option");
//			
//			driver.close();
//			
//			}
//
//
//	@Test (groups= {"web"},dataProvider = "dataSignInProvider", dataProviderClass = DataProviders.class,
//			description="Click on Sign in Button"
//					+ "Enter Email"
//					+ "Enter Password"
//					+ "Click on Sign submit Button"
//					+ "Error Msg was displayed")
//
//			public void demo5(String userName, String passWord,String ErrorMSG,String ErrorMSGPassword) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//
//			WebElement btn=driver.findElement(By.xpath("//a[text()=' Sign in ']"));
//			btn.click();
//			System.out.println("Click on Sign in Button");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Click on Sign in Button");
//
//			WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
//			email.sendKeys("pratima.ghorpade123@gmail.com");
//			System.out.println("Entered Email");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO,"Enter Email"+" "+"pratima.ghorpade123@gmail.com");
//
//			WebElement PassNM=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//			PassNM.sendKeys("Swami@123");
//			System.out.println("Entered Password");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO, "Enter Password TextBox=====>"+"Swami@123");
//
//			WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
//			submit.click();
//			System.out.println("Click on Sign submit Button");
//			ExtentFactory.getInstance().getExtent().log(Status.INFO, "Click on Sign submit Button");
//
//			WebElement errorMsg=driver.findElement(By.xpath("//li[text()=' email or password is invalid ']"));
//			errorMsg.click();
//			System.out.println("Error Msg was displayed");
//			
//			
//			driver.close();
//			
//			}
//	
//
//	}
//
//
//
//
//
//
