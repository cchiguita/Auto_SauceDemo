Feature: Flujo de compra exitoso en saucedemo
  Como usuario del sitio SauceDemo
  Quiero poder realizar una compra exitosa
  Para validar que el flujo de compra funcione correctamente

  Background:
    Given el usuario accede al sitio web

  @test
  Scenario Outline: Compra exitosa de productos
    When el usuario inicia sesión usando los datos del Excel
    And agrega "<cantidad_productos>"  al carrito
    And ir al carrito de compras
    And proceed to checkout
    And Completa el formulario de compra
    And confirma la orden
    Then valida el  mensaje de "<mensaje_confirmacion>"

      Examples:
        | cantidad_productos | mensaje_confirmacion      |
        | 3                  | Thank you for your order! |
