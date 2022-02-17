package steps;

import cucumber.api.java.en.And;
import pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class SearchStep {

    private SearchPage searchPage;

    @And("^Selecciono el lugar$")
    public void seleccionoElLugar() throws Exception {
        searchPage = new SearchPage();
        try{
            assertTrue(searchPage.verificarSearch());
        } catch(AssertionError e) {
            throw new Exception("Falló al validar la vista del Search");
        }finally {
            searchPage.takeScreenShot();
        }
        searchPage.ingresaLugar();
        searchPage.takeScreenShot();
    }
}
