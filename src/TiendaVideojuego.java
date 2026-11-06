import java.util.Scanner;

public class TiendaVideojuego {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double dinero = 1000;
        double ingresos = 0;
        double gastos = 0;
        int dia = 1;
        int clientesAtendidos = 0;
        boolean partidaActiva = true;
        boolean atendidosHoy = false;

        String[] juegos = {"Minecraft", "FIFA", "Mario Kart", "Zelda", "Pokémon"};

        double[] preciosCompra = {25, 30, 20, 35, 15};
        double[] preciosVenta = {40, 45, 32, 50, 25};
        int[] existencias = {2, 2, 2, 2, 2};

        int opcion;
            String nombreTienda;
            System.out.println("Introduce un nombre para tu tienda: ");
            nombreTienda=teclado.nextLine();
            System.out.println("===============================");
            System.out.println("Bienvenido a " + nombreTienda);
            System.out.println("===============================");
            System.out.println("Empiezas con 1000 euros ");
            System.out.println("Consigue 2500 antes del día 15");
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

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    // Comprar videojuegos

                    System.out.println("\n--- INVENTARIO ---");

                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println((i + 1) + ". " + juegos[i] + " | Compra: " + preciosCompra[i] + " euros" 
                        + " | Venta: " + preciosVenta[i] + " euros" + " | Stock: " + existencias[i]);
                    }

                    System.out.print("Número del videojuego (1-5): ");
                    int producto = teclado.nextInt() - 1;

                    if (producto >= 0 && producto < juegos.length) {

                        System.out.print("Cantidad que quieres comprar: ");
                        int cantidad = teclado.nextInt();

                        if (cantidad > 0) {

                            double coste = preciosCompra[producto] * cantidad;

                            if (coste <= dinero) {
                                dinero = dinero - coste;
                                gastos = gastos + coste;
                                existencias[producto] =
                                    existencias[producto] + cantidad;

                                System.out.println(
                                    "Has comprado " + cantidad + " unidades de " + juegos[producto] + "." );

                            } else {
                                System.out.println("No tienes suficiente dinero.");
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
                        System.out.println((i + 1) + ". " + juegos[i] + " | Compra: " + preciosCompra[i] + " euros" + " | Venta: " 
                        + preciosVenta[i] + " euros" + " | Stock: " + existencias[i]);
                    }

                    System.out.print("Número del videojuego (1-5): ");
                    producto = teclado.nextInt() - 1;

                    if (producto >= 0 && producto < juegos.length) {

                        System.out.print("Nuevo precio de venta: ");
                        double nuevoPrecio = teclado.nextDouble();

                        if (nuevoPrecio > 0) {
                            preciosVenta[producto] = nuevoPrecio;
                            System.out.println("Precio actualizado.");

                        } else {
                            System.out.println(
                                "El precio debe ser mayor que cero.");
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

                            // Cada cliente tiene un presupuesto

                            double presupuesto =
                                25 + Math.random() * 30;

                            System.out.println("\nCliente " + i+ " quiere comprar "+ juegos[productoCliente] + ".");

                            if (existencias[productoCliente] > 0
                                && preciosVenta[productoCliente]
                                <= presupuesto) {

                                existencias[productoCliente]--;
                                dinero = dinero
                                    + preciosVenta[productoCliente];
                                ingresos = ingresos
                                    + preciosVenta[productoCliente];
                                clientesAtendidos++;

                                System.out.println("Venta realizada por " + preciosVenta[productoCliente] + " euros.");

                            } else if (
                                existencias[productoCliente] == 0) {

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
                    System.out.printf("Beneficio: %.2f euros%n", ingresos - gastos);
                    System.out.println("Clientes atendidos: " + clientesAtendidos);
                    System.out.printf("Dinero actual: %.2f euros%n", dinero);
                    break;

                case 5:
                    // Avanzar al día siguiente

                    if (dia < 15) {
                        dia++;
                        atendidosHoy = false;

                        System.out.println("Comienza el día " + dia + ".");

                    } else {
                        System.out.println("Has llegado al último día.");
                    }
                    break;

                case 6:
                    // Consultar inventario

                    System.out.println("\n--- INVENTARIO ---");

                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println((i + 1) + ". " + juegos[i]+ " | Compra: " + preciosCompra[i] 
                        + " euros"+ " | Venta: " + preciosVenta[i] + " euros"+ " | Stock: " + existencias[i]);
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

            if (partidaActiva && dinero <= 0) {

                System.out.println("\nHas perdido: te has quedado sin dinero.");

                partidaActiva = false;

            } else if (partidaActiva && dinero >= 2500) {

                System.out.println("\n¡ENHORABUENA! Has conseguido 2500 euros.");
                System.out.println("¡Has ganado la partida!");
                partidaActiva = false;

            } else if (partidaActiva && dia == 15
                       && opcion == 5) {

                System.out.println("\nHas llegado al final del día 15.");
                System.out.println("No has conseguido el objetivo a tiempo.");

                partidaActiva = false;
            }
        }

        teclado.close();
        System.out.println("Fin del juego.");
    }
}
