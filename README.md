# senbike-api

# senBike-Smart

Api senbike

*BICICLETERO*
 
server:puerto/bicicletero

    GET-> Lista todos los bicicleteros
    POST-> Agrega un bicicletero, {
                                    "bicicleteroId": <long>,
                                    "descripcion":<String>,
                                    "espacios": <int>
                                  }
 
server:puerto/bicicletero/{bicicleteroId}

    GET-> Retorna el bicicletero con el con id ingresado
    DELETE-> Elimina el bicicletero con el id ingresado

server:puerto/bicicletero/{bicicleteroId}/espacios

    GET-> Retorna el numero de espacios vacios
  
server:puerto/bicicletero/{bicicleteroId}/buscar/{tuiId}

    GET -> Busca en bicicletero con con la id del bicicletero una bicicleta 
           con id de su tarjeta TUI, si eiste retorna TRUE, si no existe retorna FALSE.
 
*BIKE*
 
server:puerto/bicicletero/{bicicleteroId}/bike

    GET-> Retorna todas las bicicletas que esten asociadas al id del bicicletero
    POST-> Agrega una bicicleta {
                                  "tuiId": <long>,
                                  "espacioDesignado": <int>
                                }
 
          No se pueden agregar mas bicicletas que el numero de espacios asignado al bicicletero.

 server:puerto/bicicletero/{bicicleteroId}/bike/{tuiId}
 
    DELETE -> Elimina la bicicleta con el id ingresado
    GET -> Retorna la bicicleta con el con id ingresado
