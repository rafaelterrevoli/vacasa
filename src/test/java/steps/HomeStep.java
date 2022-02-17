package steps;


import base.BaseAppium;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

import static org.junit.Assert.assertTrue;


public class HomeStep {

    private HomePage homePage;
    private BaseAppium baseAppium;

    @Given("^Abro la aplicacion$")
    public void abroLaAplicacion() throws Exception {
        try {
            baseAppium = new BaseAppium();
            baseAppium.init();
            homePage = new HomePage();
            assertTrue(homePage.verificarAppDisponible());
        } catch(AssertionError e) {
            throw new Exception("Falló la carga de la app");
        }
    }

    @When("^Presiono boton Do not allow$")
    public void presionoBotonDoNotAllow() {
        homePage.takeScreenShot();
        homePage.clickDontAllowBtn();
    }

    @And("^Me encuentro en el home$")
    public void meEncuentroEnElHome() throws Exception {
        try{
        assertTrue(homePage.verificarBusquedaHome());
        } catch(AssertionError e) {
            throw new Exception("Falló al validar las opciones de busqueda");
        }finally {
            homePage.takeScreenShot();
        }
    }

    @And("^Hago click en Dates$")
    public void hagoClickEnDates() throws InterruptedException {
       homePage.clickDatesBtn();
    }

    @And("^Hago click en buscar$")
    public void hagoClickEnBuscar()  {
        homePage.clickSearch();
    }

    @And("^Hago click en guests$")
    public void hagoClickEnGuests()  {
        homePage.clickGuestsBtn();
    }

    @And("^Hago click en filters$")
    public void hagoClickEnFilters() {
        homePage.clickFiltersBtn();
    }

    @Then("^Visualizo el resultado$")
    public void visualizoElResultado() throws Exception {
        try{
            assertTrue(homePage.verificarResult());
        } catch(AssertionError e) {
            throw new Exception("Falló al validar resultado de la busqueda");
        }finally {
            homePage.takeScreenShot();
        }

    }



}

