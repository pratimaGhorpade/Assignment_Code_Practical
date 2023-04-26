package com.absli.utils;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.absli.Listner.CustomListner;
import com.absli.base.ExtentFactory;

import java.util.NoSuchElementException;

public class WaitUtils {


    public void waitforElementToBeClickable(WebDriver driver, WebElement element, int timeout){

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public void waitForElementToBeClickableAndroid(AndroidDriver driver1, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver1, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void VerifyloadingWait(WebDriver driver) {
        try {
      	  WebElement Loading=driver.findElement(By.xpath("//span[@class='loading']"));
      	  WebDriverWait wait = new WebDriverWait(driver, 5000L);
            wait.until(ExpectedConditions.invisibilityOf(Loading)); // wait for loader to disappear
        }catch(NoSuchElementException e){
      	  System.out.println("Loading Element is not display");
        }
      	
      	
      }

   
    public static void WaitTime2() throws InterruptedException {
          Thread.sleep(2000);
      	
      }
    public static void WaitTime5() throws InterruptedException {
        Thread.sleep(5000);
    	
    }


    public void waitForElementToBeVisibleAndroid(AndroidDriver driver1, WebElement element, int timeOut, String message) {
        WebDriverWait wait = new WebDriverWait(driver1, timeOut);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            System.out.println(message);
        } catch (TimeoutException e) {
            System.out.println(message);
        }
    }

    public void waitForElementToBeVisibleweb(WebDriver driver, WebElement element, int timeOut, String message) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            System.out.println(message);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, message);
        } catch (TimeoutException e) {
            System.out.println(message);
        }
    }


//-===============shubham=================//

    public void sleep(int args ) throws InterruptedException {

        Thread.sleep(args);
    }

    public static void loadingWait(WebDriver driver, WebElement loader) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
    }


    public void waitForElementToBeVisibleIos(IOSDriver driver2, WebElement element, int timeOut, String message) {
        WebDriverWait wait = new WebDriverWait(driver2, timeOut);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            System.out.println(message);
        } catch (TimeoutException e) {
            System.out.println(message);
        }
    }

    public void waitForElementToBeVisibleIOS(IOSDriver driver2, WebElement element, int timeOut, String message) {
        WebDriverWait wait = new WebDriverWait(driver2, timeOut);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println(message);
        } catch (TimeoutException e) {
            System.out.println(message);
        }
    }
    
    public void scrollTillEndOfPageWeb(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
    
    
    }

}
