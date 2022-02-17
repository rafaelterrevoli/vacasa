package pages;

import base.BaseAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static utils.Generals.*;


public class HomePage extends BaseAppium {

    @AndroidFindBy(id  = "com.vacasa.guests:id/DateFilter")
    private MobileElement datesBtn;

    @AndroidFindBy(id  = "com.vacasa.guests:id/SearchImage")
    private MobileElement search;

    @AndroidFindBy(id  = "com.vacasa.guests:id/SearchResultsLabel")
    private MobileElement resultSearch;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Guests']" )
    private MobileElement guestsBtn;

    @AndroidFindBy(xpath  = "//*[@class='android.widget.TextView' and @text='Filters']")
    private MobileElement filtersBtn;

    @AndroidFindBy(xpath  = "//*[@class='android.widget.TextView' and @text='I want to go to…']")
    private MobileElement goToBtn;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Don’t allow']")
    private MobileElement dontAllowBtn;


    public HomePage() {PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);}

    public boolean verificarAppDisponible(){
        if (!waitElementoVisible(dontAllowBtn,10)) return false;
        return true;
    }

    public boolean verificarBusquedaHome(){
        if (!waitElementoVisible(datesBtn,15)) return false;
        if (!waitElementoVisible(guestsBtn,15)) return false;
        if (!waitElementoVisible(filtersBtn,15)) return false;
        if (!waitElementoVisible(goToBtn,15)) return false;
        return true;
    }


    public void clickDontAllowBtn() {dontAllowBtn.click(); }

    public void clickDatesBtn() {datesBtn.click(); }

    public void clickGuestsBtn() {guestsBtn.click(); }

    public void clickFiltersBtn() {filtersBtn.click(); }

    public void clickGoToBtn() {goToBtn.click(); }

    public void clickSearch() {search.click(); }

    public boolean verificarResult(){
        if (!waitElementoVisible(resultSearch,15)) return false;
        waitSeconds(2);
        return true;
    }

}
