package steps;

import cucumber.api.java.en.And;
import pages.SelectDatesPage;

import static org.junit.Assert.assertTrue;

public class SelectDateStep {

    private SelectDatesPage selectDatesPage;

    @And("^Selecciono el CheckIn y CheckOut$")
    public void seleccionoElCheckInYCheckOut() throws Exception {
        selectDatesPage = new SelectDatesPage();
        try{
            assertTrue(selectDatesPage.verificarSelectDates());
        } catch(AssertionError e) {
            throw new Exception("Falló al validar la vista Select Dates");
        }finally {
            selectDatesPage.takeScreenShot();
        }
        selectDatesPage.clickIn();
        selectDatesPage.clickOut();
        selectDatesPage.clickSelect();
        selectDatesPage.takeScreenShot();
    }



}
