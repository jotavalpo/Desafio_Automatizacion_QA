Feature: Crear Cuenta
  Quiero crear una cuenta en el sitio

  @crearCuentaExitosamente
  Scenario: Crear cuenta de manera exitosa
    Given Estoy en el home
    When Voy a My Account y hago clic en opcion Register
    And Completo los datos personales
    And Creo la password
    And Indico si quiero suscribirme al boletin
    And Acepto los terminos & condiciones y creo la cuenta
    Then Valido que la cuenta se haya creado exitosamente
