
import java.util.ArrayList;
import java.util.List;
public class GestorProducto {
    private List<Producto> productos = new ArrayList<>();


    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    // cambiamos para que el metodo muestre un mensaje en caso de no encontrar lo que buscamos

    public String buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return "Producto encontrado: " + producto;
            }
        }
        return "No se encontró o no existe el producto buscado.";
    }
}





