package pages;

import base.BaseAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static utils.Generals.waitElementoVisible;

public class FiltersPage extends BaseAppium {

    @AndroidFindBy(id  = "com.vacasa.guests:id/MinimumBedroomsPlusButton")
    private MobileElement bedroomsPlusBtn;

    @AndroidFindBy(id  = "com.vacasa.guests:id/RoomsSectionFilterTitle")
    private MobileElement roomLabel;

    @AndroidFindBy(id  = "com.vacasa.guests:id/SaveButton")
    private MobileElement filtersSaveBtn;


    public FiltersPage() {
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);}

    public boolean verificarFiltersPage(){
        if (!waitElementoVisible(roomLabel,10)) return false;
        if (!waitElementoVisible(bedroomsPlusBtn,10)) return false;
        if (!waitElementoVisible(filtersSaveBtn,10)) return false;
        return true;
    }

    public void hacerClickBedroomPlusBtn(){
        bedroomsPlusBtn.click();
    }

    public void hacerClickSave(){
        filtersSaveBtn.click();
    }
}
