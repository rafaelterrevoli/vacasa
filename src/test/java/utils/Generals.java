package utils;

import base.BaseAppium;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Generals extends BaseAppium {

    private static final Logger log = Logger.getLogger(Generals.class);

    public void identifyAndClickElement(MobileElement element, String identifier) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByAccessibilityId(identifier);
        element.click();
    }

    public void xPathAndClickElement(MobileElement element, String xPath) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByXPath(xPath);
        element.click();
    }

    public void identifyElement(MobileElement element, String identifier) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByAccessibilityId(identifier);
    }

    public void xPathElement(MobileElement element, String xpath) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByXPath(xpath);
    }


    public void validateText(MobileElement element, String text) {
        Assert.assertEquals(text, element.getText());
    }

    public void identifyAndValidateText(MobileElement element, String identifier, String text) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByAccessibilityId(identifier);
        Assert.assertEquals(text, element.getText());
    }

    public void xPathAndValidateText(MobileElement element, String xPath, String text) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByXPath(xPath);
        Assert.assertEquals(text, element.getText());
    }

    public void identifyAndSendKeys(MobileElement element, String identifier, String sendKeys) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        element = driver.findElementByAccessibilityId(identifier);
        element.sendKeys(sendKeys);

    }


    //------------------------------------------------------------------------------------------//

    public static void quitarTeclado() {
        driver.hideKeyboard();

    }

    public static void typeText(MobileElement element, String valor){
        element.sendKeys(valor);
    }

    public static void clickElement(MobileElement element) {
        element.click();
    }

    public static String dameTexto(MobileElement element){
        return element.getText();
    }

    public static boolean waitElementoVisible(MobileElement mobElement, int timeout) {
        Boolean isElementPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOf(mobElement));
            isElementPresent = mobElement.isDisplayed();
            return isElementPresent ;
        }catch (TimeoutException e) {
            log.error("No esta visible o no existe el elemento: " + mobElement);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean waitClickable(MobileElement mobElement, int timeout) {
        Boolean isElementClicleable = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.elementToBeClickable(mobElement));
            isElementClicleable = mobElement.isDisplayed();
            return isElementClicleable ;
        }catch (TimeoutException e) {
            log.error("No elemento no clicleable: " + mobElement);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void waitSeconds(int segundos){
        synchronized(driver){
            try {
                driver.wait(segundos * 1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
    }

    public static void accionAtras(String cantidad){
        int cantidadAtras = Integer.parseInt(cantidad);
        for (int  i = 1; i <= cantidadAtras; i++){
            driver.navigate().back();
            waitSeconds(5);
        }
    }



    public static void clickPorCoordenadas(int puntoX,int puntoY) {
        waitSeconds(2);
        PointOption coordenada = PointOption.point(puntoX,puntoY);
        new TouchAction((MobileDriver)driver).press(coordenada).release().perform();
    }
    //------------------------------------------------------------------------------------------//
}
