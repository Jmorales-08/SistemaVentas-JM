import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Usuario usuarioValido = new Usuario("admin", "1234");
        boolean autenticado = false;

        // Login
        while (!autenticado) {
            System.out.print("Usuario: ");
            String nombre = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (usuarioValido.getNombre().equals(nombre) &&
                usuarioValido.validarPassword(password)) {
                System.out.println("Bienvenido al sistema de ventas.");
                autenticado = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos.\n");
            }
        }

        // Lista de productos disponibles
        List<Producto> productosDisponibles = new ArrayList<>();
        productosDisponibles.add(new Producto("Polera", 19990));
        productosDisponibles.add(new Producto("Zapatillas", 45990));
        productosDisponibles.add(new Producto("Jeans", 29990));
        productosDisponibles.add(new Producto("Chaqueta", 59990));

        Carrito carrito = new Carrito();
        int opcion;

        do {
            System.out.println("\n--- Bienvenido! :) Si eres nuevo usario hay un descuento disponible ingresando BIENVENIDO10 ;) ---");
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver productos disponibles");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Ver total a pagar");
            System.out.println("5. Ver total con descuentos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Productos disponibles:");
                    for (int i = 0; i < productosDisponibles.size(); i++) {
                        System.out.println((i + 1) + ". " + productosDisponibles.get(i));
                    }
                    break;
                case 2:
                    System.out.print("Ingresa el número del producto a agregar: ");
                    int num = scanner.nextInt();
                    if (num >= 1 && num <= productosDisponibles.size()) {
                        Producto p = productosDisponibles.get(num - 1);
                        carrito.agregarProducto(p);
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 3:
                    carrito.mostrarProductos();
                    break;
                case 4:
                    System.out.println("Total a pagar: $" + carrito.calcularTotal());
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("¿Tienes un código de descuento? (s/n): ");
                    String tieneCodigo = scanner.nextLine().toLowerCase();
                    boolean aplicarCodigo = false;

                    if (tieneCodigo.equals("s")) {
                        System.out.print("Ingresa tu código: ");
                        String codigo = scanner.nextLine();
                        if (codigo.equalsIgnoreCase("BIENVENIDO10")) {
                            aplicarCodigo = true;
                        } else {
                            System.out.println("Código inválido.");
                        }
                    }

                    double totalConDescuento = carrito.calcularTotalConDescuentos(aplicarCodigo);
                    System.out.println("Total final a pagar: $" + totalConDescuento);
                    break;
                case 6:
                    System.out.print("¿Tienes un código de descuento? (s/n): ");
                    String tieneCodigoResumen = scanner.nextLine().toLowerCase();
                    boolean aplicarCodigoResumen = false;

                    if (tieneCodigoResumen.equals("s")) {
                        System.out.print("Ingresa tu código: ");
                        String codigoResumen = scanner.nextLine();
                        if (codigoResumen.equalsIgnoreCase("BIENVENIDO10")) {
                            aplicarCodigoResumen = true;
                        } else {
                            System.out.println("Código inválido.");
                        }
                    }

                    carrito.mostrarResumenCompra(aplicarCodigoResumen);
                break;
                case 7:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
