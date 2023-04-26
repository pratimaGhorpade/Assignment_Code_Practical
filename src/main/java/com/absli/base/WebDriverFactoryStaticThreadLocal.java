package com.absli.base;

import Utils.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;

import static com.absli.base.TestBase.prop;

public class WebDriverFactoryStaticThreadLocal {

    protected static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public static AndroidDriver driver1;
    public static IOSDriver driver2;
    public static String parameterName;

    public static void setDriver() throws IOException {
        parameterName = ExcelUtils.getPlatformNameFromExcel(prop.getProperties("testExcelSheet"), "controller");


        if (parameterName.equalsIgnoreCase("web")) {
           WebDriverManager.chromedriver().setup();
           driver.set(new ChromeDriver());
           /*
            String username = "robin.bhogal";
           String accesskey = "4mCmjWp1TfVK2JXfrJeaxKQNr2aF39jxncBJsH3QqBCIL5Yxdi";
            String gridURL = "@hub.lambdatest.com/wd/hub";
            Date dt = new Date();

           DesiredCapabilities capabilities = new DesiredCapabilities();
           capabilities.setCapability("browserName", "chrome");
           capabilities.setCapability("version", "70.0");
            capabilities.setCapability("platform", "Windows 10"); // If this cap isn't specified, it will just get the any available one
           capabilities.setCapability("build", "Automation-Test-Framework"+" "+dt.getDate()+" "+ "Vijay");
         capabilities.setCapability("commandLog", true);
           capabilities.setCapability("console", true);
            capabilities.setCapability("terminal", true);
            capabilities.setCapability("systemLog", true);
          
          
            
           try {

               driver.set(new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities));
                //    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
           } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
           }
*/
        } else if (parameterName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());

        } else if (parameterName.equalsIgnoreCase("Safari")) {

            WebDriverManager.safaridriver().setup();
            driver.set(new SafariDriver());
        }

    }

    public static WebDriver getDriver() {

        return driver.get();
    }


}
