package base;

import com.vimalselvam.cucumber.listener.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseAppium {


    protected static AppiumDriver<MobileElement> driver;
    String destDir;
    DateFormat dateFormat;

    public void init() throws MalformedURLException {
        // Generación de las capabilites a nivel del servicio de Appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        // Generación de las capabilites a nivel de driver
        DesiredCapabilities clientCapabilities = new DesiredCapabilities();
        URL url_appium = new URL("http://127.0.0.1:4723/wd/hub");
        clientCapabilities.setCapability("platformName", "Android");
        clientCapabilities.setCapability("platformVersion", "12");
        clientCapabilities.setCapability("deviceName", "Pixel_3a_API_31_arm64-v8a");
        clientCapabilities.setCapability("udid", "emulator-5554");
        clientCapabilities.setCapability("appPackage", "com.vacasa.guests");
        clientCapabilities.setCapability("appActivity", "com.vacasa.app.MainActivity");
        clientCapabilities.setCapability("autoWebView", "true");
        clientCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        driver = new AndroidDriver<MobileElement>(url_appium, clientCapabilities);
        driver.getScreenshotAs(OutputType.FILE);
    }

    public void takeScreenShot() {
        // Set folder name to store screenshots.
        destDir = "target/cucumber-report/null";
        // Capture screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Set date format to set It as screenshot file name.
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // Create folder under project with name "screenshots" provided to destDir.
        new File(destDir).mkdirs();
        // Set file name using current date time.
        String destFile = dateFormat.format(new Date()) + ".png";
        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
            Reporter.addScreenCaptureFromPath(System.getProperty(destDir)+ "/"+destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() throws IOException {
        if (driver != null) {
            driver.quit();
        }
        driver.quit();
    }
}