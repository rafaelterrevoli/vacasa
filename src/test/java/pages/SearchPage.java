package pages;

import base.BaseAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static utils.Generals.*;

public class SearchPage extends BaseAppium {

    @AndroidFindBy(id  = "com.vacasa.guests:id/SearchEditText")
    private MobileElement searchEditText;

    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);}

    public boolean verificarSearch(){
        if (!waitElementoVisible(searchEditText,15)) return false;
        return true;
    }

    public void ingresaLugar() {
        searchEditText.sendKeys("Orlando");
        int i = 1;
        do {((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            i++;
        } while (i <= 2);
    }

}
