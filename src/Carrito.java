import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto p : productos) {
                System.out.println("- " + p);
            }
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public double calcularTotalConDescuentos(boolean aplicarCodigo) {
    double total = calcularTotal();

        // Descuento automático si pasa los $50.000
        if (total > 50000) {
            System.out.println("Descuento automático de 10% aplicado por compras sobre $50.000");
            total *= 0.9;
        }

        // Descuento por código
        if (aplicarCodigo) {
            System.out.println("Código de descuento aplicado: -10%");
            total *= 0.9;
        }

        return total;
    }

    public void mostrarResumenCompra(boolean aplicarCodigo) {
        System.out.println("\n Resumen de tu compra:");
        for (Producto producto : productos) {
            System.out.println("- " + producto);
        }

        double total = calcularTotal();
        double totalConDescuento = calcularTotalConDescuentos(aplicarCodigo);

        System.out.println("\nTotal sin descuento: $" + total);
        System.out.println("Total con descuentos: $" + totalConDescuento);
    }

}
