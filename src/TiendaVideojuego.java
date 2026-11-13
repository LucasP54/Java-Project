import java.util.Scanner;

public class TiendaVideojuego {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double dinero = 1000;
        double ingresos = 0;
        double gastos = 0;
        int dia = 1;
        int clientesConCompra = 0;
        boolean partidaActiva = true;
        boolean atendidosHoy = false;

        String[] juegos = {"Minecraft", "FIFA", "Mario Kart", "Zelda", "Pokémon"};

        double[] preciosCompra = {25, 30, 20, 35, 15};
        double[] preciosVenta = {40, 45, 32, 50, 25};
        int[] existencias = {2, 2, 2, 2, 2};

        int opcion;
        String nombreTienda;

        System.out.print("Introduce un nombre para tu tienda: ");
        nombreTienda = teclado.nextLine().trim();

        while (nombreTienda.isEmpty()) {
            System.out.println("El nombre de la tienda no puede estar vacío.");
            System.out.print("Introduce un nombre para tu tienda: ");
            nombreTienda = teclado.nextLine().trim();
        }

        System.out.println("===============================");
        System.out.println("Bienvenido a " + nombreTienda);
        System.out.println("===============================");
        System.out.println("Empiezas con 1000 euros");
        System.out.println("Consigue 2500 euros antes de terminar el día 15");
        System.out.println();

        while (partidaActiva) {

            System.out.println("\n----------- MENÚ -----------");
            System.out.println("Día: " + dia + " / 15");
            System.out.printf("Dinero: %.2f euros%n", dinero);
            System.out.println("1. Comprar videojuegos");
            System.out.println("2. Cambiar precios de venta");
            System.out.println("3. Atender a los clientes");
            System.out.println("4. Consultar estadísticas");
            System.out.println("5. Avanzar al siguiente día");
            System.out.println("6. Consultar inventario");
            System.out.println("7. Salir de la partida");
            System.out.print("Elige una opción: ");

            if (!teclado.hasNextInt()) {
                System.out.println("Debes introducir un número del 1 al 7.");
                teclado.nextLine();
                continue;
            }

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    // Comprar videojuegos

                    System.out.println("\n--- INVENTARIO ---");

                    for (int i = 0; i < juegos.length; i++) {
                        System.out.printf("%d. %-12s | Compra: %6.2f euros | Venta: %6.2f euros | Stock: %d%n",
                                i + 1, juegos[i], preciosCompra[i],
                                preciosVenta[i], existencias[i]);
                    }

                    System.out.print("Número del videojuego (1-5): ");

                    if (!teclado.hasNextInt()) {
                        System.out.println("Debes introducir un número válido.");
                        teclado.nextLine();
                        break;
                    }

                    int producto = teclado.nextInt() - 1;

                    if (producto >= 0 && producto < juegos.length) {

                        System.out.print("Cantidad que quieres comprar: ");

                        if (!teclado.hasNextInt()) {
                            System.out.println("Debes introducir una cantidad numérica.");
                            teclado.nextLine();
                            break;
                        }

                        int cantidad = teclado.nextInt();

                        if (cantidad > 0) {

                            if (cantidad > Integer.MAX_VALUE - existencias[producto]) {
                                System.out.println("La cantidad es demasiado grande.");

                            } else {
                                double coste = preciosCompra[producto] * cantidad;

                                if (coste <= dinero) {
                                    dinero = dinero - coste;
                                    gastos = gastos + coste;
                                    existencias[producto] =
                                            existencias[producto] + cantidad;

                                    System.out.println("Has comprado " + cantidad
                                            + " unidades de " + juegos[producto] + ".");

                                } else {
                                    System.out.println("No tienes suficiente dinero.");
                                }
                            }

                        } else {
                            System.out.println("La cantidad debe ser mayor que cero.");
                        }

                    } else {
                        System.out.println("Videojuego no válido.");
                    }
                    break;

                case 2:
                    // Cambiar precios de venta

                    System.out.println("\n--- INVENTARIO ---");

                    for (int i = 0; i < juegos.length; i++) {
                        System.out.printf("%d. %-12s | Compra: %6.2f euros | Venta: %6.2f euros | Stock: %d%n",
                                i + 1, juegos[i], preciosCompra[i],
                                preciosVenta[i], existencias[i]);
                    }

                    System.out.print("Número del videojuego (1-5): ");

                    if (!teclado.hasNextInt()) {
                        System.out.println("Debes introducir un número válido.");
                        teclado.nextLine();
                        break;
                    }

                    producto = teclado.nextInt() - 1;

                    if (producto >= 0 && producto < juegos.length) {

                        System.out.print("Nuevo precio de venta: ");

                        if (!teclado.hasNextDouble()) {
                            System.out.println("Debes introducir un precio numérico válido.");
                            teclado.nextLine();
                            break;
                        }

                        double nuevoPrecio = teclado.nextDouble();

                        if (nuevoPrecio > 0 && Double.isFinite(nuevoPrecio)) {

                            preciosVenta[producto] = nuevoPrecio;
                            System.out.println("Precio actualizado.");

                            if (nuevoPrecio < preciosCompra[producto]) {
                                System.out.println("Advertencia: estás vendiendo por debajo del precio de compra.");
                                System.out.println("Podrías perder dinero con esta venta.");
                            }

                        } else {
                            System.out.println("El precio debe ser mayor que cero.");
                        }

                    } else {
                        System.out.println("Videojuego no válido.");
                    }
                    break;

                case 3:
                    // Atender a los clientes

                    if (atendidosHoy) {
                        System.out.println("Ya has atendido a los clientes de hoy.");

                    } else {
                        atendidosHoy = true;

                        // Aparecen 3 clientes al día

                        for (int i = 1; i <= 3; i++) {

                            int productoCliente =
                                    (int) (Math.random() * juegos.length);

                            // Cada cliente tiene un presupuesto entre 25 y menos de 55 euros

                            double presupuesto = 25 + Math.random() * 30;

                            System.out.println("\nCliente " + i
                                    + " quiere comprar " + juegos[productoCliente] + ".");

                            System.out.printf("Presupuesto del cliente: %.2f euros%n",
                                    presupuesto);

                            if (existencias[productoCliente] > 0
                                    && preciosVenta[productoCliente] <= presupuesto) {

                                existencias[productoCliente]--;
                                dinero = dinero + preciosVenta[productoCliente];
                                ingresos = ingresos + preciosVenta[productoCliente];
                                clientesConCompra++;

                                System.out.printf("Venta realizada por %.2f euros.%n",
                                        preciosVenta[productoCliente]);

                            } else if (existencias[productoCliente] == 0) {

                                System.out.println("No quedan unidades de ese juego.");

                            } else {
                                System.out.println("El cliente no acepta ese precio.");
                            }
                        }
                    }
                    break;

                case 4:
                    // Consultar estadísticas

                    System.out.println("\n--- ESTADÍSTICAS ---");
                    System.out.printf("Ingresos por ventas: %.2f euros%n", ingresos);
                    System.out.printf("Gastos en compras: %.2f euros%n", gastos);
                    System.out.printf("Resultado acumulado: %.2f euros%n", ingresos - gastos);
                    System.out.println("Clientes con compra: " + clientesConCompra);
                    System.out.printf("Dinero actual: %.2f euros%n", dinero);
                    break;

                case 5:
                    // Avanzar al día siguiente

                    if (dia < 15) {
                        dia++;
                        atendidosHoy = false;

                        System.out.println("Comienza el día " + dia + ".");

                    } else {
                        System.out.println("\nHas llegado al final del día 15.");
                        System.out.println("No has conseguido el objetivo a tiempo.");
                        partidaActiva = false;
                    }
                    break;

                case 6:
                    // Consultar inventario

                    System.out.println("\n--- INVENTARIO ---");

                    for (int i = 0; i < juegos.length; i++) {
                        System.out.printf("%d. %-12s | Compra: %6.2f euros | Venta: %6.2f euros | Stock: %d%n",
                                i + 1, juegos[i], preciosCompra[i],
                                preciosVenta[i], existencias[i]);
                    }
                    break;

                case 7:
                    partidaActiva = false;
                    System.out.println("Has salido de la partida.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            // Comprobar victoria o derrota

            if (partidaActiva && dinero >= 2500) {

                System.out.println("\n¡ENHORABUENA! Has conseguido 2500 euros.");
                System.out.println("¡Has ganado la partida!");
                partidaActiva = false;

            } else if (partidaActiva && dinero <= 0) {

                boolean quedanExistencias = false;

                for (int i = 0; i < existencias.length; i++) {
                    if (existencias[i] > 0) {
                        quedanExistencias = true;
                    }
                }

                if (!quedanExistencias) {
                    System.out.println("\nHas perdido: no tienes dinero ni videojuegos.");
                    partidaActiva = false;
                }
            }
        }

        teclado.close();
        System.out.println("Fin del juego.");
    }
}