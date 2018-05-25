Feature: Busqueda de tiquetes
  Yo como usuario de Despegar quiero poder consultar y seleccionar los tiquetes mas baratos 
   
  @Test  
  Scenario Outline: Consulta de vuelo exitosa
    Given el usuario esta en la pagina Despegar
    When el usuario selecciona el menu vuelos
    And el usuario ingresa el tipo de vuelo 
    And el usuario ingresa el origen "<ciudadOrigen>"
    And el usuario ingresa el destino "<ciudadDestino>"
    And el usuario selecciona el numero de pasajeros "<numeroPasajeros>"
    And el usuario selecciona fecha partida "<fechaPartida>"
    And el usuario selecciona fecha de regreso "<fechaRegreso>"
    And el usuario presiona boton buscar
    And el usuario esta en la pagina de resultado de vuelos
    And se seleccionan y ordenan los precios de vuelos
    Then Se exportan los precios a un archivo excel
    
    
  Examples:
  | ciudadOrigen | ciudadDestino | numeroPasajeros | fechaPartida | fechaRegreso |
  | Medellin | Cartagena | 2 | 01/09/2018 | 29/09/2018 |
  
     
 	@Test  
  Scenario Outline: Consulta de vuelo sin ciudad Destino Fallida
  Given el usuario esta en la pagina Despegar
   When el usuario selecciona el menu vuelos
   And el usuario ingresa el tipo de vuelo 
   And el usuario ingresa el origen "<ciudadOrigen>"
   And el usuario ingresa el destino "<ciudadDestino>"
   And el usuario selecciona el numero de pasajeros "<numeroPasajeros>"
   And el usuario selecciona fecha partida "<fechaPartida>"
   And el usuario selecciona fecha de regreso "<fechaRegreso>"
   And el usuario presiona boton buscar
   Then el usuario visualiza mensaje error ingrese ciudad destino
    
  Examples:
 | ciudadOrigen | ciudadDestino | numeroPasajeros | fechaPartida | fechaRegreso |
 | Medellin |   | 2 | 01/09/2018 | 29/09/2018 |
  
    
 @Test  
 Scenario Outline: Consulta de vuelo con ciudades iguales Fallida
 Given el usuario esta en la pagina Despegar
 When el usuario selecciona el menu vuelos
 And el usuario ingresa el tipo de vuelo 
 And el usuario ingresa el origen "<ciudadOrigen>"
 And el usuario ingresa el destino "<ciudadDestino>"
 And el usuario selecciona el numero de pasajeros "<numeroPasajeros>"
 And el usuario selecciona fecha partida "<fechaPartida>"
 And el usuario selecciona fecha de regreso "<fechaRegreso>"
 And el usuario presiona boton buscar
 Then el usuario visualiza mensaje error ciudades iguales
    
 Examples:
 | ciudadOrigen | ciudadDestino | numeroPasajeros | fechaPartida | fechaRegreso |
 | Monteria | Monteria   | 2 | 01/09/2018 | 29/09/2018 |
  
 
  


   	

    