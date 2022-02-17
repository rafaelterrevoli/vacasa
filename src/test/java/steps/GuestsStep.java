package steps;

import cucumber.api.java.en.And;
import pages.GuestsPage;
import pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class GuestsStep {

    private GuestsPage guestsPage;

    @And("^Selecciono guests$")
    public void seleccionoGuests() throws Exception {
        guestsPage = new GuestsPage();
        try{
            assertTrue(guestsPage.verificarGuests());
        } catch(AssertionError e) {
            throw new Exception("Falló al validar la vista del Search");
        }finally {
            guestsPage.takeScreenShot();
        }
        guestsPage.hacerClickAdultsPlusBtn();
        guestsPage.hacerClickSave();
        guestsPage.takeScreenShot();
    }
}
