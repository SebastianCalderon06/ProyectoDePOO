
import java.util.ArrayList;
import java.util.List;
// por fa revisa ahorita si esta bien
public class GestorProducto {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {

        productos.add(producto);
    }

    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
