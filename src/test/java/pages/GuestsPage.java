package pages;

import base.BaseAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static utils.Generals.waitElementoVisible;

public class GuestsPage extends BaseAppium {

    @AndroidFindBy(id  = "com.vacasa.guests:id/AdultsPlusButton")
    private MobileElement adultsPlusBtn;

    @AndroidFindBy(id  = "com.vacasa.guests:id/Title")
    private MobileElement titleAdultsGuests;

    @AndroidFindBy(id  = "com.vacasa.guests:id/AdultsFilterLabel")
    private MobileElement adultsaLbel;

    @AndroidFindBy(id  = "com.vacasa.guests:id/SaveButton")
    private MobileElement adultsSaveBtn;




    public GuestsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);}

    public boolean verificarGuests(){
        if (!waitElementoVisible(titleAdultsGuests,10)) return false;
        if (!waitElementoVisible(adultsaLbel,10)) return false;
        if (!waitElementoVisible(adultsPlusBtn,10)) return false;
        return true;
    }

    public void hacerClickAdultsPlusBtn(){
        adultsPlusBtn.click();
    }

    public void hacerClickSave(){
        adultsSaveBtn.click();
    }


}
