Feature: Login

  Background: Abrir la app
    Given Abro la aplicacion

  @test
  Scenario: Validar los fitros de busqueda
    When Presiono boton Do not allow
    And Me encuentro en el home
    And Hago click en Dates
    And Selecciono el CheckIn y CheckOut
    And Hago click en guests
    And Selecciono guests
    And Hago click en filters
    And Selecciono cantidad de bedrooms
    And Hago click en buscar
    #And Selecciono el lugar
    #Then Visualizo el resultado














