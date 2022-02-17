package steps;

import cucumber.api.java.en.And;
import pages.FiltersPage;
import pages.GuestsPage;

import static org.junit.Assert.assertTrue;

public class FiltersStep {

    private FiltersPage filtersPage;

    @And("^Selecciono cantidad de bedrooms$")
    public void seleccionoCantidadDeBedrooms() throws Exception {
        filtersPage = new FiltersPage();
        try{
            assertTrue(filtersPage.verificarFiltersPage());
        } catch(AssertionError e) {
            throw new Exception("Falló al validar la vista Filters");
        }finally {
            filtersPage.takeScreenShot();
        }
        filtersPage.hacerClickBedroomPlusBtn();
        filtersPage.hacerClickSave();
        filtersPage.takeScreenShot();
    }
}
