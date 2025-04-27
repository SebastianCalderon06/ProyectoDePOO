import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Proveedor {

    private int id;
    private String nombre;
    private String direccion;
    private List<Producto> productos = new ArrayList<>(); // ← Agregado

    public Proveedor(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void agregarProducto(Producto producto) {

        productos.add(producto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Proveedor{id=" + id +
                ", nombre='" + nombre +
                "', direccion='" + direccion +
                "', productos=" + productos + "}";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Proveedor proveedor = (Proveedor) o;
            return id == proveedor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


