# Senbike-api
![Build Status](https://66.media.tumblr.com/92bad2e4f58f7a89cbdb0689e7e56a83/6497e73f0aa1a381-13/s1280x1920/a7051af84cb644b74a5ea65f40c7cbe8cf5f2ba9.png)
## Bicicletero
 
### ***server:puerto/bicicletero***


> **GET**
>Lista todos los bicicleteros
**POST**
>Agrega un bicicletero, 
```sh
{
    "bicicleteroId": <long>,
    "descripcion":<String>,
    "espacios": <int>
}
```
 
### ***server:puerto/bicicletero/{bicicleteroId}***

> **GET**
> Retorna el bicicletero con el id ingresado

> **DELETE**
> Elimina el bicicletero con el id ingresado

### server:puerto/bicicletero/{bicicleteroId}/espacios

> **GET**
> Retorna el numero de espacios vacios
  
### ***server:puerto/bicicletero/{bicicleteroId}/buscar/{tuiId}***
> **GET**
> Busca en el bicicletero con la id del bicicletero ingresada, la existencia de una bicicleta,
 la bicicleta que se busca debe poseer la identificación de la tarjeta tui que fue ingresada. 
 Si la bicicleta se encuentra en la base de datos, se retorna TRUE, en caso contrario FALSE

# BIKE
 
## ***server:puerto/bicicletero/{bicicleteroId}/bike***

> **GET**
>Retorna todas las bicicletas que esten asociadas al id del bicicletero

> **POST**
>   Agrega una bicicleta. 
> -No se pueden agregar mas bicicletas que el numero de espacios asignado al bicicletero.
> -No se puede agregar bicicleta a un espacio ya ocupado.
> -No se puede agregar mas de una bicicleta con una tui (1 TUI = 1 Bicicleta).
```sh
{
    "tuiId": <long>,
    "espacioDesignado": <int>
}
```

 ## ***server:puerto/bicicletero/{bicicleteroId}/bike/{tuiId}***
 
> **DELETE** 
> Elimina la bicicleta con el id ingresado

> **GET**
> Retorna la bicicleta con el con id ingresado


