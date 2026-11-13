# Tienda de Videojuegos

Proyecto de programación en Java desarrollado durante la primera evaluación de 1.º de DAW (curso 2026-2027).

## Descripción

Tienda de Videojuegos es un juego de gestión por consola en el que el jugador administra una tienda. Debe comprar videojuegos, modificar sus precios y atender clientes para conseguir dinero antes de que termine el plazo disponible.

## Objetivo del juego

El jugador comienza con **1.000 €** y tiene **15 días** para conseguir un saldo de **2.500 € o más**.

- **Victoria:** alcanzar 2.500 € o más de dinero disponible.
- **Derrota por tiempo:** terminar el día 15 sin alcanzar el objetivo.
- **Derrota por falta de recursos:** quedarse sin dinero y sin existencias.
- **Salida voluntaria:** abandonar la partida desde el menú.

## Videojuegos disponibles

| Videojuego | Precio de compra | Precio inicial de venta | Stock inicial |
|---|---:|---:|---:|
| Minecraft | 25 € | 40 € | 2 |
| FIFA | 30 € | 45 € | 2 |
| Mario Kart | 20 € | 32 € | 2 |
| Zelda | 35 € | 50 € | 2 |
| Pokémon | 15 € | 25 € | 2 |

## Funcionalidades

El menú principal contiene siete opciones:

1. Comprar videojuegos.
2. Modificar precios de venta.
3. Atender clientes.
4. Consultar estadísticas económicas.
5. Avanzar al siguiente día.
6. Consultar inventario.
7. Salir del juego.

Cada día aparecen tres clientes aleatorios. Cada uno solicita un videojuego y dispone de un presupuesto. La venta se realiza cuando hay existencias y el precio no supera su presupuesto.

Solo se puede atender a los clientes una vez por día.

## Validaciones y mejoras

La versión corregida incluye:

- Control de entradas no numéricas.
- Rechazo de cantidades negativas o iguales a cero.
- Comprobación de productos inexistentes.
- Comprobación del dinero disponible antes de comprar.
- Control del inventario para evitar existencias negativas.
- Posibilidad de continuar jugando con 0 € si todavía quedan videojuegos.
- Aceptación de precios decimales.
- Aviso cuando se establece un precio de venta inferior al de compra.
- Finalización de la partida al superar el límite de 15 días.

## Cómo ejecutar el juego

1. Tener Java instalado.
2. Descargar o clonar este repositorio.
3. Abrir una terminal en la carpeta que contiene el archivo `.java`.
4. Compilar y ejecutar el programa.

Ejemplo, si la clase principal se llama `TiendaVideojuego`:

```bash
javac TiendaVideojuego.java
java TiendaVideojuego
```

## Pruebas realizadas

Se han realizado 14 casos de prueba funcionales para comprobar las compras, las ventas, el inventario, las validaciones, el avance de días y las condiciones de victoria y derrota.

Los 14 casos de prueba se han superado.

## Documentación

La memoria del proyecto, con las explicaciones técnicas, las pruebas realizadas y las capturas de ejecución, se encuentra en la carpeta `docs/`.

## Tecnologías utilizadas

- Java.
- Visual Studio Code.
- Git y GitHub.

## Autor

Lucas Petrucci Panadero

**Versión:** 1.1 — Correcciones de la primera evaluación.