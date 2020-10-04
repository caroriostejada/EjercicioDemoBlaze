# language: es

Característica: Compra de un dispositivo laptop "Dell i7 8gb".

  Esquema del escenario: Comprar una laptop marca Dell
    Dado que ingreso a la pagina para realizar la compra de la laptop
    Cuando busco la categoria requerida para realizar la compra
    Entonces elijo el producto deseado
    Y realizo el proceso de compra con los datos del cliente <nombre>, <pais>, <ciudad>, <numeroTarjeta>, <mesTarjeta>, <anioTarjeta> y <mensajeExito>
    Ejemplos:
      | nombre           | pais     | ciudad   | numeroTarjeta | mesTarjeta | anioTarjeta | mensajeExito                 |
      | Angelica Barrera | Colombia | Medellin | 322355671654  | 12         | 2024        | Thank you for your purchase! |