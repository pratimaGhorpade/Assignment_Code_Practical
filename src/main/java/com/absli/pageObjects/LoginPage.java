package com.absli.pageObjects;


import com.absli.Listner.CustomListner;
import com.absli.base.*;

import com.absli.utils.WaitUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.absli.base.WebDriverFactoryStaticThreadLocal.driver2;
import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class LoginPage extends TestBase {
	public WebDriver driver;
	public AndroidDriver driver1;
	public WaitUtils wait;


	// Initializing the Page Objects:
	public LoginPage(AndroidDriver driver1) {
		this.driver1 = driver1;
		wait=new WaitUtils();
	}
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtils();

	}


	
	
	
	public void enterUserNameweb() {
		WebElement UserName=driver.findElement(By.xpath("//input[@name='user-name']"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), UserName, 50,"time out to find element on page");
		UserName.sendKeys("standard_user");
		//ExtentFactory.getInstance().getExtent().log(Status.INFO,"Enter user name"+"standard_user");
	}
	
	public void enterEmailweb() {
		WebElement email=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//input[@placeholder='Email']"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), email, 50,"time out to find element on page");
		email.sendKeys("pratima.ghorpade123@gmail.com");
		//ExtentFactory.getInstance().getExtent().log(Status.INFO,"Enter Email"+"pratima.ghorpade123@gmail.com");
	}

	public void enterpasswordweb() {
		WebElement PassNM=driver.findElement(By.xpath("//input[@name='password']"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), PassNM, 50,"time out to find element on page");
		PassNM.sendKeys("secret_sauce");
		//ExtentFactory.getInstance().getExtent().log(Status.INFO, "Enter Password TextBox=====>"+"secret_sauce");

	}

	
//	public void enterpasswordWeb() {
//		WebElement PassNM=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//input[@placeholder='Password']"));
//		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), PassNM, 30,"time out to find element on page");
//		PassNM.sendKeys("Swami@123");
//		ExtentFactory.getInstance().getExtent().log(Status.INFO, "Enter Password TextBox=====>"+"Swami@123");
//
//	}
	public void submitButtonweb() {
		WebElement submit=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//button[@type='submit']"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), submit, 30,"time out to find element on page");
		submit.click();
		//ExtentFactory.getInstance().getExtent().log(Status.INFO, "click on Submit Button");

	}

	public void clickOnLoginButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//input[@name='login-button']"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
		//ExtentFactory.getInstance().getExtent().log(Status.INFO, "click on Login Button");

	}
	
	public void clickOnAddToCartButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Add to cart'])[1]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		
		btn.click();
		
	}
	
	public void clickOn2AddToCartButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Add to cart'])[2]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn3AddToCartButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Add to cart'])[3]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn4AddToCartButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Add to cart'])[4]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn5AddToCartButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Add to cart'])[5]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	public void clickOn6AddToCartButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Add to cart'])[6]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOnRemoveButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Remove'])[1]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOnDropdownweb() {
		WebElement dropdown=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), dropdown, 30,"time out to find element on page");
		dropdown.click();
	
	}
	
	public void clickOn2RemoveButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Remove'])[2]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn3RemoveButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Remove'])[3]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn4RemoveButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Remove'])[4]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn5RemoveButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Remove'])[5]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void clickOn6RemoveButtonweb() {
		WebElement btn=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//button[text()='Remove'])[6]"));
		wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), btn, 30,"time out to find element on page");
		btn.click();
	
	}
	
	public void VerifyPageTitleweb() {
		try {
			WebElement dashboardtext=WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//span[text()='Application List']"));
			wait.waitForElementToBeVisibleweb(WebDriverFactoryStaticThreadLocal.getDriver(), dashboardtext, 30,"time out to find element on page");
			String GetValue=dashboardtext.getText();
			if(GetValue.equalsIgnoreCase("Application List")) {
				ExtentFactory.getInstance().getExtent().log(Status.INFO, "Successfully verified DashBoard Title");
			}else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Failed to verified DashBoard Title");
			}
		}catch(NoSuchElementException e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Element is Not Display On Page");
		}

		
		
	}


	//public static final String TEST_ENVIRONMENT = "qa-task.backbasecloud.com/register";
	//public WebDriver driver;

	public void login(String uname, String pwd){
	  String URL = "http://" + uname + ":" + pwd + "@" + "qa-task.backbasecloud.com/register";
	  driver.get(URL);
	}



}
