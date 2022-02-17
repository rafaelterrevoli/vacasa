package containers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Prueba {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        init();
    }

    public static void init() throws MalformedURLException, InterruptedException {

        AppiumDriver<MobileElement> driver;
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);

       driver.findElementByXPath("//*[@class='android.widget.Button' and @text='Don’t allow']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@class='android.widget.TextView' and @text='Dates']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='Go back']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@class='android.widget.TextView' and @text='Guests']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='Go back']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@class='android.widget.TextView' and @text='Filters']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='Go back']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@class='android.widget.TextView' and @text='I want to go to…']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@class='android.widget.TextView' and @text='I want to go to…']").sendKeys("Florida");
        Thread.sleep(2000);
    }

}

