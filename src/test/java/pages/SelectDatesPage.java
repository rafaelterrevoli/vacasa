package pages;

import base.BaseAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static utils.Generals.waitElementoVisible;

public class SelectDatesPage extends BaseAppium {

    @AndroidFindBy(id  = "com.vacasa.guests:id/CalendarTitle")
    private MobileElement CalendarTitleLabel;

    @AndroidFindBy(xpath  = "//android.widget.FrameLayout[29]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement fechaInical;

    @AndroidFindBy(xpath  = "//android.widget.FrameLayout[32]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement fechaFinal;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Go back']")
    private MobileElement back;

    @AndroidFindBy(id = "com.vacasa.guests:id/SaveButton")
    private MobileElement selectDatesBtn;


    public SelectDatesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);}


    public boolean verificarSelectDates(){
        if (!waitElementoVisible(CalendarTitleLabel,15)) return false;
        if (!waitElementoVisible(back,15)) return false;
        return true;
    }

    public void clickIn() {fechaInical.click(); }

    public void clickOut() {fechaFinal.click(); }

    public void clickSelect() {selectDatesBtn.click(); }

}
