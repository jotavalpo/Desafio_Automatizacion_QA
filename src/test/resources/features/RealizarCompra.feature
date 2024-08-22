Feature: Realizar compra
  Quiero seleccionar productos, agregarlos al carrito, realizar checkout y revisar historial

  @compraExitosa
  Scenario: Realizar compra exitosa
    Given Estoy en el home
    When Busco un Ipod Classic y lo agrego al carrito
    And Busco un iMac y lo agrego al carrito
    And Voy al carrito de compras y valido que esten agregados "iMac" y "iPod Classic"
    And Ingreso al checkout
    And Inicio sesion usando las credenciales del archivo "src/test/resources/credenciales.csv"
    And Indico la direccion de facturacion
    And Indico la direccion de entrega
    And Indico el metodo de envio y valido que sea "Flat Shipping Rate - $5.00"
    And Indico el metodo de pago
    And Finalizo el proceso de compra y valido que el monto total sea "$205.00"
    And Voy al historial de compras
    Then Valido que compra quede en estado pendiente